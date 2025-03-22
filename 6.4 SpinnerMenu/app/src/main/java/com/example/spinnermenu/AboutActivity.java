package com.example.spinnermenu;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_about);
        // Hämta URL från Intent
        String url = getIntent().getStringExtra("url");

        // Visa URL som en Toast
        if (url != null) {
            Toast.makeText(this, "URL: " + url, Toast.LENGTH_LONG).show();
        }
        Button backButton = findViewById(R.id.button);
        backButton.setOnClickListener(view -> {
            finish(); // Stäönger aktiviteten och går tillbaka
        });
    }
}