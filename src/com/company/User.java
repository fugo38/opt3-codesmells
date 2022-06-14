package com.company;

public class User {

    private String naam;
    private String wachtwoord;
    private String geslacht;
    private int leeftijd;


    public User( String naam, String wachtwoord, String geslacht, int leeftijd) {

        this.naam = naam;
        this.wachtwoord = wachtwoord;
        this.geslacht = geslacht;
        this.leeftijd = leeftijd;
    }



    public String getNaam() {
        return naam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }
}
