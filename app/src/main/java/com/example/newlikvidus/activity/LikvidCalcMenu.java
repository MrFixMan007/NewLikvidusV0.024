package com.example.newlikvidus.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.newlikvidus.R;

public class LikvidCalcMenu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_likvid_calc_menu);
    }

    public void openLikvidCalcIngot(View view){
        Intent intent = new Intent(this, LikvidCalcRender.class);
        intent.putExtra("type_id", (long) 2);
        startActivity(intent);
    }

    public void openLikvidCalcFasonCast(View view){
        Intent intent = new Intent(this, LikvidCalcRender.class);
        intent.putExtra("type_id", (long) 1);
        startActivity(intent);
    }

    public void openLikvidSavedCalc(View view){
        Intent intent = new Intent(this, LikvidSaves.class);
        startActivity(intent);
    }
}