package com.example.healthtry;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class Details extends AppCompatActivity  {
    TextInputLayout tname,theight,tweight,tage;//TextView text1;
    EditText ename,eheight,eweight,eage;
    RadioGroup radioGroup;
    RadioButton radioButton;
    DatabaseReference databasedetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);




        tname=(TextInputLayout) findViewById(R.id.input_name);
        ename=(EditText)findViewById(R.id.name);
        tage=(TextInputLayout) findViewById(R.id.input_age);
        eage=(EditText)findViewById(R.id.age);
        radioGroup=(RadioGroup)findViewById(R.id.rg);
        theight=(TextInputLayout) findViewById(R.id.input_height);
        eheight=(EditText)findViewById(R.id.height);
        tweight=(TextInputLayout) findViewById(R.id.input_weight);
        eweight=(EditText)findViewById(R.id.weight);




    }

    public void sendDetails(View view) {
        if((ename.getText().toString().trim().length()==0)){
            tname.setError("Name is mandatory");}
        else{   tname.setError(null);}
        if((eage.getText().toString().trim().length()==0)){
            tage.setError("Age is mandatory");}
        else{   tname.setError(null);}
        if(eweight.getText().toString().trim().length()==0)
        {
            tweight.setError("Enter weight");
        }
        else
            tweight.setError(null);
        if(eheight.getText().toString().trim().length()==0)
        {
            theight.setError("Enter height");
        }
        else
            theight.setError(null);
        if(eheight.getText().toString().trim().length()>3)
        {
            theight.setError("Invalid height");
        }
        else
            theight.setError(null);

        if((ename.getText().toString().trim().length()!=0)&&(eheight.getText().toString().trim().length()!=0)
                &&(eweight.getText().toString().trim().length()!=0)&&(eheight.getText().toString().trim().length()<4)&&
                (eage.getText().toString().trim().length()!=0))
        {
            EditText zname=(EditText)findViewById(R.id.name);
            String name=zname.getText().toString();
            EditText zheight=(EditText)findViewById(R.id.height);
            String height=zheight.getText().toString();
            EditText zweight=(EditText)findViewById(R.id.weight);
            String weight=zweight.getText().toString();
            EditText zage=(EditText)findViewById(R.id.age);
            String age=zage.getText().toString();
            RadioGroup rgrp=(RadioGroup)findViewById(R.id.rg);
            int selectedId = rgrp.getCheckedRadioButtonId();




            // find the radiobutton by returned id
            radioButton = (RadioButton) findViewById(selectedId);
            String gen=radioButton.getText().toString();

          /*  Intent intent = new Intent(Details.this, MainActivity.class);
            intent.putExtra("weight", weight);
            intent.putExtra("gender",gen);
            startActivity(intent);*/

            databasedetails=FirebaseDatabase.getInstance().getReference("details");

            String id= databasedetails.push().getKey();
            FbDetails fbdetails=new FbDetails(name,age,id,height,weight,gen);
            databasedetails.child(id).setValue(fbdetails);
            Toast.makeText(getApplicationContext(),"Details added",Toast.LENGTH_SHORT).show();


            //enter into db

        }



    }
}
