package com.example.ccna3.registration;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by RAJAT-PC on 10-01-2017.
 */

public class SplashSpinner extends AppCompatActivity {
    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashSpinner.this, RegActivity.class);
                startActivity(i);
                finish();
            }
        },3000);
    }
}

