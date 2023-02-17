package com.example.newlikvidus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LikvidCalcMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_likvid_calc_menu);
    }

    public void openLikvidCalcIngot(View view){
        Intent intent = new Intent(this, LikvidCalcIngot.class);
        startActivity(intent);
    }

    public void openLikvidCalcFasonCast(View view){
        Intent intent = new Intent(this, LikvidCalcFasonCast.class);
        startActivity(intent);
    }
}