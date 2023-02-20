package com.example.newlikvidus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.newlikvidus.data.AppDatabase;
import com.example.newlikvidus.data.CoefOfArgs;
import com.example.newlikvidus.data.CoefOfArgsDao;
import com.example.newlikvidus.data.SetterDefCoefsOfArgs;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppDatabase db;
    public String[] coefNames;
    public float[] coefValues;
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
                SetterDefCoefsOfArgs.addDefCoefs(db);
                CoefOfArgsDao coefOfArgsDao = db.coefOfArgsDao();

                coefNames = coefOfArgsDao.getAllNames();
                coefValues = coefOfArgsDao.getAllValues();
                ready = true;
                Log.i("LOL", String.valueOf(coefValues.length));
            }
        }).start();
    }

    public void openLikvidCalcMenu(View view){
        Intent intent = new Intent(this, LikvidCalcMenu.class);
        Log.i("LOL", String.valueOf(coefValues.length));

        intent.putExtra("coefNames", coefNames);
        intent.putExtra("coefValues", coefValues);
        if(ready)startActivity(intent);
    }
}