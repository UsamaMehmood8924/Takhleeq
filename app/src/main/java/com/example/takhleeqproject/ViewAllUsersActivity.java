package com.example.takhleeqproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewAllUsersActivity extends AppCompatActivity {

    RecyclerView srv;
    List<UserInfo> userList;
    FirebaseAuth mAuth;
    FirebaseUser user;
    String uid;
    SRvAdopter adopter;
    FirebaseDatabase database;
    DatabaseReference reference;

    ImageView ImageBackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_users);

        ImageBackBtn = findViewById(R.id.btnback);
        srv = findViewById(R.id.searchRV);
        userList = new ArrayList<>();
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("UserProfiles");
        mAuth = FirebaseAuth.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        uid = user.getUid();

        ImageBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                userList.clear();

                for(DataSnapshot snapshot1 : snapshot.getChildren() )
                {
                    UserInfo mUserInfo = snapshot1.getValue(UserInfo.class);

                    assert mUserInfo !=null;
                    if(!mUserInfo.getId().equals(uid))
                    {
                        userList.add(mUserInfo);
                    }

                    adopter = new SRvAdopter(userList,ViewAllUsersActivity.this);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ViewAllUsersActivity.this);
                    srv.setLayoutManager(layoutManager);
                    srv.setAdapter(adopter);
                }


            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}