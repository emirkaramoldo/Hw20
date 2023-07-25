package com.example.hw20;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            // Загрузка реальных данных о континентах и странах
            List<Continent> continents = loadContinentsFromDataSource();

            if (continents != null && !continents.isEmpty()) {
                ContinentAdapter continentAdapter = new ContinentAdapter(continents, new ContinentAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(Continent continent) {
                        showCountriesFragment(continent);
                    }
                });

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, new ContinentsFragment())
                        .commit();
            }
        }
    }

    void showCountriesFragment(Continent continent) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, CountriesFragment.newInstance(continent))
                .addToBackStack(null)
                .commit();
    }

    // Метод загрузки реальных данных о континентах
    private List<Continent> loadContinentsFromDataSource() {
        List<Continent> continents = new ArrayList<>();
        continents.add(new Continent("Африка"));
        continents.add(new Continent("Европа"));
        continents.add(new Continent("Азия"));
        continents.add(new Continent("Северная Америка"));
        continents.add(new Continent("Южная Америка"));
        continents.add(new Continent("Австралия"));
        return continents;
    }
}

