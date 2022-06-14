package com.company;

public class FactuurOptie {
    private double korting;
    private  boolean abbonement;
    private String factuurType;
    private boolean specialFeatures;



    public FactuurOptie(double korting, boolean abbonement, String factuurType, boolean specialFeatures) {
        this.korting = korting;
        this.abbonement = abbonement;
        this.factuurType = factuurType;
        this.specialFeatures = specialFeatures;
    }

    public double kosten(){
            int kosten = 1;
            kosten *= korting;

            if(abbonement){
                kosten *= 0.7;
            }
            if(specialFeatures){
                kosten *= 1.4;
            }


        return kosten;
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
