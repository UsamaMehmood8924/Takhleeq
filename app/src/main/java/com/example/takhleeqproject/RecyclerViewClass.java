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

public class RecyclerViewClass extends RecyclerView.Adapter<RecyclerViewClass.MyViewHolder> {

    List<EventDetails> list;
    Context c;
    public RecyclerViewClass(List<EventDetails> list, Context c) {
        this.list = list;
        this.c = c;
    }

    @NonNull
    @Override
    public RecyclerViewClass.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(c).inflate(R.layout.activity_single_event,parent,false);

        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewClass.MyViewHolder holder, final int position) {
        holder.name.setText(list.get(position).getName());
        holder.performer.setText(list.get(position).getPerformer());
        holder.venue.setText(list.get(position).getVenue());
        holder.date.setText(list.get(position).getDate());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventDetails eventDetails = new EventDetails();
                eventDetails.setName(list.get(position).getName());
                eventDetails.setDate(list.get(position).getDate());
                eventDetails.setTime(list.get(position).getTime());
                eventDetails.setId(list.get(position).getId());
                eventDetails.setPerformer(list.get(position).getPerformer());
                eventDetails.setVenue(list.get(position).getVenue());
                eventDetails.setGuest1(list.get(position).getGuest1());
                eventDetails.setGuest2(list.get(position).getGuest2());
                eventDetails.setGuest3(list.get(position).getGuest3());
                eventDetails.setOrganizer1(list.get(position).getOrganizer1());
                eventDetails.setOrganizer2(list.get(position).getOrganizer2());

                Intent intent = new Intent(c,EventDetailsClass.class);
                intent.putExtra("EventDetails",eventDetails);
                c.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,performer,venue,date;
        LinearLayout linearLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            performer = itemView.findViewById(R.id.performer);
            venue = itemView.findViewById(R.id.venue);
            date = itemView.findViewById(R.id.date);
            linearLayout = itemView.findViewById(R.id.liner_layout);
        }
    }
}
