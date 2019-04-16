package com.example.adam.habeshachat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.adam.habeshachat.Database_Classes.AppDatabase;
import com.example.adam.habeshachat.Functional_Classes.ChatRecyclerViewAdapter;
import com.example.adam.habeshachat.POJO_Classes.chat_pojo;

import java.util.ArrayList;

public class ChatRoom_Activity extends AppCompatActivity implements View.OnClickListener{

    String[] Messages;
    boolean[] isMe;
    RecyclerView recyclerView;
    ChatRecyclerViewAdapter adapter;
    Button sendButton;
    EditText editText;

    AppDatabase appDatabase;

    ArrayList<chat_pojo> userList = new ArrayList<chat_pojo>();
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room_);
        Bundle bundle= getIntent().getExtras();
        String Title = bundle.getString("Tittle");
        getSupportActionBar().setTitle(Title);

        appDatabase=AppDatabase.getInstance(this);

        sendButton=findViewById(R.id.sendButton);
        editText=findViewById(R.id.editMessage);
        recyclerView=(RecyclerView) findViewById(R.id.RecyclerView2);

        layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        Messages=new String[]{"hi","hey bro","how you doin?","im good"};
        isMe=new boolean[]{true,false,true,false,true};

        userList.clear();
        for (int i = 0; i <Messages.length ; i++) {
            chat_pojo pojo = new chat_pojo(Messages[i],isMe[i]);
            userList.add(pojo);
        }
        adapter = new ChatRecyclerViewAdapter( appDatabase.chatDao().loadAllChats(),this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editText.getText().toString().isEmpty()) {
                    chat_pojo pojo = new chat_pojo(editText.getText().toString(), true);
                    appDatabase.chatDao().insertChats(pojo);
                    adapter.AddChat(pojo);
//                    adapter.notifyDataSetChanged();
                    editText.setText("");
                    if (!isLastVisible()) {
                        recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);
                    }
                }
            }
        });

    }

    boolean isLastVisible() {
        LinearLayoutManager layoutManager = ((LinearLayoutManager) recyclerView.getLayoutManager());
        int pos = layoutManager.findLastCompletelyVisibleItemPosition();
        int numItems = recyclerView.getAdapter().getItemCount();
        return (pos >= numItems);
    }

    @Override
    public void onClick(View v) {

    }
}
