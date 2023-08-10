package com.example.newlikvidus.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.newlikvidus.LikvidusCalcAdapter;
import com.example.newlikvidus.R;
import com.example.newlikvidus.SaveAdapter;
import com.example.newlikvidus.data.AppDatabase;
import com.example.newlikvidus.data.dao.CharacterDao;
import com.example.newlikvidus.data.dao.SaveDao;
import com.example.newlikvidus.data.dao.ValueDao;
import com.example.newlikvidus.data.entities.Character;
import com.example.newlikvidus.data.entities.Save;
import com.example.newlikvidus.data.entities.Value;

import java.util.ArrayList;
import java.util.List;

public class LikvidCalcFasonCast extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_likvid_calc_fason_cast);

//        Save save;
//        if (savedInstanceState == null) {
//            Bundle extras = getIntent().getExtras();
//            if(extras == null) {
//                save = null;
//            } else {
//                save = (Save) extras.get("save");
//            }
//        } else {
//            save = (Save) savedInstanceState.get("save");
//        }
//        if(save == null){
//            if (savedInstanceState == null) {
//                Bundle extras = getIntent().getExtras();
//                if(extras == null) {
//                    save = null;
//                } else {
//                    save = (Save) extras.get("save");
//                }
//            } else {
//                save = (Save) savedInstanceState.get("save");
//            }
//        }
//        else {
//            type_id = save.getType_id_fk();
//        }

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
                List<Float> chracterValueList = new ArrayList<>();

                characterList = characterDao.getAllByType_id(type_id);
                if(save == null){
                    for (Character character: characterList) {
                        characterNameList.add(character.getName());
                        chracterValueList.add(character.getDefault_value());
                    }
                } else{
                    for (Character character: characterList) {
                        characterNameList.add(character.getName());
                        Log.e("Char_ID", String.valueOf(character.getCharacter_id()));
                        Log.e("Save_ID", String.valueOf(save.getSave_id()));

                        chracterValueList.add(valueDao.getByCharacter_idAndSave_id(character.getCharacter_id(), save.getSave_id()).getValue());
                    }
                }

                ready = true;

                // создаем адаптер
                LikvidusCalcAdapter adapter = new LikvidusCalcAdapter(getContext(), characterNameList, chracterValueList);
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
        return LikvidCalcFasonCast.context;
    }
}