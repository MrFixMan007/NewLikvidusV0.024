package com.example.newlikvidus;

import android.util.Log;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class LikvidusCalculation {
    private float temp;
    float m1, m2, m3, m4;
    List<Float> koefs;
    List<Float> input;
    List<Float> output;

    public LikvidusCalculation(float temp, float m1, float m2, float m3, float m4, List<Float> koefs) {
        this.temp = temp;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.m4 = m4;
        this.koefs = koefs;
    }

    public List<Float> calculate(float... input){
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

    public List<Float> calculate(List<Float> input){
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
        this.output.add(round(res,0));
        this.output.add(round(res + m1,0));
        this.output.add(round(res + m2, 0));
        this.output.add(round(res + m1 + m3, 0));
        this.output.add(round(res + m2 + m4, 0));

        return getOutput();
    }

    private List<Float> getOutput() {
        List<Float> res = new ArrayList<>();
        for (int i = 0; i < output.size(); i++) {
            res.add(output.get(i));
        }
        return res;
    }

    public static Float round(float value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_EVEN);
        return bd.floatValue();
    }
}
