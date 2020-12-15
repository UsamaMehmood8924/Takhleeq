package com.example.takhleeqproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AddAdminActivity extends AppCompatActivity {

    EditText _userEmail;
    Button _makeAdmin;

    FirebaseAuth mAuth;
    FirebaseUser user;
    String uid;
    FirebaseDatabase database;
    DatabaseReference reference;
    DatabaseReference addAdminReference;

    String newAdminId;
    boolean isUserExists = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_admin);

        _userEmail = findViewById(R.id.userEmail);
        _makeAdmin = findViewById(R.id.makeAdmin);


        database = FirebaseDatabase.getInstance();
        reference = database.getReference("UserProfiles");
        addAdminReference = FirebaseDatabase.getInstance().getReference("Admin");
        mAuth = FirebaseAuth.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        uid = user.getUid();


        _makeAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Check Whether this user exists or not.
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        for(DataSnapshot snapshot1 : snapshot.getChildren() )
                        {
                            UserInfo mUserInfo = snapshot1.getValue(UserInfo.class);

                            if(mUserInfo.getEmail().equals(_userEmail.getText().toString()))
                            {
                                //Toast.makeText(AddAdminActivity.this,"User Exits",Toast.LENGTH_LONG).show();
                                newAdminId = mUserInfo.getId();
                                isUserExists = true;
                                break;
                            }

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                //If user not exits, show error
                if(isUserExists) //if true
                {
                    AdminUser adminUser = new AdminUser(newAdminId,"admin");
                    addAdminReference.child(newAdminId).setValue(adminUser).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                            {
                                Intent i = new Intent(AddAdminActivity.this,AdminDashboard.class);
                                finish();
                                startActivity(i);
                            }
                            else
                            {
                                isUserExists = false;
                                Toast.makeText(AddAdminActivity.this,"Something went wrong...",Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
                else // if user does not exists
                {
                    isUserExists = false;
                    Toast.makeText(AddAdminActivity.this,"Something went wrong...",Toast.LENGTH_LONG).show();
                }


            }
        });


    }
}