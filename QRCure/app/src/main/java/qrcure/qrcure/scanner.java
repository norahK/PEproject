package qrcure.qrcure;

import android.*;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;
import com.google.zxing.DecodeHintType;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Timer;

import qrcure.qrcure.patient.*;

public class scanner extends AppCompatActivity {
    //camera siting
    SurfaceView SV;
    BarcodeDetector BD;
    CameraSource camera;


    private TextView hint;
    Topic value;

   final int RCPID = 1001;
    int hight=640;
    int width=480;
    //database
    private StorageReference mStorageRef;
    private FirebaseDatabase database_data ;
    private DatabaseReference dataref;

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case RCPID:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                      return;
                    }
                    try {
                        camera.start(SV.getHolder());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            break;
    }
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scanner);
        //set camera size
      LinearLayout l = (LinearLayout) findViewById(R.id.root);
       int ph= l.getMeasuredHeight();
        //int ph =l.getLayoutParams().height;
        //SV.getLayoutParams().height = ph-100;
        //SV.requestLayout();
//put the ref on root"instruction" of database
        dataref = FirebaseDatabase.getInstance().getReference().child("Instruction");
/*test
        tonext = (Button) findViewById(R.id.button2);
        tonext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                in = new Intent(scanner.this, retrive_data_test.class);//viewIByPatient.class);
                //pass info to othe page
                in.putExtra("input", "test");//name+value to spasifay
                startActivity(in);
            }
        });*/


        SV = (SurfaceView) findViewById(R.id.cameraView);
        BD = new BarcodeDetector.Builder(this).setBarcodeFormats(Barcode.DATA_MATRIX | Barcode.QR_CODE).build();
        hint = (TextView) findViewById(R.id.hint);
        if (!BD.isOperational()) {
            hint.setText("Could not set up the detector!");
        }
        camera = new CameraSource.Builder(this, BD).setRequestedPreviewSize(500, 500).build();

        //add event
        SV.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
//requist prmtion
                    ActivityCompat.requestPermissions(scanner.this,new String[]{android.Manifest.permission.CAMERA},RCPID);
                    return;
                }
                try {
                    camera.start(SV.getHolder());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

                               @Override
                               public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

                               }

                               @Override
                               public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                               camera.stop();
                               }
                           }

);


BD.setProcessor(new Detector.Processor<Barcode>() {
    @Override
    public void release() {

    }

    @Override
    public void receiveDetections(Detector.Detections<Barcode> detections) {
       final SparseArray<Barcode> QRcodes=detections.getDetectedItems();
        char[] buttonsArray;
        String result;
        ScannerResult alert = new ScannerResult();
        Bundle info=new Bundle();

        if(QRcodes.size()!=0)
        {

            Vibrator vibrator=(Vibrator)getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(1000);
            Barcode QRresult =QRcodes.valueAt(0);
            dataref.child(QRresult.displayValue);
            dataref.addValueEventListener(new ValueEventListener() {
                                              @Override
                                              public void onDataChange(DataSnapshot dataSnapshot) {
                                                value = (Topic)dataSnapshot.getValue();//.toString();

                                              }

                                              @Override
                                              public void onCancelled(DatabaseError error) {

                                              }
                                          });
            result="go to";
            buttonsArray=new char[2];
            buttonsArray[0]='a';
            buttonsArray[0]='n';
            FragmentManager fm = getFragmentManager();

            info.putString("message",result);
            info.putCharArray("buttons",buttonsArray);
            alert.setArguments(info);
            alert.show(fm, "Alert_Dialog");

            // result.setText(QRcodes.valueAt(0).displayValue);

           // Intent gotoinstruction = new Intent(scanner.this, viewIByPatient.class);
          // startActivity(gotoinstruction);


        }
        else {

        }
    }
});
/* full screen camera if nedded
       scannercamera = new IntentIntegrator(this);
        scannercamera.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        scannercamera.setPrompt("scan");
        scannercamera.setCameraId(0);
        scannercamera.setBeepEnabled(false);
        scannercamera.setBarcodeImageEnabled(false);
        scannercamera.initiateScan();*/



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
                      /*  if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
                            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 200);
                        }*/
                        Intent scanner = new Intent(scanner.this, scanner.class);//reference to the java doc
                        startActivity(scanner);


                        break;

                    case R.id.profile:
                        Intent visitor = new Intent(scanner.this, visitor_search.class);
                        startActivity(visitor);
                        break;


                }


                return false;

            }
        });
    }

    /*handeling the result from scanning for full camera screen
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null){
            if(result.getContents()==null){
                Toast.makeText(this, "You cancelled the scanning", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(this, result.getContents(),Toast.LENGTH_LONG).show();
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }

    }*/
    @Override
    protected void onPause() {
        super.onPause();
       // scannercamera.stop
    }

       // Toast.makeText(this, "yees",Toast.LENGTH_LONG).show();
}
