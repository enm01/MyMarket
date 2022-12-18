package com.example.mymarket;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    EditText username , password  , email ;
    Button signupbtn ;
    TextView haveaccount ;
    DBHelper DB ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        haveaccount = findViewById(R.id.haveaccount);
        signupbtn = findViewById(R.id.signupbtn);
        DB = new DBHelper(this);


        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString();
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(mail)) {
                    Toast.makeText(SignupActivity.this, "Tous les champs sont obligatoires !", Toast.LENGTH_SHORT).show();
                } else {
                    if (DB.checkusername(user) == false) {
                        Boolean insert = DB.insertData(user, pass);
                        if (insert == true) {
                            Toast.makeText(SignupActivity.this, "Bienvenue dans votre épicerie ", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(SignupActivity.this, "Inscription échouée", Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        Toast.makeText(SignupActivity.this, "Nom d'utilisateur déjà existant !", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

        haveaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);



            }
        });

    }
}