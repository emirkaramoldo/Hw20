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

public class CountriesFragment extends Fragment {

    private static final String ARG_CONTINENT = "continent";

    public static CountriesFragment newInstance(Continent continent) {
        CountriesFragment fragment = new CountriesFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_CONTINENT, continent);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_countries, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewCountries);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        // Получаем переданный объект континента
        Continent continent = (Continent) getArguments().getSerializable(ARG_CONTINENT);

        // Загрузка реальных данных о странах для выбранного континента
        List<Country> countries = loadCountriesForContinentFromDataSource(continent.getName());

        CountryAdapter countryAdapter = new CountryAdapter(countries);
        recyclerView.setAdapter(countryAdapter);

        return view;
    }

    // Метод загрузки реальных данных о странах для выбранного континента
    private List<Country> loadCountriesForContinentFromDataSource(String continentName) {
        List<Country> countries = new ArrayList<>();
        if (continentName.equals("Африка")) {
            countries.add(new Country("Египет", "Каир", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Egypt.svg/250px-Flag_of_Egypt.svg.png"));
            countries.add(new Country("Кения", "Найроби", "https://cdn.webshopapp.com/shops/94414/files/52385976/flag-of-kenya.jpg"));
            countries.add(new Country("ЮАР", "Кейптаун", "https://geo5.net/imagens/Bandeira-da-Africa-do-Sul.png"));
            countries.add(new Country("Марокко", "Рабат", "https://cdn.webshopapp.com/shops/94414/files/52406302/flag-of-morocco.jpg"));
            countries.add(new Country("ЮАР", "Хартум", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/af/Flag_of_South_Africa.svg/240px-Flag_of_South_Africa.svg.png"));
        } else if (continentName.equals("Европа")) {
            countries.add(new Country("Италия", "Рим", "https://upload.wikimedia.org/wikipedia/en/thumb/0/03/Flag_of_Italy.svg/1200px-Flag_of_Italy.svg.png"));
            countries.add(new Country("Франция", "Париж", "https://upload.wikimedia.org/wikipedia/en/c/c3/Flag_of_France.svg"));
            countries.add(new Country("Германия", "Берлин", "https://upload.wikimedia.org/wikipedia/en/thumb/b/ba/Flag_of_Germany.svg/188px-Flag_of_Germany.svg.png"));
            countries.add(new Country("Великобритания", "Лондон", "https://upload.wikimedia.org/wikipedia/en/thumb/b/ba/Flag_of_Germany.svg/188px-Flag_of_Germany.svg.png"));
            countries.add(new Country("Россия", "Москва", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Flag_of_Russia.svg/240px-Flag_of_Russia.svg.png"));
        } else if (continentName.equals("Северная Америка")) {
            countries.add(new Country("США", "Вашингтон", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Flag_of_the_United_States.svg/240px-Flag_of_the_United_States.svg.png"));
            countries.add(new Country("Мексика", "Мехико", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fc/Flag_of_Mexico.svg/240px-Flag_of_Mexico.svg.png"));
            countries.add(new Country("Канада", "Оттава", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Flag_of_Canada_%28Pantone%29.svg/240px-Flag_of_Canada_%28Pantone%29.svg.png"));
        } else if (continentName.equals("Южная Америка")) {
                countries.add(new Country("Бразилия", "Бразилиа", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Flag_of_Brazil.svg/240px-Flag_of_Brazil.svg.png"));
                countries.add(new Country("Аргентина", "Буэнос-Айрес", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Flag_of_Argentina.svg/240px-Flag_of_Argentina.svg.png"));
                countries.add(new Country("Перу", "Лима", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/df/Flag_of_Peru_%28state%29.svg/240px-Flag_of_Peru_%28state%29.svg.png"));
                countries.add(new Country("Чили", "Сантьяго", "https://upload.wikimedia.org/wikipedia/commons/thumb/7/78/Flag_of_Chile.svg/240px-Flag_of_Chile.svg.png"));
                countries.add(new Country("Суринам", "Парамарибо", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/60/Flag_of_Suriname.svg/240px-Flag_of_Suriname.svg.png"));
        } else if (continentName.equals("Австралия")) {
            countries.add(new Country("Австралия", "Канберра", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/Flag_of_Australia_%28converted%29.svg/240px-Flag_of_Australia_%28converted%29.svg.png"));
            countries.add(new Country("Новая Зеландия", "Веллингтон", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/Flag_of_New_Zealand.svg/240px-Flag_of_New_Zealand.svg.png"));
            countries.add(new Country("Папуа — Новая Гвинея", "Порт-Морсби", "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e3/Flag_of_Papua_New_Guinea.svg/240px-Flag_of_Papua_New_Guinea.svg.png"));
            countries.add(new Country("Тувалу", "Фунафути", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/38/Flag_of_Tuvalu.svg/240px-Flag_of_Tuvalu.svg.png"));
            countries.add(new Country("Микронезия", "Паликир", "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e4/Flag_of_the_Federated_States_of_Micronesia.svg/240px-Flag_of_the_Federated_States_of_Micronesia.svg.png"));
        }
        return countries;
    }
}
