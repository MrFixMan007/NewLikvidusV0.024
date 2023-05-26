package com.example.newlikvidus;

import android.app.Application;
import android.app.Instrumentation;
import android.content.pm.InstrumentationInfo;

import com.example.newlikvidus.data.AppDatabase;
import com.example.newlikvidus.data.Save;
import com.example.newlikvidus.data.SaveDao;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import androidx.room.Room;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import android.content.Context;

@RunWith(AndroidJUnit4.class)
public class AppDatabaseTest extends TestCase {
    private AppDatabase db;
    private SaveDao saveDao;
    private List<Save> saves;

    @Before
    public void createDb() throws Exception{
        db = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getInstrumentation().getContext(), AppDatabase.class).build();
        saveDao = db.saveDao();
        saves = new ArrayList<>();
    }

    @Test
    public void test(){
        saves.add(new Save("fd", "ds", "ds", 1));
        Save save = new Save("fd", "ds", "ds", 1);
        assertEquals(0, saveDao.insert(save));
    }

    @After
    public void closeDb() throws Exception{
        db.close();
    }
}