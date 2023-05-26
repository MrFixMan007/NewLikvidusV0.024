package com.example.newlikvidus.data;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface TypeDao {
    @Insert
    long insert(Type type);
    @Insert
    long[] insertSome(Type... types);
}
