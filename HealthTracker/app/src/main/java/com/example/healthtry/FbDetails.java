package com.example.healthtry;

/**
 * Created by NANDITA on 30/10/17.
 */

import android.widget.EditText;
import android.widget.RadioButton;

/**
 * Created by NANDITA on 29/10/17.
 */

public class FbDetails {

    String name;
    String age;
    String userid;
    String height;String weight;String gender;
    //constructor used while reading the values
    public FbDetails(EditText ename, EditText eage, String id, EditText eheight, EditText eweight, RadioButton radioButton)
    {

    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getUserid() {
        return userid;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getGender() {
        return gender;
    }

    public FbDetails(String name, String age, String userid, String height, String weight,String gender) {

        this.name = name;
        this.age = age;
        this.userid = userid;
        this.height = height;
        this.weight=weight;
        this.gender=gender;
    }
}
