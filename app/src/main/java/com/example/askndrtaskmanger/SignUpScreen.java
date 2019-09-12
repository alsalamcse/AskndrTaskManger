package com.example.askndrtaskmanger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SignUpScreen extends AppCompatActivity {
    private EditText etFirst,etLast,etPhone,etEmail,etPass,etrewrite;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);

        etFirst=findViewById(R.id.etFirst);
        etLast=findViewById(R.id.etLast);
        etPhone=findViewById(R.id.etPhone);
        etEmail=findViewById(R.id.etEmail);
        etPass=findViewById(R.id.etPass);
        etrewrite=findViewById(R.id.etrewrite);
        btnSave=findViewById(R.id.btnSave);

    }
}
