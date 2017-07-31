package com.example.lamaalesmail.loginregister;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

public class Login extends AppCompatActivity implements View.OnClickListener {
    Button bLogin ;
    EditText etEmail , etPassword ;
    TextView tvRegisterLink,tvForgetPassword ;
    private FirebaseAuth firebaseAuth ;
    private SignInButton mGoogleBtn ;

    GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mGoogleBtn = (SignInButton)findViewById(R.id.googleBtn);


        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        tvRegisterLink = (TextView) findViewById(R.id.tvRegisterLink);
        tvForgetPassword = (TextView) findViewById(R.id.tvForgetPassword);
        bLogin = (Button)findViewById(R.id.bLogin);
        firebaseAuth = FirebaseAuth.getInstance();
        //bLogin.setOnClickListener(this);
        tvRegisterLink.setOnClickListener(this);
        tvForgetPassword.setOnClickListener(this);


    }



    public void btnUserLogin_Click(View view){
        final ProgressDialog progressDialog = ProgressDialog.show(Login.this,"Please wait ..","proccessing ..",true);

        (firebaseAuth.signInWithEmailAndPassword(etEmail.getText().toString(),etPassword.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();

                if (task.isSuccessful()){

                    Toast.makeText(Login.this,"Login successful :)",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Login.this,MainActivity.class));

                }else {
                    Log.e("ERROR",task.getException().toString());
                    Toast.makeText(Login.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    /*private void userLogin(){
        String email=etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
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
    }*/

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvForgetPassword :


                startActivity(new Intent(this,ResetPasswordActivity.class));


                break;

            case R.id.tvRegisterLink:

                startActivity(new Intent(this,Register.class));
                break ;
        }

    }

}
