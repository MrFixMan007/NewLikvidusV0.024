package com.example.newlikvidus.data;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

public interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(T obj); //вернёт id вставленной записи
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertSome(T... obj); //вернёт несколько id вставленных записей

    @Delete
    void delete(T obj);
    @Delete
    int deleteSome(T... obj); //вернёт кол-во удалённых запиисей

    @Update
    void update(T obj);
    @Update
    int updateSome(T... obj); //вернёт кол-во обновлённых заисей
}
