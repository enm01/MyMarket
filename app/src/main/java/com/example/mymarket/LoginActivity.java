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

public class LoginActivity extends AppCompatActivity {
    TextView donhaveaccount;
    EditText username , password ;
    Button loginbtn ;
    DBHelper DB ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username1);
        password =findViewById(R.id.password1);
        DB = new DBHelper(this);

        loginbtn = findViewById(R.id.loginbtn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString() ;
                String pass = password.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)){
                    Toast.makeText(LoginActivity.this, "tous les champs sont obligatoires !", Toast.LENGTH_SHORT).show();

                }else{
                    Boolean checkuserpass = DB.checkusernamepassword(user,pass);
                    if(checkuserpass == true){
                        Toast.makeText(LoginActivity.this , "bienvenue de nouveau  dans votre market" , Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this , "nom d'utilisateur ou mot de passe incorrects , veuillez essayer de nouveau " , Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        donhaveaccount = findViewById(R.id.donthaveaccount);

        donhaveaccount.setOnClickListener(v->{
            startActivity(new Intent(LoginActivity.this, SignupActivity.class));
        });

    }
}