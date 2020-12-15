package com.example.takhleeqproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class EventDetailsClass extends AppCompatActivity {

    TextView name,time,date,venue,performer,guest1,guest2,guest3,organizer1,organizer2,organizer3,sponser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_details);

        Intent intent = getIntent();
        EventDetails eventDetails = (EventDetails)intent.getSerializableExtra("EventDetails");

        name = (TextView)findViewById(R.id.name);
        time = (TextView)findViewById(R.id.time);
        date = (TextView)findViewById(R.id.date);
        venue = (TextView)findViewById(R.id.venue);
        performer = (TextView)findViewById(R.id.performer);
        guest1 = (TextView)findViewById(R.id.guest1);
        guest2 = (TextView)findViewById(R.id.guest2);
        guest3 = (TextView)findViewById(R.id.guest3);
        organizer1 = (TextView)findViewById(R.id.organizer1);
        organizer2 = (TextView)findViewById(R.id.organizer2);
        organizer3 = (TextView)findViewById(R.id.organizer3);
        sponser = (TextView)findViewById(R.id.sponser);


        name.setText(eventDetails.getName());
        time.setText(eventDetails.getTime());
        date.setText(eventDetails.getDate());
        venue.setText(eventDetails.getVenue());
        performer.setText(eventDetails.getPerformer());
        guest1.setText(eventDetails.getGuest1());
        guest2.setText(eventDetails.getGuest2());
        guest3.setText(eventDetails.getGuest3());
        organizer1.setText(eventDetails.getOrganizer1());
        organizer2.setText(eventDetails.getOrganizer2());
        organizer3.setText(eventDetails.getOrganizer3());
        sponser.setText(eventDetails.getSponser());

    }
}