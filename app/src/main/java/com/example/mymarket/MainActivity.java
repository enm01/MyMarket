package com.example.mymarket;




import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2 * 500);
                    startActivity(new Intent(MainActivity.this, SignupActivity.class));
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                super.run();
            }
        };
        thread.start();





    }
}