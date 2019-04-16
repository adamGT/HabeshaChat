package com.example.adam.habeshachat.POJO_Classes;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "chats")
public class chat_pojo {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String Message;
    private boolean IsMe;

    public chat_pojo() {
    }

    public chat_pojo(String message, boolean isMe) {
        Message = message;
        this.IsMe = isMe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public boolean getIsMe() {
        return IsMe;
    }

    public void setIsMe(boolean me) {
        IsMe = me;
    }
}
