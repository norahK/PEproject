package qrcure.qrcure;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.TabHost;
import android.widget.TextView;
import android.util.*;

import static android.R.id.tabhost;

public class Main_Patient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_main);


          String in="my message";

        final TabHost tabHost =(TabHost)findViewById(R.id.tabhost);
        tabHost.setup();

        //home
        TabHost.TabSpec Dayspec = tabHost.newTabSpec("home");
        Dayspec.setIndicator("home");
        Intent intentDay = new Intent(this, home.class);
        Dayspec.setContent(intentDay);

        TabHost.TabSpec twoSpec = tabHost.newTabSpec("camera");
        twoSpec.setIndicator("camera");
        Intent i = new Intent(this, camera.class);
        twoSpec.setContent(i);
        tabHost.addTab(Dayspec);
        tabHost.addTab(twoSpec);

        for (int r = 0; r < tabHost.getTabWidget().getChildCount(); r++) {

            System.out.println("color changed");
            TextView tv = (TextView) tabHost.getTabWidget().getChildAt(r)
                    .findViewById(android.R.id.title);
            tv.setTextColor(Color.WHITE);
            // tv.setBackgroundResource(R.drawable.tab_selected);
        }

        tabHost.getTabWidget().getChildAt(0)
                .setBackgroundResource(R.mipmap.ic_launcher);
        tabHost.getTabWidget().getChildAt(1)
                .setBackgroundResource(R.mipmap.ic_launcher_round);
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {

            public void onTabChanged(String tabId) {
                if (TextUtils.equals(tabId, "Tab1")) {
                    tabHost.getTabWidget().getChildAt(0)
                            .setBackgroundResource(R.mipmap.ic_launcher);
                    tabHost.getTabWidget().getChildAt(1)
                            .setBackgroundResource(R.mipmap.ic_launcher_round);

                } else if (TextUtils.equals(tabId, "Tab2")) {
                    tabHost.getTabWidget().getChildAt(0)
                            .setBackgroundResource(R.mipmap.ic_launcher_round);
                    tabHost.getTabWidget().getChildAt(1)
                            .setBackgroundResource(R.mipmap.ic_launcher);
                }

            }
        });

    }
    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
    }

}

