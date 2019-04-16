package com.example.adam.habeshachat.Functional_Classes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.adam.habeshachat.POJO_Classes.chat_pojo;
import com.example.adam.habeshachat.R;

import java.util.List;

public class ChatRecyclerViewAdapter extends RecyclerView.Adapter<ChatRecyclerViewAdapter.CustomViewHolder> {

    List<chat_pojo> chatlist;
    Context context;
    class CustomViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public CustomViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.messageText);
        }
    }

    public ChatRecyclerViewAdapter(List<chat_pojo> chatlist, Context context) {
        this.chatlist = chatlist;
        this.context = context;
    }

    public void AddChat(chat_pojo chats){
        this.chatlist.add(chats);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if(chatlist.get(position).getIsMe()){
            return R.layout.mychat_item;
        }
        return R.layout.chat_item;
    }

    @Override
    public int getItemCount() {
        return  chatlist.size();
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(viewType, parent, false));
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.textView.setText(chatlist.get(position).getMessage());
    }
}