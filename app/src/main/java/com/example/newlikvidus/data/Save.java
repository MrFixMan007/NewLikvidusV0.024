package com.example.newlikvidus.data;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "save", foreignKeys = @ForeignKey(entity = Type.class, parentColumns = "type_id", childColumns = "type_id_fk"))
//parentColumns указал id из таблицы type, childColumns - внешний ключ из Save
public class Save {
    @PrimaryKey(autoGenerate = true)
    private long save_id;
    private String name;
    private String date;
    private String description;
    private long type_id_fk;

    public Save(){}

    public Save(long save_id, String name, String date, int type_int) {
        this(save_id, name, date, "", type_int);
    }

    public Save(long save_id, String name, String date, String description, int type_int) {
        this.save_id = save_id;
        if(name.length() <= 100) this.name = String.valueOf(name);
        else this.name = name.substring(0, 100);
        this.date = String.valueOf(date);
        if(description.length() <= 300) this.description = String.valueOf(description);
        else this.description = description.substring(0, 300);
        this.type_id_fk = type_int;
    }

    public Save(String name, String date, String description, int type_int) {
        if(name.length() <= 100) this.name = String.valueOf(name);
        else this.name = name.substring(0, 100);
        this.date = String.valueOf(date);
        if(description.length() <= 300) this.description = String.valueOf(description);
        else this.description = description.substring(0, 300);
        this.type_id_fk = type_int;
    }

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

    public void setSave_id(long save_id) {
        this.save_id = save_id;
    }

    public void setName(String name) {
        this.name = String.valueOf(name);
    }

    public void setDate(String date) {
        this.date = String.valueOf(date);
    }

    public void setDescription(String description) {
        this.description = String.valueOf(description);
    }

    public void setType_id_fk(long type_id_fk) {
        this.type_id_fk = type_id_fk;
    }

    public String print(){
        StringBuilder strB = new StringBuilder("");
        strB.append("(int) save_id = "+save_id+", (str("+name.length()+"))name = "+name+", (str)date = "+date+", " +
                "(str("+description.length()+"))description = "+description+", (int)type_int = " + type_id_fk +".");
        return String.valueOf(strB);
    }//TODO: мб удалить

    @Override
    public String toString() {
        return "Save{" +
                "(int) save_id = "+save_id+", (str("+name.length()+"))name = "+name+", (str)date = "+date+", " +
                "(str("+description.length()+"))description = "+description+", (int)type_int = " + type_id_fk +
                '}';
    }
}