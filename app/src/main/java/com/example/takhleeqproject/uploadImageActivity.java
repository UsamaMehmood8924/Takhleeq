package com.example.takhleeqproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public class uploadImageActivity extends AppCompatActivity {

    //UI Fields Connection Variable
    RadioGroup _chooseSociety;
    RadioButton _selectedSociety;
    Button _selectImageButton;
    Button _uploadImageButton;
    EditText _imageDescription;
    ImageView _showImageHere;

    // Uri indicates, where the image will be picked from
    private Uri filePath;

    // request code
    private final int PICK_IMAGE_REQUEST = 22;

    // instance for firebase storage and StorageReference
    FirebaseStorage storage;
    StorageReference storageReference;


    FirebaseAuth mAuth;
    FirebaseUser user;
    String uid;
    FirebaseDatabase database;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_image);


        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Images");
        mAuth = FirebaseAuth.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        uid = user.getUid();


        // get the Firebase  storage reference
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        _chooseSociety = findViewById(R.id.chooseSociety);

        _selectImageButton = findViewById(R.id.selectImageBtn);
        _uploadImageButton = findViewById(R.id.uploadImageSociety);
        _imageDescription = findViewById(R.id.imgDesription);
        _showImageHere = findViewById(R.id.showImageHere);

        _selectImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage();
            }
        });


        _uploadImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadImage();
            }
        });

    }

    private void selectImage()
    {
        // Defining Implicit Intent to mobile gallery
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(
                Intent.createChooser(
                        intent,
                        "Select Image from here..."),
                PICK_IMAGE_REQUEST);
    }

    // Override onActivityResult method
    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data)
    {

        super.onActivityResult(requestCode,
                resultCode,
                data);

        // checking request code and result code
        // if request code is PICK_IMAGE_REQUEST and
        // resultCode is RESULT_OK
        // then set image in the image view
        if (requestCode == PICK_IMAGE_REQUEST
                && resultCode == RESULT_OK
                && data != null
                && data.getData() != null) {

            // Get the Uri of data
            filePath = data.getData();
            try {

                // Setting image on image view using Bitmap
                Bitmap bitmap = MediaStore
                        .Images
                        .Media
                        .getBitmap(
                                getContentResolver(),
                                filePath);
                _showImageHere.setImageBitmap(bitmap);
            }

            catch (IOException e) {
                // Log the exception
                e.printStackTrace();
            }
        }
    }

    private void uploadImage()
    {
        String description = _imageDescription.getText().toString();
        if(description.isEmpty())
        {
            description = "";
        }

        int selectedId = _chooseSociety.getCheckedRadioButtonId();
        _selectedSociety = findViewById(selectedId);

        if(selectedId==-1)
        {
            Toast.makeText(uploadImageActivity.this,"Please Select a Society",Toast.LENGTH_LONG).show();
            return;
        }
        else
        {
            //Toast.makeText(uploadImageActivity.this,_selectedSociety.getText(),Toast.LENGTH_LONG).show();
        }


        if (filePath != null) {

            // Code for showing progressDialog while uploading
            final ProgressDialog progressDialog
                    = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            // Defining the child of storageReference
            StorageReference ref
                    = storageReference
                    .child(
                            "images/"
                                    + UUID.randomUUID().toString());

            // adding listeners on upload
            // or failure of image
            ref.putFile(filePath)
                    .addOnSuccessListener(
                            new OnSuccessListener<UploadTask.TaskSnapshot>() {

                                @Override
                                public void onSuccess(
                                        UploadTask.TaskSnapshot taskSnapshot)
                                {

                                    // Image uploaded successfully
                                    // Dismiss dialog
                                    progressDialog.dismiss();
                                    Toast
                                            .makeText(uploadImageActivity.this,
                                                    "Image Uploaded!!",
                                                    Toast.LENGTH_SHORT)
                                            .show();
                                }
                            })

                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e)
                        {

                            // Error, Image not uploaded
                            progressDialog.dismiss();
                            Toast
                                    .makeText(uploadImageActivity.this,
                                            "Failed " + e.getMessage(),
                                            Toast.LENGTH_SHORT)
                                    .show();
                            //return;
                        }
                    })
                    .addOnProgressListener(
                            new OnProgressListener<UploadTask.TaskSnapshot>() {

                                // Progress Listener for loading
                                // percentage on the dialog box
                                @Override
                                public void onProgress(
                                        UploadTask.TaskSnapshot taskSnapshot)
                                {
                                    double progress
                                            = (100.0
                                            * taskSnapshot.getBytesTransferred()
                                            / taskSnapshot.getTotalByteCount());
                                    progressDialog.setMessage(
                                            "Uploading "
                                                    + (int)progress + "%");
                                }
                            });



            //Getting current date.
            String date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());

            //Here Add Images to respective society in the firebase realtime database
            SocitiesImages socitiesImages = new SocitiesImages(filePath.toString(),uid,_selectedSociety.getText().toString(),description,date);

            Log.d("12456",uid);
            Log.d("12456",_selectedSociety.getText().toString());
            Log.d("12456",description);
            Log.d("12456",date);


            String societyName = _selectedSociety.getText().toString();
            reference.child(societyName).push().setValue(socitiesImages).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                    if(task.isSuccessful())
                    {
                        //Toast.makeText(uploadImageActivity.this,"",Toast.LENGTH_LONG).show();
                          int imgId = getResources().getIdentifier("com.example.takhleeqproject:drawable/" + "ic_uplaod_image", null, null);
                        _showImageHere.setImageResource(imgId);
                        _imageDescription.setText("");
                        _chooseSociety.clearCheck();
                    }
                    else
                    {
                        Toast.makeText(uploadImageActivity.this,"Image Uploading Failed",Toast.LENGTH_LONG).show();
                    }


                }
            });

        }
        else
        {
            Toast.makeText(uploadImageActivity.this,"Please Select an Image",Toast.LENGTH_LONG).show();
        }

    }


}