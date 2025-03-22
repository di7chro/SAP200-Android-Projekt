package org.crille.passdata;

import static android.app.PendingIntent.getActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btnLogin = findViewById(R.id.mainBtnLogin);
        EditText Username = findViewById(R.id.mainUsername);
        EditText Password = findViewById(R.id.mainPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameInput = Username.getText().toString().trim();
                String passwordInput = Password.getText().toString().trim();

                Log.i("Username", usernameInput);
                Log.i("Password", passwordInput);

                if (usernameInput.equals("crille") && passwordInput.equals("hemligt")) {
                    Toast.makeText(MainActivity.this, "BRA Login", Toast.LENGTH_SHORT).show();
                    Log.i("LOGIN", "Inloggning lyckades");

                    Intent intent = new Intent(MainActivity.this, SecretActivity.class);
                    intent.putExtra("USERNAME", usernameInput);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "FEL LOGIN", Toast.LENGTH_SHORT).show();
                    Log.i("LOGIN", "Fel användarnamn eller lösenord");
                }
            }
        });
    }
}