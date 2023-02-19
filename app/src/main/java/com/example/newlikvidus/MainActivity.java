package com.example.newlikvidus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.newlikvidus.data.AppDatabase;
import com.example.newlikvidus.data.CoefOfArgs;
import com.example.newlikvidus.data.CoefOfArgsDao;

public class MainActivity extends AppCompatActivity {

    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getInstance(getApplicationContext());
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                db = AppDatabase.getInstance(getApplicationContext());
//
//            }
//        }).start();
    }

    public void openLikvidCalcMenu(View view){

        new Thread(new Runnable() {
            @Override
            public void run() {
                CoefOfArgsDao coefOfArgsDao = db.coefOfArgsDao();
                if(coefOfArgsDao.getCount() == 0){
                    db.makeFromAsset(getApplicationContext());
                }

                CoefOfArgs coefOfArgs = new CoefOfArgs();
                coefOfArgs.name = "C";
                coefOfArgs.value = 89;

                coefOfArgsDao.insert(coefOfArgs);
            }
        }).start();

        Intent intent = new Intent(this, LikvidCalcMenu.class);
        startActivity(intent);
    }
}