package qrcure.qrcure.doctor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TextView;

import qrcure.qrcure.BottomNavigationViewHelper;
import qrcure.qrcure.MainActivity;
import qrcure.qrcure.R;
import qrcure.qrcure.R;


import com.*;

public class Main_doctor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_doctor);


        //to remove animation from bar
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);


        //actions on bar
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    //number of case =number of tabs
                    case R.id.home:
                        Intent Home = new Intent(Main_doctor.this, dhome.class);
                        startActivity(Home);
                        break;

                    case R.id.add:
                      /*  if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
                            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 200);
                        }*/
                        Intent add = new Intent(Main_doctor.this, dadd.class);//reference to the java doc
                        startActivity(add);


                        break;

                    case R.id.dnotification:
                        Intent dnotification_page = new Intent(Main_doctor.this, dnotification.class);
                        startActivity(dnotification_page);
                        break;
                    case R.id.profile:
                        Intent dprofile_Page = new Intent(Main_doctor.this, dprofile.class);
                        startActivity(dprofile_Page);
                        break;

                }


                return false;

            }
        });
    }
}
