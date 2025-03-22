package org.crille.sparadata;

import android.content.SharedPreferences;
import android.os.Bundle;
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
    private TextView mainOldNamn, mainOldAdress, mainOldTelefon;
    private EditText mainNyNamn, mainNyAdress, mainNyTelefon;
    private Button mainSpara, mainRensa;

    private SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "user_data";
    private static final String KEY_NAMN = "namn";
    private static final String KEY_ADRESS = "adress";
    private static final String KEY_TELEFON = "telefon";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Koppla variabler till UI-komponenter
        mainOldNamn = findViewById(R.id.mainOldNamn);
        mainOldAdress = findViewById(R.id.mainOldAdress);
        mainOldTelefon = findViewById(R.id.mainOldTelefon);
        mainNyNamn = findViewById(R.id.mainNyNamn);
        mainNyAdress = findViewById(R.id.mainNyAdress);
        mainNyTelefon = findViewById(R.id.mainNyTelefon);
        mainSpara = findViewById(R.id.mainSpara);
        mainRensa = findViewById(R.id.mainRensa);

        // Hämta SharedPreferences
        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        // Ladda sparade värden om de finns
        loadData();

        // Spara nya värden när Spara-knappen trycks
        mainSpara.setOnClickListener(v -> saveData());

        // Rensa sparade värden när Rensa-knappen trycks
        mainRensa.setOnClickListener(v -> clearData());
    }

    private void loadData() {
        String namn = sharedPreferences.getString(KEY_NAMN, "");
        String adress = sharedPreferences.getString(KEY_ADRESS, "");
        String telefon = sharedPreferences.getString(KEY_TELEFON, "");

        mainOldNamn.setText(namn);
        mainOldAdress.setText(adress);
        mainOldTelefon.setText(telefon);
    }

    private void saveData() {
        String namn = mainNyNamn.getText().toString();
        String adress = mainNyAdress.getText().toString();
        String telefon = mainNyTelefon.getText().toString();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_NAMN, namn);
        editor.putString(KEY_ADRESS, adress);
        editor.putString(KEY_TELEFON, telefon);
        editor.apply();

        // Uppdatera TextViews med nya data
        mainOldNamn.setText(namn);
        mainOldAdress.setText(adress);
        mainOldTelefon.setText(telefon);

        // Töm EditTexts efter sparning
        mainNyNamn.setText("");
        mainNyAdress.setText("");
        mainNyTelefon.setText("");
    }

    private void clearData() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(KEY_NAMN);
        editor.remove(KEY_ADRESS);
        editor.remove(KEY_TELEFON);
        editor.apply();

        // Töm TextViews
        mainOldNamn.setText("");
        mainOldAdress.setText("");
        mainOldTelefon.setText("");

        // Töm EditTexts
        mainNyNamn.setText("");
        mainNyAdress.setText("");
        mainNyTelefon.setText("");
    }
}