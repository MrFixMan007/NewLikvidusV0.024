package com.example.newlikvidus.data;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.newlikvidus.data.dao.CharacterDao;
import com.example.newlikvidus.data.dao.PossibleValueDao;
import com.example.newlikvidus.data.dao.SaveDao;
import com.example.newlikvidus.data.dao.TypeDao;
import com.example.newlikvidus.data.dao.ValueDao;
import com.example.newlikvidus.data.entities.Character;
import com.example.newlikvidus.data.entities.PossibleValue;
import com.example.newlikvidus.data.entities.Save;
import com.example.newlikvidus.data.entities.Type;
import com.example.newlikvidus.data.entities.Value;

@androidx.room.Database(entities = {Save.class, Type.class,
        Character.class, Value.class, PossibleValue.class}, version = 6)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;
    public abstract SaveDao saveDao();
    public abstract TypeDao typeDao();
    public abstract CharacterDao characterDao();
    public abstract ValueDao valueDao();
    public abstract PossibleValueDao possibleValueDao();

    public static synchronized AppDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public static AppDatabase getInstance(){
        return instance;
    }
}