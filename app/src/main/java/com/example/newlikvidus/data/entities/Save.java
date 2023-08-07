package com.example.newlikvidus.data.entities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "save", foreignKeys = @ForeignKey(entity = Type.class,
        parentColumns = "type_id", childColumns = "type_id_fk"))
//parentColumns указал id из таблицы type, childColumns - внешний ключ из Save
public class Save {
    @PrimaryKey(autoGenerate = true) @NonNull
    private long save_id;
    @NonNull
    private String name;
    @NonNull
    private String date;
    @NonNull
    private long type_id_fk;
    private String description;

    //Конструкторы
    public Save(){}
    public Save(@NonNull String name, @NonNull String date, int type_int){
        this(name, date, "", type_int);
    }
    public Save(@NonNull String name, @NonNull String date, @NonNull String description, int type_int) {
        setName(name);
        setDate(date);
        setDescription(description);
        setType_id_fk(type_int);
    }

    //Геттеры
    public long getSave_id() {
        return save_id;
    }

    public String getName() {
        return String.valueOf(this.name);
    }

    public String getDate() {
        return String.valueOf(this.date);
    }

    public String getDescription() {
        return String.valueOf(this.description);
    }

    public long getType_id_fk() {
        return type_id_fk;
    }

    //Сеттеры
    public void setSave_id(long save_id) {
        if(save_id > 0) this.save_id = save_id;
    }
    public void setDate(@NonNull String date) {
        this.date = String.valueOf(date);
    }
    public void setName(@NonNull String name) {
        if(name.length() <= 100) this.name = String.valueOf(name);
        else this.name = name.substring(0, 100);
    }
    public void setDescription(@NonNull String description) {
        if(description.length() <= 300) this.description = String.valueOf(description);
        else this.description = description.substring(0, 300);
    }
    public void setType_id_fk(long type_id_fk) {
        if(type_id_fk > 0) this.type_id_fk = type_id_fk;
    }

    //Функции
    @Override
    public String toString() {
        return "Save{" +
                "(long) save_id = "+save_id+", (str("+name.length()+"))name = "+name+", (str)date = "+date+", " +
                "(str("+description.length()+"))description = "+description+", (long)type_int = " + type_id_fk +
                '}';
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Save save = (Save) obj;
        return this.name.equals(save.name) && this.save_id == save.save_id && this.date.equals(save.date) && this.description.equals(save.description)
                && this.type_id_fk == save.type_id_fk;
    }
}