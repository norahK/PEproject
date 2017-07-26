package qrcure.qrcure.patient;

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
//import qrcure.qrcure.camera;
import qrcure.qrcure.scanner;
import qrcure.qrcure.visitor_search;

public class Main_Patient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_main);


        //to remove animation from bar
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);


        //actions on bar
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    //number of case =number of tabs
                    case R.id.Phome:
                        Intent Home = new Intent(Main_Patient.this, home.class);
                        startActivity(Home);
                        break;

                    case R.id.Pscanner:
                      /*  if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
                            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 200);
                        }*/
                        Intent scanner = new Intent(Main_Patient.this, qrcure.qrcure.scanner.class);//reference to the java doc
                        startActivity(scanner);


                        break;


                    case R.id.Pnotification:
                        Intent Pnotification_page = new Intent(Main_Patient.this, notification.class);
                        startActivity(Pnotification_page);
                        break;
                    case R.id.Pprofile:
                        Intent Pprofile_Page = new Intent(Main_Patient.this, profile.class);
                        startActivity(Pprofile_Page);
                        break;

                }


                return false;

            }
        });
    }
    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
    }

}

