package com.example.adam.habeshachat;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.adam.habeshachat.Functional_Classes.RecyclerViewAdapter;
import com.example.adam.habeshachat.POJO_Classes.friends_pojo;

import java.util.ArrayList;

public class FriendList_Activity extends AppCompatActivity implements View.OnClickListener{

    String[] title;
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;

    ArrayList<friends_pojo> userList = new ArrayList<friends_pojo>();
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_list_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView=(RecyclerView) findViewById(R.id.RecyclerView1);

        layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        title=new String[]{"Adam Gt","Aman","Aman G","Abel","Ashe"};

        userList.clear();
        for (int i = 0; i <title.length ; i++) {
            friends_pojo pojo = new friends_pojo(title[i]);
            userList.add(pojo);
        }
        adapter = new RecyclerViewAdapter( new ArrayList<friends_pojo>(),this);
        adapter.AddGrade(userList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onClick(View v) {
        TextView TVuserName=(TextView)v.findViewById(R.id.Tittle);
        String userName=TVuserName.getText().toString();
        Log.d("Clicked ",userName);
        Intent intent = new Intent(this,ChatRoom_Activity.class);
        intent.putExtra("Tittle",userName);
        startActivity(intent);
    }
}
