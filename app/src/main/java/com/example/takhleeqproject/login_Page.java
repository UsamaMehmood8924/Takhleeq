package com.example.takhleeqproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class login_Page extends AppCompatActivity {

    EditText _username;
    EditText _password;
    Button _login;

    private FirebaseAuth mAuth;

    FirebaseUser user;
    String uid;
    FirebaseDatabase database;
    DatabaseReference reference;

    boolean isUserExists = false;
    int abc = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__page);

        _username = findViewById(R.id.username);
        _password = findViewById(R.id.password);
        _login = findViewById(R.id.login);

        mAuth = FirebaseAuth.getInstance();

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Admin");

        _login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

    }


    private void attemptLogin()
    {
        String email = _username.getText().toString();
        String password = _password.getText().toString();

        if (email.isEmpty())
            if (email.equals("") || password.equals("")) return;
        Toast.makeText(this, "Login in progress...", Toast.LENGTH_SHORT).show();

        //Use FirebaseAuth to sign in with email & password
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {


                if (!task.isSuccessful()) {
                                        showErrorDialog("There was a problem signing in");
                }
                else {

                    //Here User is authenticated. Now Check Whether this user is also a admin or not. If admin, then show LoginAs Screen, otherwise manually logged Home activity.
                    user = FirebaseAuth.getInstance().getCurrentUser();
                    uid = user.getUid();

                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            for(DataSnapshot snapshot1 : snapshot.getChildren() )
                            {


                                AdminUser adminUser = snapshot1.getValue(AdminUser.class);

                                if(adminUser.getId().equals(uid))
                                {
                                    Log.d("1245","User is a admin");
                                    //Toast.makeText(AddAdminActivity.this,"User Exits",Toast.LENGTH_LONG).show();
                                    Intent i = new Intent(login_Page.this, LoginAsActivity.class);
                                    finish();
                                    startActivity(i);
                                    Log.d("1479","I'm in");
                                    isUserExists = true;
                                    abc = 5;
                                    break;
                                }

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });


                    Intent intent;
                    if(isUserExists || abc == 5 )// User is also an admin, Intent To login as screen
                    {
                        Log.d("1479","I'm in");
                        intent = new Intent(login_Page.this, LoginAsActivity.class);
                    }
                    else//Intent to Home Activity
                    {
                        intent = new Intent(login_Page.this, Home.class);
                    }
                    finish();
                    startActivity(intent);
                }

            }
        });
    }

    //Show error on screen with an alert dialog
    private void showErrorDialog(String message) {
        new AlertDialog.Builder(this)
                .setTitle("Oops")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }


}