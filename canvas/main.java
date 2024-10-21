package com.example.canvas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Drawing drawing = new Drawing(this);
        setContentView(drawing);
//        CustomTextView customTextView = new CustomTextView(this, null);
//        setContentView(customTextView);

    }
}
