package com.example.hw20;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ContinentsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_continents, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewContinents);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        // Загрузка реальных данных о континентах
        List<Continent> continents = loadContinentsFromDataSource();

        ContinentAdapter continentAdapter = new ContinentAdapter(continents, new ContinentAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Continent continent) {
                ((MainActivity) requireActivity()).showCountriesFragment(continent);
            }
        });
        recyclerView.setAdapter(continentAdapter);

        return view;
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
