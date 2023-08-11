package com.example.newlikvidus.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.newlikvidus.LikvidusCalcAdapter;
import com.example.newlikvidus.R;
import com.example.newlikvidus.data.AppDatabase;
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
    public boolean ready = false;
    private static Context context;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private TextView resultDescription, resultDescription1, resultDescription2, resultValue, resultValue1, resultValue2, resultValue3, resultValue4;

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
                    }
                } else{
                    for (Character character: characterList) {
                        characterNameList.add(character.getName());
                        Log.e("Char_ID", String.valueOf(character.getCharacter_id()));
                        Log.e("Save_ID", String.valueOf(save.getSave_id()));

                        characterValueList.add(valueDao.getByCharacter_idAndSave_id(character.getCharacter_id(), save.getSave_id()).getValue());
                    }
                }

                ready = true;

                // создаем адаптер
                LikvidusCalcAdapter adapter = new LikvidusCalcAdapter(getContext(), characterNameList.subList(5, characterNameList.size()), characterValueList.subList(5, characterValueList.size()));
                // устанавливаем для списка адаптер
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setAdapter(adapter);
                    }
                });
            }
        }).start();
    }

    private static Context getContext(){
        return LikvidCalcRender.context;
    }

    public void calculate(View view){

    }
    public void save(View view){

    }
}