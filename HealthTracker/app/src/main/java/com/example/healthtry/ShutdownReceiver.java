package com.example.healthtry;

/**
 * Created by NANDITA on 30/10/17.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;



/**
 * Created by Srujay Reddy Challa on 10/27/2017.
 */

public class ShutdownReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        try {
            File myFile = new File("/sdcard/mysdfile.txt");
            try {
                myFile.createNewFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            FileOutputStream fOut = new FileOutputStream(myFile);
            OutputStreamWriter myOutWriter =
                    new OutputStreamWriter(fOut);
            myOutWriter.append(MainActivity.mt.getText().toString());
            myOutWriter.close();
            fOut.close();
            Toast.makeText(context, "Done writing SD 'mysdfile.txt'", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {

        }

    }
}
