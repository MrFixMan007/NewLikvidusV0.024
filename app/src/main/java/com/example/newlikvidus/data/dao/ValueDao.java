package com.example.newlikvidus.data.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.newlikvidus.data.BaseDao;
import com.example.newlikvidus.data.entities.Value;

import java.util.List;

@Dao
public interface ValueDao extends BaseDao<Value> {
    @Query("SELECT * FROM value WHERE value_id = :id")
    Value getById(long id);
    @Query("SELECT * FROM value")
    List<Value> getAll();
    @Query("SELECT COUNT(*) FROM value")
    int getCountOfCharacters();
}
