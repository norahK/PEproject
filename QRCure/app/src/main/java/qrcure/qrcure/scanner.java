package qrcure.qrcure;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.zxing.DecodeHintType;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.Hashtable;
import java.util.Timer;

import qrcure.qrcure.patient.*;

public class scanner extends AppCompatActivity {
    SurfaceView SV;
    BarcodeDetector BD;
    CameraSource camera;
    int RCPID = 1001;
    Button tonext;
    private IntentIntegrator scannercamera;
    //private SurfaceHolderCallback surfaceHolderCallback;
    Intent in;
    //timer
 //Timer cameraTimer;
    //private CameraTimerTask cameraTimerTask;
    //Set up the level of accuracy needed from the Zxing classes
//in order to decode the QR code
    /*private static Hashtable hints;
    static {
        hints = new Hashtable(1);
        hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
    }*/
    TextView result ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scanner);
//test
tonext=(Button)findViewById(R.id.button2);
        tonext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               in=new Intent(scanner.this,retrive_data_test.class);//viewIByPatient.class);
                //pass info to othe page
                in.putExtra("input","test");//name+value to spasifay
                startActivity(in);
            }
        });


        SV = (SurfaceView) findViewById(R.id.cameraView);
      //  cameraTimer = new Timer();
        //cameraTimer.schedule(0b,0, 80);
        BD = new BarcodeDetector.Builder(this).setBarcodeFormats(Barcode.DATA_MATRIX |Barcode.QR_CODE).build();

        result = (TextView) findViewById(R.id.result);
        if (!BD.isOperational()) {
            result.setText("Could not set up the detector!");
        }
//Frame frame = new Frame.Builder().setBitmap(myBitmap).build();
//        SparseArray<Barcode> barcodes = BD.detect(frame);
        ///Barcode thisCode = barcodes.valueAt(0);
       // txtView.setText(thisCode.rawValue);
        camera = new CameraSource.Builder(this, BD).setRequestedPreviewSize(640, 480).build();

BD.setProcessor(new Detector.Processor<Barcode>() {
    @Override
    public void release() {

    }

    @Override
    public void receiveDetections(Detector.Detections<Barcode> detections) {
        SparseArray<Barcode> QRcodes=detections.getDetectedItems();
        if(QRcodes.size()!=0)
        {
           // Vibrator vibrator=(Vibrator)getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
            //vibrator.vibrate(1000);

            Intent gotoinstruction = new Intent(scanner.this, viewIByPatient.class);
           startActivity(gotoinstruction);



        }
    }
});

       scannercamera = new IntentIntegrator(this);
        scannercamera.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        scannercamera.setPrompt("scan");
        scannercamera.setCameraId(0);
        scannercamera.setBeepEnabled(false);
        scannercamera.setBarcodeImageEnabled(false);
        scannercamera.initiateScan();



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
    //handeling the result from scanning
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

    }
    @Override
    protected void onPause() {
        super.onPause();
       // scannercamera.stop
    }
    public void goToInstruction(){
        //result.("yeees");
        Toast.makeText(this, "yees",Toast.LENGTH_LONG).show();

    }
}
