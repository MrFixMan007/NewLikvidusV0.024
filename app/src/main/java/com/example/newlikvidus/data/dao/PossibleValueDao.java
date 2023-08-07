package com.example.newlikvidus.data.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.newlikvidus.data.BaseDao;
import com.example.newlikvidus.data.entities.PossibleValue;

import java.util.List;

@Dao
public interface PossibleValueDao extends BaseDao<PossibleValue> {
    @Query("SELECT * FROM possible_value WHERE possible_value_id = :id")
    PossibleValue getById(long id);
    @Query("SELECT * FROM possible_value")
    List<PossibleValue> getAll();
    @Query("SELECT COUNT(*) FROM possible_value")
    int getCountOfCharacters();
}
