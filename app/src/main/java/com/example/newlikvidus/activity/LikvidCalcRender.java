package com.example.newlikvidus.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newlikvidus.LikvidCalculator;
import com.example.newlikvidus.LikvidusCalcAdapter;
import com.example.newlikvidus.R;
import com.example.newlikvidus.data.AppDatabase;
import com.example.newlikvidus.data.DbIdConstants;
import com.example.newlikvidus.data.dao.CharacterDao;
import com.example.newlikvidus.data.dao.ValueDao;
import com.example.newlikvidus.data.entities.Character;
import com.example.newlikvidus.data.entities.Save;
import com.example.newlikvidus.data.entities.Value;

import java.util.ArrayList;
import java.util.List;

public class LikvidCalcRender extends AppCompatActivity {

    private AppDatabase db;
    private Save save;
    private long type_id;
    private ValueDao valueDao;
    private List<Value> valueList;
    private CharacterDao characterDao;
    private List<Character> characterList;
    private boolean ready = false;
    private static Context context;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private TextView resultDescription, resultDescription1, resultDescription2, resultValue, resultValue1, resultValue2, resultValue3, resultValue4;

    private LikvidCalculator likvidCalculator;
    private List<Float> unswerList;
    private LikvidusCalcAdapter adapter;
    private List<Float> inputValueList;
    ImageButton saveImageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_likvid_calc);

        resultDescription = findViewById(R.id.resultDescriptionText);
        resultDescription1 = findViewById(R.id.resultDescriptionText1);
        resultDescription2 = findViewById(R.id.resultDescriptionText2);

        resultValue = findViewById(R.id.resultValueText);
        resultValue1 = findViewById(R.id.resultValueText1);
        resultValue2 = findViewById(R.id.resultValueText2);
        resultValue3 = findViewById(R.id.resultValueText3);
        resultValue4 = findViewById(R.id.resultValueText4);

        saveImageButton = findViewById(R.id.saveButton);

        Bundle arguments = getIntent().getExtras();
        try{
            save = (Save) arguments.get("save");
            type_id = save.getType_id_fk();
            Log.e("SAVE_VALUE", save.toString());
        } catch (Exception e){
            try {
                type_id = arguments.getLong("type_id");
                Log.e("TYPE_VALUE", String.valueOf(type_id));
            } catch (Exception ex){
                Log.e("SUKA", "ПИЗДЕЦ");
            }
        }

        recyclerView = findViewById(R.id.calcList);
        layoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(layoutManager);

        db = AppDatabase.getInstance(this);
        context = this;

        new Thread(new Runnable() {
            @Override
            public void run() {
                valueDao = db.valueDao();
                characterDao = db.characterDao();

                List<String> characterNameList = new ArrayList<>();
                List<Float> characterValueList = new ArrayList<>();
                List<Float> characterKoefList = new ArrayList<>();

                characterList = characterDao.getAllByType_id(type_id);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        resultDescription.setText(characterList.get(0).getDescription());
                        resultDescription1.setText(characterList.get(1).getDescription());
                        resultDescription2.setText(characterList.get(3).getDescription());
                    }
                });

                if(save == null){
                    for (Character character: characterList) {
                        characterNameList.add(character.getName());
                        characterValueList.add(character.getDefault_value());
                        characterKoefList.add(character.getKoef());
                    }
                } else{
                    for (Character character: characterList) {
                        characterNameList.add(character.getName());
                        characterKoefList.add(character.getKoef());
                        Log.e("Char_ID", String.valueOf(character.getCharacter_id()));
                        Log.e("Save_ID", String.valueOf(save.getSave_id()));

//                        characterValueList.add(valueDao.getByCharacter_idAndSave_id(character.getCharacter_id(), save.getSave_id()).getValue());
                    }
                    characterValueList.add(valueDao.getByCharacter_idAndSave_id(DbIdConstants.ID_RESULT, save.getSave_id()).getValue());

                    characterValueList.add(characterList.get(1).getDefault_value());
                    characterValueList.add(characterList.get(2).getDefault_value());
                    characterValueList.add(characterList.get(3).getDefault_value());
                    characterValueList.add(characterList.get(4).getDefault_value());
                    for (int i = 5; i < characterList.size(); i++) {
                        characterValueList.add(valueDao.getByCharacter_idAndSave_id(characterList.get(i).getCharacter_id(), save.getSave_id()).getValue());
                    }
                }

                ready = true;

                // создаем адаптер
                adapter = new LikvidusCalcAdapter(getContext(), characterNameList.subList(5, characterNameList.size()), characterValueList.subList(5, characterValueList.size()));
                // устанавливаем для списка адаптер
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setAdapter(adapter);
                    }
                });
                likvidCalculator = new LikvidCalculator(characterValueList.get(0), characterValueList.get(1),
                        characterValueList.get(2), characterValueList.get(3), characterValueList.get(4),
                        characterKoefList.subList(5, characterKoefList.size()));
                if(save != null){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            calculate(findViewById(android.R.id.content));
                        }
                    });
                }
                Log.e("Calculator", likvidCalculator.toString());
            }
        }).start();


    }

    private static Context getContext(){
        return LikvidCalcRender.context;
    }

    public void calculate(View view){
        Log.e("ChildCPint", String.valueOf(recyclerView.getChildCount()));
        inputValueList = adapter.getInputValues();

        for (Float input: inputValueList){
            Log.e("inputValue", input.toString());
        }

        unswerList = likvidCalculator.calculate(inputValueList);

        for (Float unswer: unswerList){
            Log.e("unswer", unswer.toString());
        }

        resultValue.setText(unswerList.get(0).toString());
        resultValue1.setText(unswerList.get(1).toString());
        resultValue2.setText(unswerList.get(2).toString());
        resultValue3.setText(unswerList.get(3).toString());
        resultValue4.setText(unswerList.get(4).toString());

        saveImageButton.setVisibility(View.VISIBLE);
    }

    //
    public void save(View view){
        Context context = getContext();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.name_item_window);

        final EditText nameInput = new EditText(context);
        nameInput.setInputType(InputType.TYPE_CLASS_TEXT);
        nameInput.setText(R.string.saved_calc);
        builder.setView(nameInput);
        builder.setPositiveButton(R.string.ready, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                builder1.setTitle(R.string.description_item_window);

                final EditText descriptionInput = new EditText(context);
                descriptionInput.setInputType(InputType.TYPE_CLASS_TEXT);
                builder1.setView(descriptionInput);
                builder1.setPositiveButton(R.string.ready, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                Save save = new Save(nameInput.getText().toString(), descriptionInput.getText().toString(), type_id);
                                long newSaveId = db.saveDao().insert(save);

                                Value resultValue = new Value(DbIdConstants.ID_RESULT, newSaveId, unswerList.get(0));
                                long newValueId = db.valueDao().insert(resultValue);

                                Value value;

                                for (int i = 5; i < characterList.size(); i++) {
                                    Log.e("char"+i, characterList.get(i).toString());
                                    Log.e("inputValue"+i, inputValueList.get(i-5).toString());
                                    value = new Value(characterList.get(i).getCharacter_id(), newSaveId, inputValueList.get(i-5));
                                    db.valueDao().insert(value);
                                }

//                                Log.e("newValueId", String.valueOf(newValueId));
                            }
                        }).start();
                        Toast toast = Toast.makeText(getApplicationContext(),
                                nameInput.getText().toString() + " " + getString(R.string.saved), Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
                builder1.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder1.show();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.show();
    }
}
