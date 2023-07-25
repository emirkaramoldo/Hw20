package com.example.hw20;

public class CountryModel {
    private String name;
    private String continentName;

    public CountryModel(String name, String continentName) {
        this.name = name;
        this.continentName = continentName;
    }

    public String getName() {
        return name;
    }

    public String getContinentName() {
        return continentName;
    }
}