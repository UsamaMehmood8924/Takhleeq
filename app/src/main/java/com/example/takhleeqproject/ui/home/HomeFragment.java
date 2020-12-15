package com.example.takhleeqproject.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.takhleeqproject.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private ImageButton photogallary;
    private Button event,announ,team,recruit,about;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        /*final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        photogallary = root.findViewById(R.id.lphotogallary);
        event = root.findViewById(R.id.levents);
        announ = root.findViewById(R.id.lannouncement);
        team = root.findViewById(R.id.lteam);
        recruit = root.findViewById(R.id.lrecruitment);
        about = root.findViewById(R.id.about);

        photogallary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),com.example.takhleeqproject.photo_gallary.class);
                startActivity(intent);
            }
        });
        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),com.example.takhleeqproject.Events.class);
                startActivity(intent);
            }
        });
        announ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),com.example.takhleeqproject.Announcements.class);
                startActivity(intent);
            }
        });
        team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),com.example.takhleeqproject.team.class);
                startActivity(intent);
            }
        });
        recruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),com.example.takhleeqproject.requirtment_Screen.class);
                startActivity(intent);
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),com.example.takhleeqproject.About.class);
                startActivity(intent);
            }
        });
        return root;
    }
}