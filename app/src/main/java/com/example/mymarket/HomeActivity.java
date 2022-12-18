package com.example.mymarket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    private ImageView epi;
    private ImageView bou;
    private ImageView leg;
    private ImageView pat;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.epi=(ImageView) findViewById(R.id.episserie);
        this.bou=(ImageView)findViewById(R.id.boucherie);
        this.leg=(ImageView)findViewById(R.id.legume);
        this.pat=(ImageView)findViewById(R.id.patisserie);

        epi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent versepi=new Intent(getApplicationContext(),epicerie.class);
                startActivity(versepi);
                finish();
            }
        });

        leg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent versleg=new Intent(getApplicationContext(),legume.class);
                startActivity(versleg);
                finish();
            }
        });

        bou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent versbou=new Intent(getApplicationContext(),boucherie.class);
                startActivity(versbou);
                finish();
            }
        });

        pat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent verspat=new Intent(getApplicationContext(),patisserie.class);
                startActivity(verspat);
                finish();
            }
        });
    }
}
