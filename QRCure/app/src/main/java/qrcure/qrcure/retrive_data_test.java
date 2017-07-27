package qrcure.qrcure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class retrive_data_test extends AppCompatActivity {
TextView screen;
    EditText form;
    Button b;
    private StorageReference mStorageRef;
    private   FirebaseDatabase database_data ;
    private DatabaseReference dataref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrive_data_test);
        screen=(TextView)findViewById(R.id.viewer);
        b=(Button)findViewById(R.id.bottontest) ;
        form=(EditText)findViewById(R.id.form);

        //mStorageRef = FirebaseStorage.getInstance().getReference();
        FirebaseApp.initializeApp(this);
        database_data= FirebaseDatabase.getInstance();
        dataref =database_data.getReference("message");
        dataref.setValue("Hello, World!");


    }
    public void updatedata(View b){

screen.setText("hi");

    }
}
