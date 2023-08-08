package com.example.newlikvidus.data.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.newlikvidus.data.BaseDao;
import com.example.newlikvidus.data.entities.Save;

import java.util.List;

@Dao
public interface SaveDao extends BaseDao<Save> {
    @Query("SELECT * FROM save WHERE save_id = :id")
    Save getById(long id);
    @Query("SELECT * FROM save WHERE type_id_fk = :id")
    List<Save> getByType_id(long id);
    @Query("SELECT * FROM save")
    List<Save> getAll();
    @Query("SELECT COUNT(*) FROM save")
    int getCountOfSaves();
}
