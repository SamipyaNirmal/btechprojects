package com.example.healthtry;

import android.content.Intent;
import android.hardware.SensorEventListener;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Bmi extends AppCompatActivity {
    TextInputLayout theight,tweight;
    EditText eheight,eweight;
    double bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);


        theight=(TextInputLayout) findViewById(R.id.input_height);
        eheight=(EditText)findViewById(R.id.height);
        tweight=(TextInputLayout) findViewById(R.id.input_weight);
        eweight=(EditText)findViewById(R.id.weight);

        //  double height= Integer.parseInt(getIntent().getExtras().getString("height"))*30.48;
        // Integer weight= Integer.parseInt(getIntent().getExtras().getString("weight"));





    }
    public static String bmicalculate(double bmi)
    {
        if(bmi<=18.5)
            return "underweight";
        if(bmi>18.5&&bmi<=24.9)
            return "normal weight";
        else if(bmi>24.9&&bmi<=30)
            return "over weight";
        else if(bmi>=30&&bmi<=34)
            return "obesity level 1";
        else
            return "obesity level 2";

    }

    public void sendDetails(View view) {
        double height=Double.parseDouble(eheight.getText().toString());
        double hei=height*30.48;
        Double weight=Double.parseDouble(eweight.getText().toString());
        bmi=weight/((hei*hei)/10000);

        if((eheight.getText().toString().trim().length()==0)){
            theight.setError("Height is mandatory");}
        else{   theight.setError(null);}
        if((eweight.getText().toString().trim().length()==0)){
            tweight.setError("Weight is mandatory");}
        else

        {String ans=bmicalculate( bmi);
            Toast.makeText(getApplicationContext(),ans,Toast.LENGTH_SHORT).show();}





    }
}

