package org.crille.passdata;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecretActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_secret);

        // Hämta intent och extradata
        String username = getIntent().getStringExtra("USERNAME");

        // Visa användarnamnet i en TextView (exempel)
        TextView rubrik = findViewById(R.id.secretRubrik);
        rubrik.setText("Dekrypterat för: " + username);
    }
}