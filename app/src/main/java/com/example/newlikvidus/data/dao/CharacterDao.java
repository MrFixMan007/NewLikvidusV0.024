package com.example.newlikvidus.data.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.newlikvidus.data.BaseDao;
import com.example.newlikvidus.data.entities.Character;

import java.util.List;

@Dao
public interface CharacterDao extends BaseDao<Character> {
    @Query("SELECT * FROM character WHERE character_id = :id")
    Character getById(long id);
    @Query("SELECT * FROM character")
    List<Character> getAll();
    @Query("SELECT COUNT(*) FROM character")
    int getCountOfCharacters();
}
