package com.example.spinnermenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Spinner mySpinner = findViewById(R.id.spinner);

        List<SpinnerItem> items = new ArrayList<>();
        items.add(new SpinnerItem("Välj en aktivitet", ""));
        items.add(new SpinnerItem("Settings", "https://example.com/settings"));
        items.add(new SpinnerItem("About", "https://example.com/about"));
        items.add(new SpinnerItem("Contact", "https://example.com/contact"));

        ArrayAdapter<SpinnerItem> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(adapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SpinnerItem selectedItem = (SpinnerItem) parent.getItemAtPosition(position);
                String selectedTitle = selectedItem.getTitle();
                String selectedUrl = selectedItem.getUrl();

                // Exempel: Starta en ny aktivitet beroende på valet
                Intent intent;
                switch (selectedTitle) {
                    case "Settings":
                        intent = new Intent(MainActivity.this, SettingsActivity.class);
                        break;
                    case "About":
                        intent = new Intent(MainActivity.this, AboutActivity.class);
                        break;
                    case "Contact":
                        intent = new Intent(MainActivity.this, ContactActivity.class);
                        break;
                    default:
                        return;
                }

                intent.putExtra("url", selectedUrl); // Skicka med URL:en om det behövs
                startActivity(intent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


    }
}