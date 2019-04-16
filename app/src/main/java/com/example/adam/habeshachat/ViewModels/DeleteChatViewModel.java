package com.example.adam.habeshachat.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.adam.habeshachat.Database_Classes.AppDatabase;
import com.example.adam.habeshachat.POJO_Classes.chat_pojo;

import java.util.List;

public class DeleteChatViewModel extends AndroidViewModel {

    private final List<chat_pojo> ForumList;

    private AppDatabase appDatabase;

    public DeleteChatViewModel(@NonNull Application application) {
        super(application);

        appDatabase=AppDatabase.getInstance(this.getApplication());
        ForumList= appDatabase.chatDao().loadAllForums();
    }

    public List<chat_pojo> getForumList(){
        return ForumList;
    }

    public void DeleteChat(chat_pojo chatPojo){
        new deleteAsyncTask(appDatabase).execute(chatPojo);
    }


    public void AddChat(chat_pojo forumPojo){
        new AddAsyncTask(appDatabase).execute(forumPojo);
    }





    private class AddAsyncTask extends AsyncTask<chat_pojo, Void,Void> {

        public AppDatabase appDatbase;

        public AddAsyncTask(AppDatabase appDatabase) {
            this.appDatbase=appDatabase;
        }


        @Override
        protected Void doInBackground(chat_pojo... chat_pojos) {
            appDatbase.chatDao().insertChats(chat_pojos[0]);
            return null;
        }
    }




    private class deleteAsyncTask extends AsyncTask<chat_pojo, Void, Void> {

        private AppDatabase appDatabase;

        public deleteAsyncTask(AppDatabase appDatabase) {
            this.appDatabase=appDatabase;
        }

        @Override
        protected Void doInBackground(chat_pojo... chat_pojos) {
            appDatabase.chatDao().deleteChats(chat_pojos[0]);
            return null;
        }
    }
}
