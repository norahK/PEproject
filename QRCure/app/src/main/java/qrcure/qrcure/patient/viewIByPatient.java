package qrcure.qrcure.patient;

import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import qrcure.qrcure.R;

public class viewIByPatient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_i_by_patient);
        TextView test=(TextView)findViewById(R.id.topic_title);
        Intent previos=getIntent();
        String inp=previos.getStringExtra("input");
        test.setText(inp);
    }
    public void share(View v){



    }
    public void addcomments(){



    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {


    }

    public void add (View v){



    }

}
