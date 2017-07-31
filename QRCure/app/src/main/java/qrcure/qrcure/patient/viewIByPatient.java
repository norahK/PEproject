package qrcure.qrcure.patient;

import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.*;

import qrcure.qrcure.R;
import qrcure.qrcure.Topic;
import qrcure.qrcure.User;

/*
this page need 3 thing as extras from previous page
1/Article or Instruction as char
2/the ID(object) for any of them
3/the User logged in object
*/
public class viewIByPatient extends AppCompatActivity {
    //get lay out elements
    private ImageButton writer_img=(ImageButton)findViewById(R.id.avtar);
    private TextView nameOfwriter=(TextView)findViewById(R.id.nameOfwriter);
    private TextView title= (TextView)findViewById(R.id.topic_title);
    private ImageButton like_Butten=(ImageButton)findViewById(R.id.like);
    private LinearLayout content =(LinearLayout)findViewById(R.id.content);
    private LinearLayout related_topics =(LinearLayout)findViewById(R.id.related_top_list);
    private LinearLayout comments =(LinearLayout)findViewById(R.id.comments);

    //database
    private StorageReference mStorageRef;
    private FirebaseDatabase database_data ;
    private DatabaseReference dataref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_i_by_patient);

        //get passed info
        Intent previous=getIntent();
        char AorI=previous.getCharExtra("AorI",'n');
        Topic topic =previous.getParcelableExtra("topic");
        User logedin =previous.getParcelableExtra("logedin");

        //database
        mStorageRef = FirebaseStorage.getInstance().getReference();
        FirebaseApp.initializeApp(this);
         database_data= FirebaseDatabase.getInstance();
        dataref =database_data.getReference();
       dataref.setValue("test");


    }

    //when user click on avtar photo or name
    public void gotoDprofilepage(View v){
        //new intent with user(writer  object
        //if no -> toast apper with no profile to this writer



    }

    //when like clicked
    public void like(View v){



    }

    //share button menu!
    public void share(View v){

        Intent sendIntent = new Intent (Intent.ACTION_SENDTO);
//implicit :actions,dataURL,category.component,extras
        //explicit:data URL,context,componant(class/activity )

    }

    //when click add comment
    public void addcomments(){



    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {


    }


}
