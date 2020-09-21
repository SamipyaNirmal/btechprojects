package com.example.healthtry;

/**
 * Created by NANDITA on 30/10/17.
 */

import android.content.BroadcastReceiver;
        import android.content.Context;
        import android.content.Intent;
        import android.widget.Toast;

        import java.io.BufferedReader;
        import java.io.File;
        import java.io.FileInputStream;
        import java.io.InputStreamReader;

/**
 * Created by Srujay Reddy Challa on 10/27/2017.
 */

public class BootReceiver extends BroadcastReceiver
{

    static  boolean called=false;
    @Override
    public void onReceive(Context context, Intent intent)
    {

        // Your code to execute when Boot Completd
        File myFile;
        called=true;
        Toast.makeText(context, "Booting Completed "+called, Toast.LENGTH_LONG).show();

    }



}