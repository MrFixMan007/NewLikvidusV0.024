package com.example.newlikvidus.data.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "value", foreignKeys = {@ForeignKey(entity = Character.class,
        parentColumns = "character_id", childColumns = "character_id_fk"), @ForeignKey(entity = Save.class,
        parentColumns = "save_id", childColumns = "save_id_fk")})
//parentColumns указал id из таблиц character и save, childColumns - внешний ключ из PossibleValue и Save
public class Value {
    @PrimaryKey(autoGenerate = true) @NonNull
    private long value_id;
    @NonNull
    private long character_id_fk;
    @NonNull
    private long save_id_fk;
    @NonNull
    private float value;
    //Конструкторы

    public Value(){}
    public Value(long character_id_fk, long save_id_fk, float value) {
        this.character_id_fk = character_id_fk;
        this.save_id_fk = save_id_fk;
        this.value = value;
    }
    //Геттеры

    public long getValue_id() {
        return value_id;
    }

    public long getCharacter_id_fk() {
        return character_id_fk;
    }

    public long getSave_id_fk() {
        return save_id_fk;
    }

    public float getValue() {
        return value;
    }
    //Сеттеры

    public void setValue_id(long value_id) {
        this.value_id = value_id;
    }

    public void setCharacter_id_fk(long character_id_fk) {
        this.character_id_fk = character_id_fk;
    }

    public void setSave_id_fk(long save_id_fk) {
        this.save_id_fk = save_id_fk;
    }

    public void setValue(float value) {
        this.value = value;
    }

    //Функции
    @Override
    public String toString() {
        return "Value{ (long)value_id="+value_id+", (long)character_id_fk="+character_id_fk+"(long)save_id_fk="+save_id_fk+
                "(float)value="+value+"}";
    }
}
