package com.example.askndrtaskmanger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

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

    private void dataHandler(){
        boolean isok=true;
        String Title=etTitle.getText().toString();
        String Subject=etSubject.getText().toString();
       int priority= sbpriority.getProgress();

       if (Title.length()==0){
           etTitle.setError("Enter Title");
           isok=false;

       }
       if (Subject.length()==0){
           etSubject.setError("Enter Subject");
           isok=false;
       }
       if (isok){
           createTask(Title,Subject,priority);


       }


    }
    private void createTask(String Title,String Subject,int priority){

    }



}
