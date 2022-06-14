package com.company;

public class Kosten {

    String bedrijfType;
    boolean abbonement;
    boolean specialFeatures;
    public Kosten(FactuurOptie factuurOptie){
        this.bedrijfType = factuurOptie.bedrijfType;
        this.abbonement = factuurOptie.abbonement;
        this.specialFeatures = factuurOptie.specialFeatures;
    }

    public double bepaalKorting() {

        switch (bedrijfType) {
            case ("multinational"):
                return 0.6;


            case ("normaal"):
                return 0.8;


            case ("eenmans"):
                return 0.9;
        }
        return 0.0;
    }

    public double berekenKorting( double kosten){

        kosten *= bepaalKorting();
        if (abbonement) {
            kosten *= 0.7;
        }
        if (specialFeatures) {
            kosten *= 1.4;
        }
        return kosten;
    }
}
