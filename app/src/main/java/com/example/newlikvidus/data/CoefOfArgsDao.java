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

    @Query("SELECT name FROM coefsOfArgs")
    String[] getAllNames();

    @Query("SELECT value FROM coefsOfArgs")
    float[] getAllValues();

    @Query("SELECT * FROM coefsOfArgs WHERE id = :id")
    CoefOfArgs getById(long id);

    @Insert
    void insert(CoefOfArgs coefOfArgs);

    @Insert
    void insertAll(CoefOfArgs... coefsOfArgs);

    @Update
    void update(CoefOfArgs coefOfArgs);

    @Delete
    void delete(CoefOfArgs coefOfArgs);

    @Query("SELECT COUNT(*) FROM CoefsOfArgs LIMIT 1")
    int getCountOfCoefsOfArgs();

}
