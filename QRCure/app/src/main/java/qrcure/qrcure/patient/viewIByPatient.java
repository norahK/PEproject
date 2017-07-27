package qrcure.qrcure.patient;

import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.*;

import qrcure.qrcure.R;

public class viewIByPatient extends AppCompatActivity {
    private StorageReference mStorageRef;
    private TextView name;
private   FirebaseDatabase database_data ;
    private DatabaseReference dataref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_i_by_patient);
        TextView test=(TextView)findViewById(R.id.topic_title);
        Intent previos=getIntent();
        String inp=previos.getStringExtra("input");
        test.setText(inp);
        //database
        mStorageRef = FirebaseStorage.getInstance().getReference();
        name=(TextView)findViewById(R.id.nameOfwriter);
        FirebaseApp.initializeApp(this);
         database_data= FirebaseDatabase.getInstance();
        dataref =database_data.getReference("message");
       dataref.setValue("Hello, World!");


    }
    public void share(View v){

        Intent sendIntent = new Intent (Intent.ACTION_SENDTO);
//implicit :actions,dataURL,category.component,extras
        //explicit:data URL,context,componant(class/activity )

    }
    public void addcomments(){



    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {


    }

    public void add (View v){



    }

}
