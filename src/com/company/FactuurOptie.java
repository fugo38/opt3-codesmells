package com.company;

public class FactuurOptie {
    private double korting;
    public boolean abbonement;
    private String factuurType;
    public boolean specialFeatures;
    public String bedrijfType;


    public FactuurOptie(double korting, boolean abbonement, String factuurType, boolean specialFeatures, String bedrijfType) {
        this.korting = korting;
        this.abbonement = abbonement;
        this.factuurType = factuurType;
        this.specialFeatures = specialFeatures;
        this.bedrijfType = bedrijfType;
    }

    public double kosten(double prijs){
        return new Kosten(this).berekenKorting(prijs);
    }


    public boolean getAbbonement() {
        return abbonement;
    }

    public String getFactuurType() {
        return factuurType;
    }

    public boolean getSpecialFeatures() {
        return specialFeatures;
    }

    public double getKorting() {
        return korting;
    }
}
