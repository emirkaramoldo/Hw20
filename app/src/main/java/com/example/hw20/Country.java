package com.example.hw20;

public class Country {
    private String name;
    private String capital;
    private String flagUrl;

    public Country(String name, String capital, String flagUrl) {
        this.name = name;
        this.capital = capital;
        this.flagUrl = flagUrl;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public String getFlagUrl() {
        return flagUrl;
    }
}