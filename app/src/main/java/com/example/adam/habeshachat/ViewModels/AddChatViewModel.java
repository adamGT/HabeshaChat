package com.example.adam.habeshachat.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.adam.habeshachat.Database_Classes.AppDatabase;
import com.example.adam.habeshachat.POJO_Classes.chat_pojo;

public class AddChatViewModel extends AndroidViewModel {

    private AppDatabase appDatabase;

    public AddChatViewModel(@NonNull Application application) {
        super(application);
        appDatabase = AppDatabase.getInstance(this.getApplication());
    }

    public void AddChat(chat_pojo chatPojo){
        new AddAsyncTask(appDatabase).execute(chatPojo);
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
}
