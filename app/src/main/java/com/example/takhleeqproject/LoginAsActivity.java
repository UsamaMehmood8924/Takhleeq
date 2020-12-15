package com.example.takhleeqproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LoginAsActivity extends AppCompatActivity {

    Button _loginAsUser;
    Button _loginAsAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_as);

        _loginAsUser = findViewById(R.id.loginAsUser);
        _loginAsAdmin = findViewById(R.id.loginAsAdmin);

        _loginAsUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginAsActivity.this,Home.class);
                finish();
                startActivity(i);
            }
        });

        _loginAsAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginAsActivity.this,AdminDashboard.class);
                finish();
                startActivity(i);
            }
        });
    }
}