package com.example.newlikvidus.data.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "character", foreignKeys = @ForeignKey(entity = Type.class,
        parentColumns = "type_id", childColumns = "type_id_fk"))
//parentColumns указал id из таблицы type, childColumns - внешний ключ из Character
public class Character {
    @PrimaryKey(autoGenerate = true) @NonNull
    private long character_id;
    @NonNull
    private long type_id_fk;
    @NonNull
    private String name;
    @NonNull
    private float low;
    @NonNull
    private float top;
    private String description;
    private String measured_in;
    private float default_value;

    //Конструкторы
    public Character(){}

    public Character(long type_id_fk, @NonNull String name, float low, float top) {
        this(type_id_fk, name, low, top, "", "");
    }

    public Character(long type_id_fk, @NonNull String name, float low, float top, @NonNull String description) {
        this(type_id_fk, name, low, top, description, "");
    }

    public Character(long type_id_fk, @NonNull String name, float low, float top, @NonNull String description, @NonNull String measured_in) {
        this.type_id_fk = type_id_fk;
        this.low = low;
        this.top = top;
        setName(name);
        setDescription(description);
        setMeasured_in(measured_in);
    }

    public Character(long type_id_fk, @NonNull String name, float low, float top, @NonNull String description, @NonNull String measured_in, float default_value) {
        this.type_id_fk = type_id_fk;
        this.low = low;
        this.top = top;
        this.default_value = default_value;
        setName(name);
        setDescription(description);
        setMeasured_in(measured_in);
    }

    //Геттеры
    public long getCharacter_id() {
        return character_id;
    }

    public long getType_id_fk() {
        return type_id_fk;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public float getLow() {
        return low;
    }

    public float getTop() {
        return top;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    @NonNull
    public String getMeasured_in() {
        return measured_in;
    }

    public float getDefault_value() {
        return default_value;
    }

    //Сеттеры
    public void setCharacter_id(long character_id) {
        if(character_id > 0) this.character_id = character_id;
    }

    public void setType_id_fk(long type_id_fk) {
        if(type_id_fk > 0) this.type_id_fk = type_id_fk;
    }

    public void setName(@NonNull String name) {
        if(name.length() <= 100) this.name = String.valueOf(name);
        else this.name = name.substring(0, 100);
    }

    public void setLow(float low) {
        this.low = low;
    }

    public void setTop(float top) {
        this.top = top;
    }

    public void setDescription(@NonNull String description) {
        if(description.length() <= 300) this.description = String.valueOf(description);
        else this.description = description.substring(0, 300);
    }

    public void setMeasured_in(@NonNull String measured_in) {
        if(description.length() <= 45) this.description = String.valueOf(description);
        else this.description = description.substring(0, 45);
    }

    public void setDefault_value(float default_value) {
        this.default_value = default_value;
    }

    //Функции
    @Override
    public String toString() {
        return "Character{ (long)character_id="+character_id+", (long)type_id_fk="+type_id_fk+", (str("+name.length()+"))name="+name+
                "(str("+description.length()+"))description="+description+"(str("+measured_in.length()+"))measured_in="+measured_in+
                "(float)low="+low+", (float)top="+top+"(float)default_value="+default_value+"}";
    }
}
