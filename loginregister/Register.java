package com.example.lamaalesmail.loginregister;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.provider.DocumentFile;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.lamaalesmail.loginregister.m_FireBase.FirebaseHelper;
import com.example.lamaalesmail.loginregister.m_Model.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity implements View.OnClickListener {
    //DatabaseReference db ;
    //FirebaseHelper helper ;
    Button bRegister;
    EditText etFristName, etLastName, etUsername, etPassword, etEmail;

    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        etFristName = (EditText) findViewById(R.id.etFristName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etEmail = (EditText) findViewById(R.id.etEmail);

        bRegister = (Button) findViewById(R.id.bRegister);
        //db = FirebaseDatabase.getInstance().getReference();
        //helper= new FirebaseHelper(db);
        bRegister.setOnClickListener(this);




    }

    public void rbclick(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.rButtonD:
                if (checked) {
                } else {
                    // will choose patient
                }
                break;

            case R.id.rButtonP:
                break;

        }
    }

    @Override
    public void onClick(View v) {



        registerUser();
        startActivity(new Intent(this,MainActivity.class));




    }



    private void registerUser(){

        //getting email and password from edit texts
        String Fname = etFristName.getText().toString().trim();
        String Lname = etLastName.getText().toString().trim();
        String username = etUsername.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        //checking if email and passwords are empty
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }

        //if the email and password are not empty
        //displaying a progress dialog

        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();

        //creating a new user
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult>task) {
                        //checking if success
                        if(task.isSuccessful()){
                            //display some message here
                            Toast.makeText(Register.this,"Successfully registered",Toast.LENGTH_LONG).show();
                        }else{
                            //display some message here
                            Toast.makeText(Register.this,"Registration Error",Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                });

    }










   private void Registration() {

        /*String Fname = etFristName.getText().toString();
        String Lname = etLastName.getText().toString();
        String username = etUsername.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();




            Users user = new Users();
            user.setFname(Fname);
            user.setLname(Lname);
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);

       if (!TextUtils.isEmpty(Fname) && !TextUtils.isEmpty(Lname) && !TextUtils.isEmpty(username) && !TextUtils.isEmpty(email) && !TextUtils .isEmpty(password)) {
        //mDatabaseReference.child("Users").push().setValue(user);
         if (helper.seve(user)){
             etFristName.setText("");
             etLastName.setText("");
             etUsername.setText("");
             etEmail.setText("");
             etPassword.setText("");
         }
            //Doctor d = new Doctor(Fname,Lname,username,email,password);

            Toast.makeText(this,"User added ..",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this,"You should enter all information ..",Toast.LENGTH_LONG).show();
        }*/
    }
}
