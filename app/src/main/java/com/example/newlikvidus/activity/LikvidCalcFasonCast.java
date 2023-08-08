package com.example.newlikvidus.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.percentlayout.widget.PercentLayoutHelper;
import androidx.percentlayout.widget.PercentRelativeLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.newlikvidus.R;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class LikvidCalcFasonCast extends AppCompatActivity {

    public String[] coefNames;
    public float[] coefValues;
    private Button btn_Calc;
    private double temp = 1537.0d;
    private TextView[] textViews;
    private EditText editText, editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8, editText9, editText10, editText11, editText12;
    private TextView Answer, AnswTempCast, AnswTempCast1, AnswTempInStove, AnswTempInStove1;
    private List<Double> doubleValues = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_likvid_calc_fason_cast);

        Bundle arguments = getIntent().getExtras();
        coefNames = arguments.getStringArray("coefNames");
        coefValues = arguments.getFloatArray("coefValues");
        temp = coefValues[0];

        textViews = new TextView[coefNames.length - 5];

        Log.i("LOL", String.valueOf(coefNames.length));
        Log.i("LOL", String.valueOf(coefValues.length));

        PercentRelativeLayout pr = (PercentRelativeLayout)findViewById(R.id.percent);
        int n = textViews.length;
        //ContextThemeWrapper context = new ContextThemeWrapper(this, R.style.CustomTextView);
        for (int i = 0; i < n; i++){
            Log.i("LOL", String.valueOf(i));
            PercentRelativeLayout.LayoutParams params = new PercentRelativeLayout.LayoutParams(
                    PercentRelativeLayout.LayoutParams.MATCH_PARENT,
                    PercentRelativeLayout.LayoutParams.MATCH_PARENT);
            params.topMargin = 500;
            textViews[i] = new TextView(this);
            textViews[i].setId(i);
            textViews[i].setText("text" + i);
            if(i == 0) {
                params.addRule(PercentRelativeLayout.BELOW, R.id.percent);
                params.addRule(PercentRelativeLayout.ALIGN_PARENT_END, R.id.percent);

                Log.i("LOL", "true");
            }
            else{
                params.addRule(PercentRelativeLayout.ALIGN_PARENT_END, textViews[i-1].getId());
                params.addRule(PercentRelativeLayout.RIGHT_OF, textViews[i-1].getId());
                params.addRule(PercentRelativeLayout.END_OF, textViews[i-1].getId());
                Log.i("LOL", "false");
            }
            pr.addView(textViews[i], params);
            textViews[i] = (TextView) findViewById(textViews[i].getId());
        }
//        addListenerOnButtons();
//        addListenerOnTexts();
//        addListenerOnEditTexts();
    }

    void addListenerOnTexts(){



//        Answer = (TextView) findViewById(R.id.txt_AnswLikvid);
//        AnswTempCast = (TextView) findViewById(R.id.txt_AnswTempCast);
//        AnswTempCast1 = (TextView) findViewById(R.id.txt_AnswTempCast1);
//        AnswTempInStove = (TextView) findViewById(R.id.txt_AnswTempInStove);
//        AnswTempInStove1 = (TextView) findViewById(R.id.txt_AnswTempInStove1);
    }

    void addListenerOnButtons(){
//        btn_Calc = (Button)findViewById(R.id.btn_Calc);
        btn_Calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Answer.setText(Double.toString(Calculate()));//
            }
        });
    }

    void addListenerOnEditTexts(){
//        editText = (EditText) findViewById(R.id.editText);
//        editText1 = (EditText) findViewById(R.id.editText1);
//        editText2 = (EditText) findViewById(R.id.editText2);
//        editText3 = (EditText) findViewById(R.id.editText3);
//        editText4 = (EditText) findViewById(R.id.editText4);
//        editText5 = (EditText) findViewById(R.id.editText5);
//        editText6 = (EditText) findViewById(R.id.editText6);
//        editText7 = (EditText) findViewById(R.id.editText7);
//        editText8 = (EditText) findViewById(R.id.editText8);
//        editText9 = (EditText) findViewById(R.id.editText9);
//        editText10 = (EditText) findViewById(R.id.editText10);
//        editText11 = (EditText) findViewById(R.id.editText11);
//        editText12 = (EditText) findViewById(R.id.editText12);

//        editText.setText(".0");
//        editText1.setText(".0");
//        editText2.setText(".0");
//        editText3.setText(".0");
//        editText4.setText(".0");
//        editText5.setText(".0");
//        editText6.setText(".0");
//        editText7.setText(".0");
//        editText8.setText(".0");
//        editText9.setText(".0");
//        editText10.setText(".0");
//        editText11.setText(".0");
//        editText12.setText(".0");
    }

    double Calculate(){

        if((Pattern.matches("[.][0-9]+", editText.getText())) || (Pattern.matches("[0-9]+[.]*[0-9]*", editText.getText()))) {

            double result = temp;

//            if (!(c.getText().toString().equals("")))
//                doubleValues.add(Math.abs(88 * Double.parseDouble(editText.getText().toString())));
//            if (!(si.getText().toString().equals("")))
//                doubleValues.add(Math.abs(8 * Double.parseDouble(editText1.getText().toString())));
//            if (!(mn.getText().toString().equals("")))
//                doubleValues.add(Math.abs(5 * Double.parseDouble(editText2.getText().toString())));
//            if (!(p.getText().toString().equals("")))
//                doubleValues.add(Math.abs(30 * Double.parseDouble(editText3.getText().toString())));
//            if (!(s.getText().toString().equals("")))
//                doubleValues.add(Math.abs(25 * Double.parseDouble(editText4.getText().toString())));
//            if (!(cr.getText().toString().equals("")))
//                doubleValues.add(Math.abs(1.5 * Double.parseDouble(editText5.getText().toString())));
//            if (!(ni.getText().toString().equals("")))
//                doubleValues.add(Math.abs(4 * Double.parseDouble(editText6.getText().toString())));
//            if (!(cu.getText().toString().equals("")))
//                doubleValues.add(Math.abs(5 * Double.parseDouble(editText7.getText().toString())));
//            if (!(al.getText().toString().equals("")))
//                doubleValues.add(Math.abs(3 * Double.parseDouble(editText8.getText().toString())));
//            if (!(ti.getText().toString().equals("")))
//                doubleValues.add(Math.abs(20 * Double.parseDouble(editText9.getText().toString())));
//            if (!(v.getText().toString().equals("")))
//                doubleValues.add(Math.abs(2 * Double.parseDouble(editText10.getText().toString())));
//            if (!(mo.getText().toString().equals("")))
//                doubleValues.add(Math.abs(2 * Double.parseDouble(editText11.getText().toString())));
//            if (!(w.getText().toString().equals("")))
//                doubleValues.add(Math.abs(Double.parseDouble(editText12.getText().toString())));

            for (double value : doubleValues) {
                result -= value;
            }

//            doubleValues.clear();
//
//            AnswTempCast.setText(Double.toString(result + 50));
//            AnswTempCast1.setText(Double.toString(result + 70));
//
//            AnswTempInStove.setText(Double.toString(result + 50 + 40));
//            AnswTempInStove1.setText(Double.toString(result + 70 + 40));
            return result;
        }
        return 0;
    }

    void SaveReport(){
        Answer.setText(Double.toString(Calculate()));
    }
}