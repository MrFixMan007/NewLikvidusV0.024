package com.example.newlikvidus;

import static org.junit.Assert.assertEquals;
import com.example.newlikvidus.data.Save;
import com.example.newlikvidus.data.SaveDao;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class AppDatabaseTestLight {
    /*public class Save{
        private int id;
        private String name;
        private String date;
        private String description;
        private int type_id;

        Save(int id, String name, String date, int type_int){
            this.id = id;
            this.name = String.valueOf(name);
            this.date = String.valueOf(date);
            this.type_id = type_int;
        }
    }*/
    //AppDatabase db = Mockito.mock(AppDatabase.class);
    //CoefOfArgsDao coefOfArgsDao = Mockito.mock(CoefOfArgsDao.class);
    SaveDao saveDao = Mockito.mock(SaveDao.class);
    //List<CoefOfArgs> coefs = new ArrayList<>();
    List<String> testList = new ArrayList<>();
    List<Save> data = new ArrayList<>();
    @Before
    public void prepare(){
        testList.add("ok");
        data.add(new Save(0, "Сохранённый расчёт", "24.05.2023", 2));
        data.add(new Save(1, "Сохранённый расчёт", "26.05.2023", "описание", 2));
        data.add(new Save(1, "Сохранённый расчёт 1Сохранённый расчёт 1Сохранённый расчёт 1Сохранённый расчёт 1" +
                "Сохранённый расчёт ;;;;;", "26.05.2023", "описание", 2));
        //Mockito.when(coefOfArgsDao.getCountOfCoefsOfArgs()).thenReturn(testList.size());
        Mockito.when(saveDao.getById(0)).thenReturn(data.get(0));
    }
//    @Test
//    public void test1(){
//        assertEquals(testList.size(), coefOfArgsDao.getCountOfCoefsOfArgs());
//    }
    @Test
    public void test2(){
        assertEquals(data.get(0), saveDao.getById(0));
    }
    @Test
    public void test3(){
        assertEquals("(int) save_id = 1, (str(18))name = Сохранённый расчёт, (str)date = 26.05.2023," +
                " (str(8))description = описание, (int)type_int = 2.", data.get(1).print());
    }
    @Test
    public void test4(){
        //data.get(2).setDescription("dfgdffg"); //TODO: при геттере у листа <Save> не возвращает копию(
        assertEquals("(int) save_id = 1, (str(100))name = Сохранённый расчёт 1Сохранённый расчёт " +
                "1Сохранённый расчёт 1Сохранённый расчёт 1Сохранённый расчёт ;, (str)date = 26.05.2023, (str(8))description = описание, (int)type_int = 2.", data.get(2).print());
    }
    @Test
    public void test5(){
        Save save = data.get(2);
        save.setDescription("Изменённое описание");
        data.add(save);
        assertEquals("(int) save_id = 1, (str(100))name = Сохранённый расчёт 1Сохранённый расчёт " +
                "1Сохранённый расчёт 1Сохранённый расчёт 1Сохранённый расчёт ;, (str)date = 26.05.2023, (str(19))description = Изменённое описание, (int)type_int = 2.", data.get(3).print());
    }


//    private List<CoefOfArgs> toList(CoefOfArgs... input){
//        List<CoefOfArgs> list = new ArrayList<CoefOfArgs>();
//        for (int i = 0; i < input.length; i++){
//            list.add(input[i]);
//        }
//        return list;
//    }
    private List<String> newList(String... input){
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < input.length; i++){
            list.add(input[i]);
        }
        return list;
    }
    private List<Save> newListSave(int index){
        List<Save> list = new ArrayList<>();
        list.add(data.get(index));
        return list;
    }

}
