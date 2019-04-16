package com.example.adam.habeshachat.Database_Classes;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

import com.example.adam.habeshachat.POJO_Classes.chat_pojo;
import com.example.adam.habeshachat.POJO_Classes.friends_pojo;

@Database(entities = {chat_pojo.class,friends_pojo.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final String LOG_TAG=AppDatabase.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME="notice";
    private static AppDatabase sInstance;

    public static AppDatabase getInstance(Context context){
        if(sInstance==null){
            synchronized (LOCK){
                Log.d(LOG_TAG,"creating new Database instance");
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class,AppDatabase.DATABASE_NAME)
                        //BAD PRACTICE
                        .allowMainThreadQueries()
                        .build();
            }
        }
        Log.d(LOG_TAG,"Getting the Database Ready");
        return sInstance;
    }
    public static void DestoyInstance(){
        sInstance=null;
    }

    public abstract ChatDao chatDao();
    public abstract FriendDao friendDao();

}
