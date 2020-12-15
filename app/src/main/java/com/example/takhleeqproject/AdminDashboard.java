package com.example.takhleeqproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AdminDashboard extends AppCompatActivity {

    TextView _adminName;
    Button _addAdmin;
    Button _uploadImage;
    Button _viewAllUsers;
    Button _viewAllAnnouncements;
    Button _addAnnouncements;
    Button _viewRecruitments;
    Button _manageEvents;
    Button _switchToUsers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        _adminName = findViewById(R.id.adminName);
        _addAdmin = findViewById(R.id.addAdmin);
        _uploadImage = findViewById(R.id.uploadImage);
        _viewAllUsers = findViewById(R.id.viewAllUsers);
        _viewAllAnnouncements = findViewById(R.id.viewAllAnnouncements);
        _addAnnouncements = findViewById(R.id.addAnnouncements);
        _viewRecruitments = findViewById(R.id.viewRecruitments);
        _manageEvents = findViewById(R.id.manageEvents);
        _switchToUsers = findViewById(R.id.switchToUser);

        _addAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminDashboard.this,AddAdminActivity.class);
                startActivity(i);
            }
        });

        _uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminDashboard.this,uploadImageActivity.class);
                startActivity(i);
            }
        });

        _viewAllUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminDashboard.this,ViewAllUsersActivity.class);
                startActivity(i);
            }
        });

        _viewAllAnnouncements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminDashboard.this,ViewAnnouncementsActivity.class);
                startActivity(i);
            }
        });

        _addAnnouncements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminDashboard.this,AddAnnouncementsActivity.class);
                startActivity(i);
            }
        });

        _viewRecruitments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminDashboard.this,ViewRecruitmentsActivity.class);
                startActivity(i);
            }
        });

        _manageEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        _switchToUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminDashboard.this,Home.class);
                finish();
                startActivity(i);
            }
        });


    }
}