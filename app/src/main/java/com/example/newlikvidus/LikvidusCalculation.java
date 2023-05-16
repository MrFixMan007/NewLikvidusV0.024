package com.example.newlikvidus;

import android.util.Log;

import androidx.annotation.NonNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class LikvidusCalculation implements ICalculatable{
    private float temp;
    float m1, m2, m3, m4;
    List<Float> koefs;
    List<Float> input;
    List<Float> output;

    public LikvidusCalculation(float temp, float m1, float m2, float m3, float m4, @NonNull List<Float> koefs) {
        this.temp = temp;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.m4 = m4;
        this.koefs = new ArrayList<>();
        for (int i = 0; i < koefs.size(); i++)
            this.koefs.add(koefs.get(i));
    }

    public List<Float> calculate(@NonNull float... input){
        List<Float> listInput = new ArrayList<Float>();

        for (int i = 0; i < input.length; i++){
            listInput.add(input[i]);
        }
        return calculate(listInput);
    }

    public List<Float> calculate(){
        List<Float> listInput = new ArrayList<Float>();
        return calculate(listInput);
    }

    public List<Float> calculate(@NonNull List<Float> input){
        output = new ArrayList<Float>();
        this.input = input;
        float res = temp;

        if(input.size() < koefs.size()){
            for (int i = input.size(); i < koefs.size(); i++){
                input.add(0f);
            }
        }

        for(int i = 0; i < koefs.size(); i++){
            if(input.get(i) > 100 || input.get(i) < 0) {
                output.add(0f);
                output.add(0f);
                output.add(0f);
                output.add(0f);
                output.add(0f);
                return output;
            }
            res -= koefs.get(i) * input.get(i);
        }
        this.output.add(ICalculatable.round(res,0));
        this.output.add(ICalculatable.round(res + m1,0));
        this.output.add(ICalculatable.round(res + m2, 0));
        this.output.add(ICalculatable.round(res + m1 + m3, 0));
        this.output.add(ICalculatable.round(res + m2 + m4, 0));

        return getOutput();
    }

    public List<Float> getOutput() {
        List<Float> res = new ArrayList<>();
        for (int i = 0; i < output.size(); i++) {
            res.add(output.get(i));
        }
        return res;
    }

}
