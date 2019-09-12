package com.example.askndrtaskmanger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;

public class SettingsScreen extends AppCompatActivity {
    private CheckBox cbsound;
    private SeekBar sksize;
    private Button btnchange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_screen);


        cbsound=findViewById(R.id.cbsound);
        sksize=findViewById(R.id.sksize);
        btnchange=findViewById(R.id.btnchange);
    }
}
