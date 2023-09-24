package com.example.newlikvidus;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LikvidusCalculationTest {
    List<Float> koefs = ToList(88f, 8f, 5f, 30f, 25f, 1.5f, 4f, 5f, 3f, 20f, 2f, 2f, 1f);
    LikvidCalculator likvid = new LikvidCalculator(1537f, 50f, 70f, 40f, 40f, koefs);
    private List<Float> ToList(float... input){
        List<Float> list = new ArrayList<Float>();
        for (int i = 0; i < input.length; i++){
            list.add(input[i]);
        }
        return list;
    }
    @Test
    public void correctInput1(){
        assertEquals("Проверка на правильность вычисления не пройдена!\n",
                ToList(1511).get(0), likvid.calculate(0.3f).get(0));
    }
    @Test
    public void wrongInputBigNumber1(){
        assertEquals("Проверка на слишком большое число входных данных не пройдена!\n",
                ToList(0, 0, 0, 0, 0), likvid.calculate(0.3f, 0.5f, 0.15f, 1, 100.1f));
    }
    @Test
    public void wrongInputSmallNumber1(){
        assertEquals("Проверка на слишком маленькое число входных данных не пройдена!\n",
                ToList(0, 0, 0, 0, 0), likvid.calculate(-0.3f, 0.5f, 0.15f, 1, 1.1f));
    }
    @Test
    public void nonInput1(){
        assertEquals("Проверка на отсутствие ввода не пройдена!\n",
                ToList(1537, 1587, 1607, 1627.0f, 1647.0f), likvid.calculate());
    }
    @Test
    public void correctInput2(){
        assertEquals("Проверка на правильность вычисления не пройдена!\n",
                ToList(1507f).get(0), likvid.calculate(0.3f, 0.5f).get(0));
    }
    @Test
    public void correctInput3(){
        assertEquals("Проверка на правильность вычисления не пройдена!\n", ToList(1506f).get(0), likvid.calculate(0.3f, 0.5f, 0.15f).get(0));
    }
    @Test
    public void correctInput4(){
        assertEquals("Проверка на правильность вычисления не пройдена!\n", ToList(1476f).get(0), likvid.calculate(0.3f, 0.5f, 0.15f, 1).get(0));
    }
    @Test
    public void correctInput5(){
        assertEquals("Проверка на правильность вычисления не пройдена!\n", ToList(1448, 1498, 1518, 1538, 1558), likvid.calculate(0.3f, 0.5f, 0.15f, 1, 1.1f));
    }
    @Test
    public void wrongInputBigNumber2(){
        assertEquals("Проверка на слишком большое число входных данных не пройдена!\n", ToList(0, 0, 0, 0, 0), likvid.calculate(10000000000000000000000000000000000.0000000000000000000000000000f));
    }
    @Test
    public void correctInput6(){
        assertEquals("Проверка на правильность вычисления не пройдена!\n", ToList(1448, 1498, 1518, 1538, 1558), likvid.calculate(0.3f, 0.5f, 0.15f, 1, 1.1f, 0, 0.00000005f));
    }
    @Test
    public void correctInput7(){
        assertEquals("Проверка на правильность вычисления не пройдена!\n", ToList(1448, 1498, 1518, 1538, 1558), likvid.calculate(0.3f, 0.5f, 0.15f, 1, 1.1f, 0, 0.0000005f));
    }
    @Test
    public void correctInput8(){
        assertEquals("Проверка на правильность вычисления не пройдена!\n", ToList(1448, 1498, 1518, 1538, 1558), likvid.calculate(0.3f, 0.5f, 0.15f, 1, 1.1f, 0, 0.0005f));
    }
    @Test
    public void correctInput9(){
        assertEquals("Проверка на правильность вычисления не пройдена!\n", ToList(1446, 1496, 1516, 1536, 1556), likvid.calculate(0.3f, 0.5f, 0.15f, 1, 1.1f, 0, 0.5f));
    }
    @Test
    public void correctInput10(){
        assertEquals("Проверка на все нули не пройдена!\n", ToList(1537, 1587, 1607, 1627.0f, 1647.0f), likvid.calculate(0, 0, 0, 0, 0));
    }
}