package org.crille.dogviewer;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide; // Bibliotek för att ladda bilder från nätet

import org.json.JSONObject;

import java.util.concurrent.Executors;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

// Huvudaktiviteten för appen som visar slumpmässiga hundbilder
public class MainActivity extends AppCompatActivity {
    // UI-komponenter
    private ImageView dogImageView;
    private Button nextDogButton;

    // API-url för att hämta en slumpmässig hundbild
    private final String URL = "https://dog.ceo/api/breeds/image/random";

    // OkHttp-klient för att hantera HTTP-anrop
    private final OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // Aktiverar kant-till-kant-layout
        setContentView(R.layout.activity_main); // Sätter layouten för aktiviteten

        // Koppla UI-komponenter till layoutens element
        dogImageView = findViewById(R.id.mainImage);
        nextDogButton = findViewById(R.id.mainButton);

        // Hämta och visa en hundbild vid appstart
        fetchRandomDogImage();

        // Sätter en klicklyssnare på knappen för att hämta en ny hundbild
        nextDogButton.setOnClickListener(v -> fetchRandomDogImage());
    }

    // Metod för att hämta en slumpmässig hundbild från API:et
    private void fetchRandomDogImage() {
        // Kör nätverksanropet på en separat tråd för att undvika att blockera huvudtråden
        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                // Skicka en HTTP GET-request till API:et och hämta responsen
                Response response = client.newCall(new Request.Builder().url(URL).build()).execute();

                // Om anropet lyckas, extrahera bildens URL från JSON-responsen
                if (response.isSuccessful()) {
                    String imageUrl = new JSONObject(response.body().string()).getString("message");

                    // Uppdatera UI med den nya hundbilden på huvudtråden
                    runOnUiThread(() -> Glide.with(this).load(imageUrl).into(dogImageView));
                }
            } catch (Exception e) {
                e.printStackTrace(); // Logga eventuella fel vid hämtning av bilden
            }
        });
    }
}