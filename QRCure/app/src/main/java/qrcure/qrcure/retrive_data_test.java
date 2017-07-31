package qrcure.qrcure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class retrive_data_test extends AppCompatActivity {
TextView screen;
    EditText form;
    EditText otherform;
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
        otherform=(EditText)findViewById(R.id.email);


        dataref = FirebaseDatabase.getInstance().getReference();

/*        FirebaseApp.initializeApp(this);
        database_data= FirebaseDatabase.getInstance();
        dataref =database_data.getReference("test");
        dataref.setValue("test");*/


        /* Read from the database
        dataref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("done", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("fail", "Failed to read value.", error.toException());
            }
        });*/

    }
    public void updatedata(View b){
        writeNewUser(form.getText().toString(),otherform.getText().toString());


    }
    private void writeNewUser( String name, String email) {
        //write
        User user = new User(name, email);
        dataref.child("users").push().setValue(user);//we can add oncompleatlistiner for make sure it do it

        //read
        //dataref=dataref.child("message");
        dataref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue().toString();
                screen.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
       // screen.setText("done");
//push()give random ID

    }
}
