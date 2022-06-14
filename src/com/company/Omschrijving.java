package com.company;

public class Omschrijving {
    private String titel;
    private String werkgever;
    private int btw;
    private double bedrag;
    private int aantalUur;
    private int aantal;
    private double stukPrijs;

    public Omschrijving(String titel, String werkgever, int btw, int bedrag, int aantalUur) {
        this.titel = titel;
        this.werkgever = werkgever;
        this.btw = btw;
        this.bedrag = bedrag;
        this.aantalUur = aantalUur;
    }

    public Omschrijving(String titel, int aantal, double stukPrijs, int btw){
        this.titel = titel;
        this.aantal = aantal;
        this.stukPrijs = stukPrijs;
        this.btw = btw;
    }



    public String getTitel() {
        return titel;
    }

    public String getWerkgever() {
        return werkgever;
    }

    public double getBtw() {
        return btw;
    }

    public double getBedrag() {
        return bedrag;
    }

    public int getAantal() {
        return aantal;
    }


}
