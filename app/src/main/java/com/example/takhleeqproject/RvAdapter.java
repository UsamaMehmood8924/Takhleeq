package com.example.takhleeqproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {
    List<Announcement_content> ls;
    Context c;
    public RvAdapter(List<Announcement_content> ls, Context c) {
        this.ls = ls;
        this.c = c;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(c).inflate(R.layout.row,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.name.setText(ls.get(position).getName());
        holder.heading.setText(ls.get(position).getHeading());
        holder.content.setText(ls.get(position).getContent());
        holder.date.setText(ls.get(position).getDate());
        holder.time.setText(ls.get(position).getTime());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Announcement_content sendit = new Announcement_content();
                sendit.setHeading(ls.get(position).getHeading());
                sendit.setContent(ls.get(position).getContent());
                sendit.setDate(ls.get(position).getDate());
                sendit.setTime(ls.get(position).getTime());
                sendit.setName(ls.get(position).getName());

                Intent intent = new Intent(c,single_announcement.class);
                intent.putExtra("Content",sendit);
                c.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return ls.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, heading, date,time,content;
        LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            heading = itemView.findViewById(R.id.heading);
            content = itemView.findViewById(R.id.content);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
            linearLayout = itemView.findViewById(R.id.liner_layout);
        }
    }
}
