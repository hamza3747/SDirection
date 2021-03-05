package com.example.sdirection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        /*This code is to make the Actionbar Transparent*/
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

//      This code is used for hiding actionbar/toolbar
        getSupportActionBar().hide();


//      This code is for adding delay in splash screen
        Thread thread=new Thread(){

            public void run(){
                try {
                    sleep(500);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent=new Intent( SplashScreenActivity.this , MainActivity.class);
                    startActivity(intent);
                }
            }
        }; thread.start();               //Starting thread

    }
}