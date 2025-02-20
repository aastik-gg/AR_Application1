package com.example.ar_application;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView textViewUserWelcome;
    public void openCam(View view){
        Intent cam = new Intent();
        cam.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(cam);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String userFirstName = getIntent().getStringExtra("userFirstName");
        textViewUserWelcome = findViewById(R.id.userWelcome);
        textViewUserWelcome.setText("Hello " + userFirstName + "!");
    }
}