package com.example.newlikvidus.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.newlikvidus.R;
import com.example.newlikvidus.data.AppDatabase;
import com.example.newlikvidus.data.SetterDefaultArgs;
import com.example.newlikvidus.data.dao.CharacterDao;
import com.example.newlikvidus.data.dao.PossibleValueDao;
import com.example.newlikvidus.data.dao.SaveDao;
import com.example.newlikvidus.data.dao.TypeDao;
import com.example.newlikvidus.data.dao.ValueDao;

public class MainActivity extends AppCompatActivity {

    private AppDatabase db;

//    public Save[] saves;
//    public Type[] types;
//    public Character[] characters;
//    public List<PossibleValue> possibleValues;
//    public List<Value> values;

    private SaveDao saveDao;
    private TypeDao typeDao;
    private CharacterDao characterDao;
    private PossibleValueDao possibleValueDao;
    private ValueDao valueDao;
    public boolean ready = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this.deleteDatabase("database");
        db = AppDatabase.getInstance(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                SetterDefaultArgs.addDefaultData(db);
//                SetterDefaultArgs.addTestSaves(db);

//                saveDao = db.saveDao();
//                typeDao = db.typeDao();
//                characterDao = db.characterDao();
//                possibleValueDao = db.possibleValueDao();
//                valueDao = db.valueDao();
//
//                saves = (Save[])saveDao.getAll().toArray();
//                types = (Type[]) typeDao.getAll().toArray();
//                characters = (Character[]) characterDao.getAll().toArray();
//                possibleValues = possibleValueDao.getAll();
//                values = valueDao.getAll();

                ready = true;
//                Log.i("SAVES", String.valueOf(saves.length));
//                Log.i("TYPES", String.valueOf(types.length));
//                Log.i("CHARACTERS", String.valueOf(characters.length));
            }
        }).start();
    }

    public void openLikvidCalcMenu(View view){
        Intent intent = new Intent(this, LikvidCalcMenu.class);

//        intent.putExtra("saves", saves);
//        intent.putExtra("types", types);
//        intent.putExtra("characters", characters);
        if(ready)startActivity(intent);
    }
}