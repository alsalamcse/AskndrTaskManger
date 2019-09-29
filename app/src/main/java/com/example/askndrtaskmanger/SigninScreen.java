package com.example.askndrtaskmanger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SigninScreen extends AppCompatActivity {
    private EditText etemail, etPass;
    private Button btnSignin, btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_screen);


        etemail = findViewById(R.id.etemail);
        etPass = findViewById(R.id.etPass);
        btnSignin = findViewById(R.id.btnsSignin);
        btnSignup = findViewById(R.id.btnSignup);


        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplication(),SignUpScreen.class);
                startActivity(intent);
            }
        });


        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }
        });

    }

    private void dataHandler() {
        String email = etemail.getText().toString();
        String password = etPass.getText().toString();
        boolean isok = true;

        if (isValidEmailAddress(email) == false) {
            etemail.setError("Invalid Email");
            isok = false;
        }


        if (password.length() < 8) {
            etPass.setError("password length eror");
            isok = false;

        }
        if(isok)
        {

            signIn(email,password);
        }



    }


    private boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();

    }

    private void signIn(String email,String pass)
    {
        FirebaseAuth auth=FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    //todo go to, main screen(all task activity)


                     Intent i =new Intent(getApplication(),TempAllTasksACtivity.class);
                     startActivity(i);

                }
                else
                    {
                        etemail.setError("email or password is wrong");



                }


            }
        });
    }

}




