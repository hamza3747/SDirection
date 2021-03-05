package com.example.sdirection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);



        /*This code is to make the Actionbar Transparent*/
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        //      This code is used for hiding actionbar/toolbar
        getSupportActionBar().hide();

//      This code is used for changing title of actionbar/toolbar
//      getSupportActionBar().setTitle("Sign Up");
    }
}