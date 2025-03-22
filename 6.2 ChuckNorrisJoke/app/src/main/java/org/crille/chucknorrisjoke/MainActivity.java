package org.crille.chucknorrisjoke;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONObject;
import java.util.concurrent.Executors;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

// Huvudaktiviteten för appen, som visar ett Chuck Norris-skämt och låter användaren hämta ett nytt
public class MainActivity extends AppCompatActivity {
    // Referenser till UI-komponenter
    private TextView jokeTextView;
    private Button nextJokeButton;

    // API-url för att hämta slumpmässiga Chuck Norris-skämt
    private final String URL = "https://api.chucknorris.io/jokes/random";

    // OkHttp-klient för att hantera HTTP-anrop
    private final OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // Aktiverar kant-till-kant-layout
        setContentView(R.layout.activity_main); // Sätter layouten för aktiviteten

        // Koppla variabler till UI-komponenter i layouten
        jokeTextView = findViewById(R.id.mainJoke);
        nextJokeButton = findViewById(R.id.mainNext);

        // Hämta och visa ett skämt vid appstart
        fetchJoke();

        // Sätter en klicklyssnare på knappen för att hämta ett nytt skämt
        nextJokeButton.setOnClickListener(v -> fetchJoke());
    }

    // Metod för att hämta ett nytt skämt från API:et
    private void fetchJoke() {
        // Kör nätverksanropet på en separat tråd för att undvika att blockera huvudtråden
        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                // Skicka en HTTP GET-request till API:et och hämta responsen
                Response response = client.newCall(new Request.Builder().url(URL).build()).execute();

                // Om anropet lyckas, extrahera skämtet från JSON-responsen
                if (response.isSuccessful()) {
                    String joke = new JSONObject(response.body().string()).getString("value");

                    // Uppdatera UI-komponenten med det nya skämtet på huvudtråden
                    new Handler(Looper.getMainLooper()).post(() -> jokeTextView.setText(joke));
                }
            } catch (Exception e) {
                e.printStackTrace(); // Logga eventuella fel vid hämtning av skämt
            }
        });
    }
}