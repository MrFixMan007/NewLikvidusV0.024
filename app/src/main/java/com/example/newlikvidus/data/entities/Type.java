package com.example.newlikvidus.data.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.PrimaryKey;

@Entity(tableName = "type", indices = {@Index(value = {"name"}, unique = true)})
public class Type {
    @PrimaryKey(autoGenerate = true)
    private long type_id;
    @ColumnInfo(collate = ColumnInfo.LOCALIZED)
    private String name;

    //Конструкторы
    public Type(@NonNull String name){
        setName(name);
    }

    //Сеттеры
    public void setType_id(long type_id) {
        this.type_id = type_id;
    }
    public void setName(@NonNull String name) {
        if(name.length() <= 100) this.name = name;
        else this.name = name.substring(0, 100);
    }

    //Геттеры
    public long getType_id() {
        return type_id;
    }
    public String getName() {
        return String.valueOf(this.name);
    }

    //Функции
    @Override
    public String toString() {
        return "Type{ (long)type_id="+type_id+", (str("+name.length()+"))name="+name+"}";
    }
}
