package com.example.newlikvidus.data.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.newlikvidus.data.BaseDao;
import com.example.newlikvidus.data.entities.Type;

import java.util.List;

@Dao
public interface TypeDao extends BaseDao<Type> {
    @Query("SELECT * FROM type WHERE type_id = :id")
    Type getById(long id);
    @Query("SELECT * FROM type")
    List<Type> getAll();
    @Query("SELECT COUNT(*) FROM type")
    int getCountOfTypes();
}
