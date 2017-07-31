package com.example.lamaalesmail.loginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bLogout ;
    EditText etFullName ,etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etFullName = (EditText)findViewById(R.id.etFullName);

        etEmail = (EditText)findViewById(R.id.etEmail);
        bLogout = (Button)findViewById(R.id.bLogout );
        bLogout.setOnClickListener(this);



    }





    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bLogout :



                startActivity(new Intent(this,Login.class));

                break ;
        }

    }
}