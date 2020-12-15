package com.example.takhleeqproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    EditText name, phone, email, password, cpassword;
    Button btnSignUp;

    private Boolean check = true;
    private Boolean check1 = true;

    // Firebase instance variables
    private FirebaseAuth mAuth;

    FirebaseUser user;
    String uid;
    FirebaseDatabase database;
    DatabaseReference reference;

    // Temporary variables to store the text values of email and password fields.
    String u_email,u_password,u_cpassword, u_name,u_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);


        //Get hold of an instance of FirebaseAuth
        mAuth = FirebaseAuth.getInstance();

        btnSignUp = findViewById(R.id.SignUpButton);

        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        cpassword = findViewById(R.id.confirm_password);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("UserProfiles");

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptRegistration();
            }
        });
    }

    private void attemptRegistration()
    {
        email.setError(null);
        password.setError(null);
        cpassword.setError(null);

        u_email = email.getText().toString();
        u_password = password.getText().toString();
        u_cpassword = cpassword.getText().toString();
        u_name = name.getText().toString();
        u_phone = phone.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(u_password) && !isPasswordValid(u_password)) {
            password.setError("Password too short or does not match");
            focusView = password;
            cancel = true;
        }

        if(TextUtils.isEmpty(u_name))
        {
            name.setError("This Field is required");
            focusView = name;
            cancel = true;
        }
        if(TextUtils.isEmpty(u_phone))
        {
            phone.setError("This Field is required");
            focusView = phone;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(u_email)) {
            email.setError("This Field is required");
            focusView = email;
            cancel = true;
        }
        else if (!isEmailValid(u_email)) {
            email.setError("This email address is invalid");
            focusView = email;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {

            // Call create FirebaseUser()
            createFirebaseUser();
        }
    }

    private boolean isEmailValid(String email) {
        // You can add more checking logic here.
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Add own logic to check for a valid password
        String confirmPassword = cpassword.getText().toString();
        return confirmPassword.equals(password) && password.length() > 4;
    }


    private void createFirebaseUser() {

        String _email = email.getText().toString();
        String _password = password.getText().toString();

        mAuth.createUserWithEmailAndPassword(_email, _password).addOnCompleteListener(this,
                new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            Log.d("1122", "user creation failed");
                            showErrorDialog("Registration attempt failed");
                        } else {



                            //Add admin data in UserProfiles node
                            user = FirebaseAuth.getInstance().getCurrentUser();
                            uid = user.getUid();

                            UserCredentials.setId(uid);
                            UserCredentials.setEmail(u_email);
                            UserCredentials.setName(u_name);
                            UserCredentials.setPhone(u_phone);

                            UserInfo userInfo = new UserInfo(u_email,u_phone,u_name,uid);

                            reference.child(uid).setValue(userInfo).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful())
                                    {
                                        Intent intent = new Intent(SignUp.this, Home.class);
                                        finish();
                                        startActivity(intent);
                                    }
                                    else
                                    {
                                        Toast.makeText(SignUp.this, "Something Went Wrong", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });

                            //if User is admin -> intent to admin dashboard;

                            //else User is simple user, navigate to MainActivity;


                        }
                    }
                });
    }

    //Create an alert dialog to show in case registration failed
    private void showErrorDialog(String message){

        new AlertDialog.Builder(this)
                .setTitle("Oops")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}