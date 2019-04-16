package com.example.adam.habeshachat.Database_Classes;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.adam.habeshachat.POJO_Classes.chat_pojo;

import java.util.List;

@Dao
public interface ChatDao {
    @Query("SELECT * FROM chats ORDER BY id")
    List<chat_pojo> loadAllChats();

    @Insert
    void insertChats(chat_pojo chat);

    @Query("SELECT * FROM chats WHERE id = :id")
    chat_pojo getChatById(String id);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateChats(chat_pojo Chat);

    @Delete
    void deleteChats(chat_pojo Chat);
}