package com.example.newlikvidus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LikvidCalcMenu extends AppCompatActivity {

    public String[] coefNames;
    public float[] coefValues;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_likvid_calc_menu);

        Bundle arguments = getIntent().getExtras();

        coefNames = arguments.getStringArray("coefNames");
        coefValues = arguments.getFloatArray("coefValues");

      Log.i("LOL", String.valueOf(coefNames.length));
      Log.i("LOL", String.valueOf(coefValues.length));
    }

    public void openLikvidCalcIngot(View view){
        Intent intent = new Intent(this, LikvidCalcIngot.class);

        intent.putExtra("coefNames", coefNames);
        intent.putExtra("coefValues", coefValues);
        startActivity(intent);
    }

    public void openLikvidCalcFasonCast(View view){
        Intent intent = new Intent(this, LikvidCalcFasonCast.class);

        intent.putExtra("coefNames", coefNames);
        intent.putExtra("coefValues", coefValues);
        startActivity(intent);
    }
}