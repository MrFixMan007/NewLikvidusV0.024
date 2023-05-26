package com.example.newlikvidus;

import androidx.room.Room;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.newlikvidus.data.AppDatabase;
import com.example.newlikvidus.data.Save;
import com.example.newlikvidus.data.SaveDao;
import com.example.newlikvidus.data.Type;
import com.example.newlikvidus.data.TypeDao;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class AppDatabaseTest extends TestCase {
    private AppDatabase db;
    private SaveDao saveDao;
    private TypeDao typeDao;
    private static Save[] saves = new Save[]{new Save("Расчёт температуры ликвидус", "описано", "26.05.2023", 1)};
    private static Type[] types = new Type[]{new Type("Температура")};
    @Before
    public void createDb() throws Exception{
        db = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getInstrumentation().getContext(), AppDatabase.class).build();
        saveDao = db.saveDao();
        typeDao = db.typeDao();
    }

    @Test
    public void addType(){
        assertEquals(1, typeDao.insert(types[0]));
    }
    @Test
    public void addSave(){
        typeDao.insert(types[0]);
        assertEquals(1, saveDao.insert(saves[0]));
    }
    @Test
    public void getSave(){
        typeDao.insert(types[0]);
        saves[0].setSave_id(saveDao.insert(saves[0]));
        assertTrue("\nОжидалось:\n"+saves[0]+"\nНо вышло:\n"+saveDao.getAll().get(0)+"\n", saveDao.getAll().get(0).equals(saves[0]));
    }
    @Test
    public void getSave1(){
        typeDao.insert(types[0]);
        saves[0].setSave_id(saveDao.insert(saves[0]));
        assertEquals("\nОжидалось:\n"+saves[0]+"\nНо вышло:\n"+saveDao.getAll().get(0)+"\n", saves[0], saveDao.getAll().get(0));
    }

    @After
    public void closeDb() throws Exception{
        db.close();
    }
}