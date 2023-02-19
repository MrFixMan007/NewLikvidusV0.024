package com.example.newlikvidus.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CoefOfArgsDao {

    @Query("SELECT * FROM coefsOfArgs")
    List<CoefOfArgs> getAll();

    @Query("SELECT * FROM coefsOfArgs WHERE id = :id")
    CoefOfArgs getById(long id);

    @Query("SELECT Count(*) FROM defCoefsOfArgs")
    int getCount();

    @Insert
    void insert(CoefOfArgs employee);

    @Update
    void update(CoefOfArgs employee);

    @Delete
    void delete(CoefOfArgs employee);

}
