package com.example.newlikvidus.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "type")
public class Type {
    @PrimaryKey(autoGenerate = true)
    private long type_id;
    private String name;

    public Type(String name){
        if(name.length() <= 100) this.name = name;
        else this.name = name.substring(0, 100);
    }

    public void setType_id(long type_id) {
        this.type_id = type_id;
    }

    public long getType_id() {
        return type_id;
    }

    public String getName() {
        return String.valueOf(this.name);
    }

    public void setName(String name) {
        this.name = String.valueOf(name);
    }

    @Override
    public String toString() {
        return "Type{ (int)type_id="+type_id+", (str("+name.length()+"))name="+name+"}";
    }
}
