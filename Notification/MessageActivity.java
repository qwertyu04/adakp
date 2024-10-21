package com.example.notification;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MessageActivity extends AppCompatActivity {
private TextView textViewMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_message);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViewMessage = findViewById(R.id.text_message);
        handleIntent(getIntent());
    }
    @Override
    protected void onNewIntent(@NonNull Intent intent) {

        super.onNewIntent(intent);
        handleIntent(intent);
    }
    private void handleIntent(Intent intent){
        if(intent!=null){
            String message = intent.getStringExtra("message");
            if(message!=null){
                textViewMessage.setText(message);
            }
        }
    }
}