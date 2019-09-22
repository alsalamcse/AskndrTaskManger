package com.example.askndrtaskmanger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SigninScreen extends AppCompatActivity {
    private EditText etemail,etPass;
    private Button btnSignin,btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_screen);


        etemail=findViewById(R.id.etemail);
        etPass=findViewById(R.id.etPass);
        btnSignin=findViewById(R.id.btnsSignin);
        btnSignup=findViewById(R.id.btnSignup);



       btnSignin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               dataHandler();
           }
       });

    }
    private void dataHandler()
    {
            String email=etemail.getText().toString();
            String password=etPass.getText().toString();

        }
    }

