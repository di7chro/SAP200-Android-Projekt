package com.example.filmlistan;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ListView filmListView = findViewById(R.id.filmLista);

        // Skapa en array m ed filmer
        ArrayList<String> filmArray = new ArrayList<>();

        filmArray.add("Blade Runner");
        filmArray.add("The Shawshank Redemption");
        filmArray.add("The Godfather");
        filmArray.add("The Dark Knight");
        filmArray.add("Pulp Fiction");
        filmArray.add("Schindler's List");
        filmArray.add("The Lord of the Rings: The Return of the King");
        filmArray.add("Fight Club");
        filmArray.add("Forrest Gump");
        filmArray.add("Inception");
        filmArray.add("The Matrix");
        filmArray.add("Goodfellas");
        filmArray.add("Se7en");
        filmArray.add("The Silence of the Lambs");
        filmArray.add("Saving Private Ryan");
        filmArray.add("Interstellar");
        filmArray.add("The Green Mile");
        filmArray.add("The Usual Suspects");
        filmArray.add("Gladiator");
        filmArray.add("The Lion King");
        filmArray.add("Terminator 2: Judgment Day");
        filmArray.add("Back to the Future");
        filmArray.add("The Prestige");
        filmArray.add("The Departed");
        filmArray.add("Whiplash");
        filmArray.add("The Intouchables");
        filmArray.add("The Pianist");
        filmArray.add("Memento");
        filmArray.add("Parasite");
        filmArray.add("The Wolf of Wall Street");
        filmArray.add("The Great Dictator");
        filmArray.add("Avengers: Endgame");
        filmArray.add("Once Upon a Time in Hollywood");
        filmArray.add("The Grand Budapest Hotel");
        filmArray.add("Joker");
        filmArray.add("Django Unchained");
        filmArray.add("A Clockwork Orange");
        filmArray.add("Toy Story");
        filmArray.add("Inglourious Basterds");
        filmArray.add("Logan");
        filmArray.add("The Revenant");
        filmArray.add("Mad Max: Fury Road");
        filmArray.add("No Country for Old Men");
        filmArray.add("There Will Be Blood");
        filmArray.add("The Social Network");
        filmArray.add("Black Swan");
        filmArray.add("The Truman Show");
        filmArray.add("The Sixth Sense");
        filmArray.add("The Shining");
        filmArray.add("2001: A Space Odyssey");
        filmArray.add("Blade Runner 2049");
        filmArray.add("Kill Bill: Vol. 1");
        filmArray.add("Oldboy");
        filmArray.add("The Hateful Eight");
        filmArray.add("Requiem for a Dream");
        filmArray.add("Pan's Labyrinth");
        filmArray.add("The Big Lebowski");
        filmArray.add("Her");
        filmArray.add("Gone Girl");
        filmArray.add("Prisoners");
        filmArray.add("The Irishman");
        filmArray.add("Doctor Strange");
        filmArray.add("Guardians of the Galaxy");
        filmArray.add("Spider-Man: Into the Spider-Verse");
        filmArray.add("Deadpool");
        filmArray.add("The Dark Knight Rises");
        filmArray.add("The Incredibles");
        filmArray.add("Finding Nemo");
        filmArray.add("Ratatouille");
        filmArray.add("Coco");

        // Skapa en Adapter mellan listan och ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, filmArray);

        filmListView.setAdapter(adapter);

        // Sätt en klick-lyssnare på listan som hanterar raden som klickades
        filmListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String selectedMovie = (String) adapterView.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "Vald: " + selectedMovie, Toast.LENGTH_SHORT).show();
            }
        });

    }
}