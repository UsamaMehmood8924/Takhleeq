package com.example.takhleeqproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Events extends AppCompatActivity {

    TextView soc1,soc2,soc3,soc4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        soc1 = (TextView) findViewById(R.id.artsSociety);
        soc2 = (TextView) findViewById(R.id.daramaSociety);
        soc3 = (TextView) findViewById(R.id.musicSociety);
        soc4 = (TextView) findViewById(R.id.debateSociety);

        soc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ArtsSociety.class);
                startActivity(intent);
            }
        });
        soc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DaramaSociety.class);
                startActivity(intent);
            }
        });
        soc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MusicSociety.class);
                startActivity(intent);
            }
        });
        soc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DebateSociety.class);
                startActivity(intent);
            }
        });
    }
}