package com.example.newlikvidus.data.entities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "character", foreignKeys = @ForeignKey(entity = Type.class,
        parentColumns = "type_id", childColumns = "type_id_fk"))
//parentColumns указал id из таблицы type, childColumns - внешний ключ из Character
public class Character {
    @PrimaryKey(autoGenerate = true) @NonNull
    public long character_id;
    @NonNull @ColumnInfo(index = true)
    public long type_id_fk;
    @NonNull
    public String name;
    @NonNull
    public float low;
    @NonNull
    public float top;
    public String description;
    public String measured_in;
    public float default_value;
    public float koef;

    //Конструкторы
    @Ignore
    public Character() {
    }

    @Ignore
    public Character(long type_id_fk, @NonNull String name, float low, float top) {
        this(type_id_fk, name, low, top, "", "");
    }

    @Ignore
    public Character(long type_id_fk, @NonNull String name, float low, float top, @NonNull String description) {
        this(type_id_fk, name, low, top, description, "");
    }

    @Ignore
    public Character(long type_id_fk, @NonNull String name, float low, float top, @NonNull String description, @NonNull String measured_in) {
        this.type_id_fk = type_id_fk;
        this.low = low;
        this.top = top;
        setName(name);
        setDescription(description);
        setMeasured_in(measured_in);
        this.koef = 1;
    }
    @Ignore
    public Character(long type_id_fk, @NonNull String name, float low, float top, @NonNull String description, @NonNull String measured_in, float default_value) {
        this.type_id_fk = type_id_fk;
        this.low = low;
        this.top = top;
        this.default_value = default_value;
        setName(name);
        setDescription(description);
        setMeasured_in(measured_in);
        this.koef = 1;
    }

    public Character(long type_id_fk, @NonNull String name, float low, float top, @NonNull String description, @NonNull String measured_in, float default_value, float koef) {
        this.type_id_fk = type_id_fk;
        this.low = low;
        this.top = top;
        this.default_value = default_value;
        setName(name);
        setDescription(description);
        setMeasured_in(measured_in);
        this.koef = koef;
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

    public float getKoef() {
        return koef;
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
        if(measured_in.length() <= 45) this.measured_in = String.valueOf(measured_in);
        else this.measured_in = measured_in.substring(0, 45);
    }

    public void setDefault_value(float default_value) {
        this.default_value = default_value;
    }

    public void setKoef(float koef) {
        this.koef = koef;
    }

    //Функции
    @Override
    public String toString() {
        return "Character{ (long)character_id="+character_id+", (long)type_id_fk="+type_id_fk+", (str("+name.length()+"))name="+name+
                ", (str)description="+description+", (str)measured_in="+measured_in+
                ", (float)low="+low+", (float)top="+top+", (float)default_value="+default_value+
                ", (float)koef="+koef+"}";
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Character character = (Character) obj;
        return this.name.equals(character.name)
                && this.character_id == character.character_id
                && this.description.equals(character.description)
                && this.measured_in.equals(character.measured_in)
                && this.type_id_fk == character.type_id_fk
                && this.low == character.low
                && this.top == character.top
                && this.koef == character.koef;
    }
}
