package com.example.newlikvidus.data;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {Save.class, Type.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;
    //public abstract CoefOfArgsDao coefOfArgsDao();
    public abstract SaveDao saveDao();
    public abstract TypeDao typeDao();

    public static synchronized AppDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}