package com.example.adam.habeshachat.POJO_Classes;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "friends")
public class friends_pojo {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String Tittle;
    private String Time;
    private int Icon;

    public friends_pojo() {
    }
    @Ignore
    public friends_pojo(String tittle) {
        Tittle = tittle;
    }

    public friends_pojo(String tittle, String time, int icon) {
        Tittle = tittle;
        Time = time;
        Icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return Tittle;
    }

    public void setTittle(String tittle) {
        Tittle = tittle;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public int getIcon() {
        return Icon;
    }

    public void setIcon(int icon) {
        Icon = icon;
    }
}
