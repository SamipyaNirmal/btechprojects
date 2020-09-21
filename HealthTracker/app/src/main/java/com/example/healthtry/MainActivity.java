package com.example.healthtry;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    private Timer t;
    TimerTask task;
    static  TextView mt;
    static TextView cal,dis;
    private SensorManager mSensorManager;
    private Sensor mStepDetectorSensor;
    private Sensor mStepCounterSensor;
    private SensorEvent e;
    String gen="male";
    int weightkg=55;
    //int heightcm=155;
    float dist;
    File myFile;
    int val=0;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_details:
                    startActivity(new Intent(getApplicationContext(),Details.class));
                    return true;
                case R.id.navigation_foodintake:
                    startActivity(new Intent(getApplicationContext(),Food.class));
                    return true;
                case R.id.navigation_bmi:
                    startActivity(new Intent(getApplicationContext(),Bmi.class));
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      /* Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        { String weight = bundle.getString("weight");
        String gender=bundle.getString("gen");
        gen=gender;
        weightkg=Integer.parseInt(weight);}*/

        mt=(TextView)findViewById(R.id.mt);
        cal=(TextView)findViewById(R.id.cal);
        dis=(TextView)findViewById(R.id.dis);
        startTimer();
        mSensorManager = (SensorManager)
                getSystemService(Context.SENSOR_SERVICE);
        mStepCounterSensor = mSensorManager
                .getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        verifyStoragePermissions(MainActivity.this);

        //Toast.makeText(getApplicationContext(), "create called",Toast.LENGTH_LONG).show();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    public  void verifyStoragePermissions(Activity thisactivity) {

        //  Toast.makeText(getApplicationContext(), "inside verify permissions",Toast.LENGTH_LONG).show();
        int permissionCheck = ContextCompat.checkSelfPermission(thisactivity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    thisactivity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }
    public void startTimer(){
        t = new Timer();

        task = new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                        try {
                            File myFile = new File("/sdcard/db.txt");
                            try {
                                myFile.createNewFile();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                            FileOutputStream fOut = new FileOutputStream(myFile);
                            OutputStreamWriter myOutWriter =
                                    new OutputStreamWriter(fOut);
                            myOutWriter.append(mt.getText());
                            // mt.setText(""+0);
                            myOutWriter.close();
                            fOut.close();
                            Toast.makeText(getApplicationContext(), "Resetting", Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {

                        }
                    }
                });
            }
        };
        t.scheduleAtFixedRate(task, 0, 86400000);
    }

    public void onSensorChanged(SensorEvent event) {

        Sensor sensor = event.sensor;
        float[] values = event.values;
        int value = -1;
        String data;
        FileInputStream fin;
        try {
            myFile = new File("/sdcard/mysdfile.txt");

            fin = new FileInputStream(myFile);

            BufferedReader myReader = new BufferedReader(new InputStreamReader(fin));
            if((data=myReader.readLine())!=null)
                val= Integer.parseInt(data);
            myReader.close();

        }
        catch (Exception e1)
        {
            e1.printStackTrace();
        }
        if (values.length > 0) {

            value = (int) values[0];
            value = value + val;
            getCal(value);
            getDist(value);

        }

        if (sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
            mt.setText("" + value);
        }





    }//onsensorchanged

    public void getDist(int value)
    {

        if(gen.equalsIgnoreCase("male")) {
            dist = ( value * 78)/100000;
            dis.setText(""+dist+" km");

        }
        else if(gen.equalsIgnoreCase("female"))
        {
            dist = (value * 75)/100000;
            dis.setText(""+dist+" km");
        }


    }
    public void getCal(int value)
    {
        float calo,calpermile,calperstep;
        float weightlb=0.45f*weightkg;
        float distmile=1.6f*dist;

            calpermile = 0.57f * weightlb;
            calperstep = calpermile / 1375;
            calo = calperstep * value;
            cal.setText("" + calo + " cal");

    }



    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    protected void onResume() {

        super.onResume();
        mSensorManager.registerListener(this, mStepCounterSensor, SensorManager.SENSOR_DELAY_FASTEST);


    }
    protected void onPause()
    {
        super.onPause();

    }

    protected void onStop() {
        super.onStop();
        mSensorManager.unregisterListener(this, mStepCounterSensor);

        //Toast.makeText(getApplicationContext(),"stop", Toast.LENGTH_LONG).show();

    }
    protected void onDestroy()
    {
        super.onDestroy();

        //Toast.makeText(getApplicationContext(),"destroy", Toast.LENGTH_LONG).show();
    }
}


