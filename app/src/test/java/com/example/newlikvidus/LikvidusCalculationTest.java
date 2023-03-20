package com.example.newlikvidus;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LikvidusCalculationTest {

    List<Float> koefs = ToList(88f, 8f, 5f, 30f, 25f, 1.5f, 4f, 5f, 3f, 20f, 2f, 2f, 1f);
    LikvidusCalculation likvid = new LikvidusCalculation(1537f, 50f, 70f, 40f, 40f, koefs);
    private List<Float> ToList(float... input){
        List<Float> list = new ArrayList<Float>();
        for (int i = 0; i < input.length; i++){
            list.add(input[i]);
        }
        return list;
    }
    @Test
    public void test1(){
        assertEquals("Не совпало", ToList(1511).get(0), likvid.calculate(0.3f).get(0));
    }
    @Test
    public void test2(){
        assertEquals("Не совпало", ToList(1507f).get(0), likvid.calculate(0.3f, 0.5f).get(0));
    }
    @Test
    public void test3(){
        assertEquals("Не совпало", ToList(1506f).get(0), likvid.calculate(0.3f, 0.5f, 0.15f).get(0));
    }
    @Test
    public void test4(){
        assertEquals("Не совпало", ToList(1476f).get(0), likvid.calculate(0.3f, 0.5f, 0.15f, 1).get(0));
    }
    @Test
    public void test5(){
        assertEquals("Не совпало", ToList(1448, 1498, 1518, 1538, 1558), likvid.calculate(0.3f, 0.5f, 0.15f, 1, 1.1f));
    }
    @Test
    public void test6(){
        assertEquals("Слишком большой ввод в процентах", ToList(0, 0, 0, 0, 0), likvid.calculate(0.3f, 0.5f, 0.15f, 1, 100.1f));
    }
    @Test
    public void test7(){
        assertEquals("Слишком маленький ввод в процентах", ToList(0, 0, 0, 0, 0), likvid.calculate(-0.3f, 0.5f, 0.15f, 1, 100.1f));
    }
    @Test
    public void test8(){
        assertEquals("Ничего не ввёл", ToList(1537, 1587, 1607, 1627.0f, 1647.0f), likvid.calculate());
    }
    @Test
    public void test9(){
        assertEquals("Ненормальное число", ToList(0, 0, 0, 0, 0), likvid.calculate(10000000000000000000000000000000000.0000000000000000000000000000f));
    }
    @Test
    public void test10(){
        assertEquals("Не совпало", ToList(1448, 1498, 1518, 1538, 1558), likvid.calculate(0.3f, 0.5f, 0.15f, 1, 1.1f, 0, 0.00000005f));
    }
    @Test
    public void test11(){
        assertEquals("Не совпало", ToList(1448, 1498, 1518, 1538, 1558), likvid.calculate(0.3f, 0.5f, 0.15f, 1, 1.1f, 0, 0.0000005f));
    }
    @Test
    public void test12(){
        assertEquals("Не совпало", ToList(1448, 1498, 1518, 1538, 1558), likvid.calculate(0.3f, 0.5f, 0.15f, 1, 1.1f, 0, 0.0005f));
    }
    @Test
    public void test13(){
        assertEquals("Не совпало", ToList(1446, 1496, 1516, 1536, 1556), likvid.calculate(0.3f, 0.5f, 0.15f, 1, 1.1f, 0, 0.5f));
    }
}