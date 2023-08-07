package com.example.newlikvidus;

import com.example.newlikvidus.data.AppDatabase;
import com.example.newlikvidus.data.entities.Save;
import com.example.newlikvidus.data.dao.SaveDao;
import com.example.newlikvidus.data.entities.Type;
import com.example.newlikvidus.data.dao.TypeDao;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import androidx.room.Room;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import java.io.Console;
import java.io.IOException;

@RunWith(AndroidJUnit4.class)
public class AppDatabaseTest extends TestCase {
    private AppDatabase db;
    private SaveDao saveDao;
    private TypeDao typeDao;
    private static Save[] saves = new Save[]{new Save("Расчёт температуры ликвидус",
            "описано", "26.05.2023", 1)};
    private static Type[] types = new Type[]{new Type("Температура заливки фасонного литья и слитков"), new Type("Литниково-питающая система"),
            new Type("Классическая прибыль"), new Type("Экзотермическая прибыль"), new Type("Боковая прибыль"),
            new Type("Масса груза"), new Type("Время выдержки отливки в форме"), new Type("Шихта")};
    @Before
    public void createDb() throws Exception{
        db = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getInstrumentation().getContext(), AppDatabase.class).build();
        saveDao = db.saveDao();
        typeDao = db.typeDao();
        setTypes();
    }

    public void setTypes(){typeDao.insertSome(types);}

    @Test
    public void getCountOfTypes(){
        assertEquals(types.length, typeDao.getCountOfTypes());
    }

    @Test
    public void addType () throws Exception{
        try {
            typeDao.insert(new Type("температура заливки фасонного литья и слитков"));
            assertEquals(typeDao.getAll().toString(), 100000, typeDao.getCountOfTypes()); //ошибка индекса переведёт в catch
        } catch (Exception e){
            assertFalse(false);
        }
    }
    @Test
    public void addType1 () throws Exception{
        try {
            typeDao.insert(types[0]);
            assertEquals(typeDao.getAll().toString(), 100000, typeDao.getCountOfTypes()); //ошибка индекса переведёт в catch
        } catch (Exception e){
            assertFalse(false);
        }
    }

    @Test
    public void addType2 () throws Exception{
        try {
            typeDao.insert(new Type("Тестовый тип"));
            assertEquals(typeDao.getAll().toString(), 9, typeDao.getCountOfTypes());
        } catch (Exception e){
            assertFalse(false);
        }
    }

    @Test
    public void addType3 () throws Exception{
        try {
            typeDao.insert(new Type(new String()));
            assertEquals(typeDao.getAll().toString(), 9, typeDao.getCountOfTypes());
        } catch (Exception e){
            assertFalse(false);
        }
    }
    @Test
    public void addSave(){
        assertEquals(1, saveDao.insert(saves[0]));
    }
    @Test
    public void getSave(){
        saves[0].setSave_id(saveDao.insert(saves[0]));
        assertTrue("\nОжидалось:\n"+saves[0]+"\nНо вышло:\n"+
                saveDao.getAll().get(0)+"\n", saveDao.getAll().get(0).equals(saves[0]));
    }
    @Test
    public void getSave1(){
        saves[0].setSave_id(saveDao.insert(saves[0]));
        assertEquals("\nОжидалось:\n"+saves[0]+"\nНо вышло:\n"+saveDao.getAll().get(0)+"\n", saves[0], saveDao.getAll().get(0));
    }

    @After
    public void closeDb() throws Exception{
        db.close();
    }
}