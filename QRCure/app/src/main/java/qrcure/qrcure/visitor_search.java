package qrcure.qrcure;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.firebase.database.DatabaseReference;

import java.util.Date;

public class visitor_search extends AppCompatActivity {
    private DatabaseReference dataref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visitor_search);


        String[]body_test=new String[2];
        body_test[0]="subtitle1";
        body_test[1]="subtitle2";

        Topic test=new Topic("this is title",body_test,new User(),body_test,0,0,new Date());

        dataref.child("Instruction").child("1").setValue(test);//we can add oncompleatlistiner for make sure it do it

        //to remove animation from bar
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);


        //actions on bar
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    //number of case =number of tabs
                    case R.id.scanner:

                        Intent scanner = new Intent(visitor_search.this, scanner.class);//reference to the java doc
                        startActivity(scanner);


                        break;

                    case R.id.profile:
                        Intent visitor = new Intent(visitor_search.this, visitor_search.class);
                        startActivity(visitor);
                        break;


                }


                return false;

            }
        });
    }
}
