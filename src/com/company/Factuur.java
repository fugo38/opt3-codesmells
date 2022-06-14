package com.company;

import java.util.ArrayList;

public abstract class Factuur implements bedragBerekent{
    protected String naam;
    private int factuurNummer = 0;
    protected ArrayList<Omschrijving> alleOmschrijvingen = new ArrayList<>();
    protected int btwNummer;
    protected String factuurDatum;
    protected User user;

    public Factuur(User user, String naam, int btwNummer, String factuurDatum) {
        this.user = user;
        this.naam = naam;
        this.factuurNummer = uniekFactuurnummer();
//        this.alleOmschrijvingen = initialiseerOmschrijving();
        this.btwNummer = btwNummer;
        this.factuurDatum = factuurDatum;
    }

    public Factuur(User user, String naam, String factuurDatum) {
        this.user = user;
        this.naam = naam;
        this.factuurDatum = factuurDatum;
    }

    protected int uniekFactuurnummer(){
        factuurNummer++;
        return factuurNummer;

    }

    public double totaalBedrag(){
        int bedrag = 0;
        for(int i = 0; i < alleOmschrijvingen.size(); i++){
            bedrag += alleOmschrijvingen.get(i).getBedrag() * alleOmschrijvingen.get(i).getAantal();
        }
        return bedrag;
    }


    public double btwBedrag(){
        double btwBedrag = 0;
        for(int i = 0; i < alleOmschrijvingen.size(); i++){
            btwBedrag += (alleOmschrijvingen.get(i).getBedrag() * alleOmschrijvingen.get(i).getAantal()) * (alleOmschrijvingen.get(i).getBtw() /100);
        }
        return btwBedrag;
    }



    public void printFactuur() {
        System.out.println("Factuurnummer: " + uniekFactuurnummer());
        System.out.println("BTW nummer: " + this.btwNummer);
        System.out.println("factuurdatum: " + this.factuurDatum);
        System.out.println();
        for (int i = 0; i < alleOmschrijvingen.size(); i++){
            printOmschrijving(alleOmschrijvingen, i);
        }
        System.out.println("------------------------------------------------------------------------");
        System.out.println("totaal exc BTW      " + totaalBedrag());
        System.out.println("BTW                 " + (btwBedrag()));
        System.out.println("----------------------------------");
        System.out.println("Totaal inc BTW      " + (btwBedrag() + totaalBedrag()));
    }


    protected void printOmschrijving(ArrayList<Omschrijving> alleOmschrijvingen, int i) {
        System.out.println(alleOmschrijvingen.get(i).getTitel()+ "   " +
                alleOmschrijvingen.get(i).getWerkgever()+ "   " +
                alleOmschrijvingen.get(i).getAantal()+ "   " +
                alleOmschrijvingen.get(i).getBtw()+ "   " +
                alleOmschrijvingen.get(i).getBedrag());
    }

}
