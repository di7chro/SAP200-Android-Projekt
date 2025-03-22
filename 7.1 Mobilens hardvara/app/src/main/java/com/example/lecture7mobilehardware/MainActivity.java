package com.example.lecture7mobilehardware;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button toCameraButton = findViewById(R.id.mainToCameraButton);
        toCameraButton.setOnClickListener(v -> {
            this.startCameraActivity();
        });

        Button toMotionButton = findViewById(R.id.mainToMotionButton);
        toMotionButton.setOnClickListener(v -> {
            this.startMotionActivity();
        });
    }

    private void startCameraActivity() {
        Intent intent = new Intent(MainActivity.this, CameraActivity.class);
        startActivity(intent);
    }

    private void startMotionActivity() {
        Intent intent = new Intent(MainActivity.this, MotionActivity.class);
        startActivity(intent);
    }
}