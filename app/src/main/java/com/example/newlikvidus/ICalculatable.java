package com.example.newlikvidus;

import androidx.annotation.NonNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public interface ICalculatable {
    List<Float> getOutput();
    @NonNull
    static Float round(float value, int places){
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_EVEN);
        return bd.floatValue();
    };
    List<Float> calculate(float... input);
    List<Float> calculate();
    List<Float> calculate(List<Float> input);
}
