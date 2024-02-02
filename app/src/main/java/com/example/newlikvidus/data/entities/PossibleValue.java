package com.example.newlikvidus.data.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "possible_value", foreignKeys = @ForeignKey(entity = Character.class,
        parentColumns = "character_id", childColumns = "character_id_fk"))
//parentColumns указал id из таблицы character, childColumns - внешний ключ из PossibleValue
public class PossibleValue {
    @PrimaryKey(autoGenerate = true) @NonNull
    public long possible_value_id;
    @NonNull
    public float value;
    @NonNull @ColumnInfo(index = true)
    public long character_id_fk;
    //Конструкторы

    @Ignore
    public PossibleValue() {}
    public PossibleValue(float value, long character_id_fk) {
        this.value = value;
        this.character_id_fk = character_id_fk;
    }
    //Геттеры

    public float getValue() {
        return value;
    }
    public long getCharacter_id_fk() {
        return character_id_fk;
    }
    public long getPossible_value_id() {
        return possible_value_id;
    }
    //Сеттеры

    public void setValue(float value) {
        this.value = value;
    }
    public void setCharacter_id_fk(long character_id_fk) {
        this.character_id_fk = character_id_fk;
    }
    public void setPossible_value_id(long possible_value_id) {
        this.possible_value_id = possible_value_id;
    }

    //Функции
    @Override
    public String toString() {
        return "PossibleValue{ (long)possible_value_id="+possible_value_id+", (long)character_id_fk="+character_id_fk+", (float)value="+value+"}";
    }
}
