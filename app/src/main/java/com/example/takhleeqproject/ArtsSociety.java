package com.example.takhleeqproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ArtsSociety extends AppCompatActivity {


    RecyclerView recyclerView;
    List<EventDetails> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arts_society);

        recyclerView = findViewById(R.id.rv);
        list = new ArrayList<>();

        list.add(new EventDetails("Qawali Night","20/10/2020","10:20","Event Complex","Ali Azmat","A","B","C","Org1","Org2","Org3","Sponser"));
        list.add(new EventDetails("Qawali Night","20/10/2020","10:20","Event Complex","Ali Azmat","A","B","C","Org1","Org2","Org3","Sponser"));
        list.add(new EventDetails("Qawali Night","20/10/2020","10:20","Event Complex","Ali Azmat","A","B","C","Org1","Org2","Org3","Sponser"));
        list.add(new EventDetails("Qawali Night","20/10/2020","10:20","Event Complex","Ali Azmat","A","B","C","Org1","Org2","Org3","Sponser"));
        list.add(new EventDetails("Qawali Night","20/10/2020","10:20","Event Complex","Ali Azmat","A","B","C","Org1","Org2","Org3","Sponser"));
        list.add(new EventDetails("Qawali Night","20/10/2020","10:20","Event Complex","Ali Azmat","A","B","C","Org1","Org2","Org3","Sponser"));

        RecyclerViewClass adapter = new RecyclerViewClass(list,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}