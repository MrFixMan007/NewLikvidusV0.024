package com.example.newlikvidus.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SaveDao {
    @Query("SELECT * FROM save WHERE save_id = :id")
    Save getById(long id);
    @Query("SELECT * FROM save")
    List<Save> getAll();

    @Insert
    long insert(Save save); //вернёт id вставленной записи
    @Insert
    long[] insertSome(Save... saves); //вернёт несколько id вставленных записей

    @Delete
    void delete(Save save);
    @Delete
    int deleteSome(Save... saves); //вернёт кол-во удалённых запиисей

    @Update
    void update(Save save);
    @Update
    int updateSome(Save... saves); //вернёт кол-во обновлённых заисей
}
