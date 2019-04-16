package com.example.adam.habeshachat.Database_Classes;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.adam.habeshachat.POJO_Classes.friends_pojo;

import java.util.List;
@Dao
public interface FriendDao {
    @Query("SELECT * FROM friends ORDER BY id")
    List<friends_pojo> loadAllfriends();

    @Insert
    void insertfriends(friends_pojo chat);

    @Query("SELECT * FROM chats WHERE id = :id")
    friends_pojo getfriendById(String id);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updatefriends(friends_pojo Chat);

    @Delete
    void deletefriends(friends_pojo Chat);
}