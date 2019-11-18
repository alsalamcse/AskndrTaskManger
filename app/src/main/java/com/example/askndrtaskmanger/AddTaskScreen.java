package com.example.askndrtaskmanger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Data.MyTask;

public class AddTaskScreen extends AppCompatActivity {
    private EditText etTitle,etSubject;
    private SeekBar sbpriority;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task_screen);

        etTitle=findViewById(R.id.etTitle);
        etSubject=findViewById(R.id.etSubject);
        sbpriority=findViewById(R.id.sbpriority);
        btnSave=findViewById(R.id.btnSave);



        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }
        });
    }

    private void dataHandler()
    {
        boolean isok=true;
        String Title=etTitle.getText().toString();
        String Subject=etSubject.getText().toString();
       int priority= sbpriority.getProgress();

       if (Title.length()==0)
       {
           etTitle.setError("Enter Title");
           isok=false;

       }

       if (Subject.length()==0)
       {
           etSubject.setError("Enter Subject");
           isok=false;
       }

       if (isok)
       {
           MyTask task=new MyTask();
           task.setTitle(Title);
           task.setSubject(Subject);
           task.setPriority(priority);
           createMyTask(task);


       }


    }

    private void createMyTask(MyTask task)
    {
        //.1
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        //.2-save in database
        DatabaseReference reference = firebaseDatabase.getReference();//make a barameter ( with var)
        FirebaseAuth auth =FirebaseAuth.getInstance();//to get the user uid or details like email
        String uid = auth.getCurrentUser().getUid();
        task.setOwner(uid);

        String key = reference.child("Tasks").push().getKey();
        task.setKey(key);
        reference.child("Tasks").child(uid).child(key).setValue(task).addOnCompleteListener(AddTaskScreen.this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(AddTaskScreen.this, "Add Successful", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    Toast.makeText(AddTaskScreen.this, "Add Failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });


    }
}

