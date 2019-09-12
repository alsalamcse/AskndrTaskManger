package com.example.askndrtaskmanger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

    }
}
