package com.example.newlikvidus.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "CoefsOfArgs")
public class CoefOfArgs {

    public CoefOfArgs(String name, float value) {
        this.name = name;
        this.value = value;
    }

    public CoefOfArgs() {}

    @PrimaryKey(autoGenerate = true)
    public long id;

    public String name;

    public float value;
}