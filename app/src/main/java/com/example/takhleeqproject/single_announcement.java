package com.example.takhleeqproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class single_announcement extends AppCompatActivity {

    TextView date,time,heading,headingcontent;
    Button BackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_announcement);

        Intent intent = getIntent();
        Announcement_content content = (Announcement_content)intent.getSerializableExtra("Content");

        date = (TextView)findViewById(R.id.date);
        time = (TextView)findViewById(R.id.time);
        heading = (TextView)findViewById(R.id.heading);
        headingcontent = (TextView)findViewById(R.id.content);
        BackButton = (Button)findViewById(R.id.backToList);
        date.setText(content.getDate());
        time.setText(content.getTime());
        heading.setText(content.getHeading());
        headingcontent.setText(content.getContent());

        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 =new Intent(getApplicationContext(),Announcements.class);
                finish();
                startActivity(intent1);
            }
        });

    }
}