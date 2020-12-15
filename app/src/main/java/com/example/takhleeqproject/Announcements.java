package com.example.takhleeqproject;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Announcements extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference reference;
    RecyclerView rv;
    List<Announcement_content> list;
    Announcement_content announcement = new Announcement_content();
    private String Tag = "okay";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcements);

        rv=findViewById(R.id.rv);
        list = new ArrayList<>();
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Announcements");

        final RvAdapter adapter = new RvAdapter(list,this);
        final RecyclerView.LayoutManager lm = new LinearLayoutManager(this);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()){
                    String name = snapshot1.child("name").getValue().toString();
                    String date = snapshot1.child("date").getValue().toString();
                    String time = snapshot1.child("time").getValue().toString();
                    String heading = snapshot1.child("heading").getValue().toString();
                    String content = snapshot1.child("content").getValue().toString();
                    list.add(new Announcement_content(name,heading,content,date,time));

                    rv.setLayoutManager(lm);
                    rv.setAdapter(adapter);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);
    }
}