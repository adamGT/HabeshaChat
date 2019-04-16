package com.example.adam.habeshachat.Functional_Classes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.adam.habeshachat.POJO_Classes.friends_pojo;
import com.example.adam.habeshachat.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    List<friends_pojo> grades;
    private View.OnClickListener onClickListener;

    public RecyclerViewAdapter(List<friends_pojo> grades, View.OnClickListener onClickListener) {
        this.grades = grades;
        this.onClickListener=onClickListener;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.friends_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        friends_pojo friendsPojo=grades.get(position);
        holder.Tittle.setText(friendsPojo.getTittle());
        holder.Time.setText(friendsPojo.getTime());
//        holder.gradeIcon.setImageResource(gradesPojo.getIcon());
        holder.itemView.setTag(friendsPojo);
        holder.itemView.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return grades.size();
    }

    public void AddGrade(List<friends_pojo> grades){
        this.grades=grades;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView Tittle;
        public TextView Time;
        //        public ImageView gradeIcon;
        public ViewHolder(View itemView) {
            super(itemView);
            Tittle=(TextView) itemView.findViewById(R.id.Tittle);
            Time=(TextView) itemView.findViewById(R.id.Time);
//            gradeIcon=(ImageView) itemView.findViewById(R.id.gradeIcon);
        }
    }
}