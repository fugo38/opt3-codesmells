package com.company;

import java.util.ArrayList;

public class ProductFactuur extends Factuur{
    public ProductFactuur(User user, String naam, String factuurDatum) {
        super(user,naam, factuurDatum);
    }

    @Override
    public void printFactuur() {
        System.out.println("naam: " + this.user.getNaam());
        System.out.println("Factuurnummer: " + uniekFactuurnummer());
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

    @Override
    protected void printOmschrijving(ArrayList<Omschrijving> alleOmschrijvingen, int i) {
        System.out.println(alleOmschrijvingen.get(i).getTitel()+ "   " +
                alleOmschrijvingen.get(i).getAantal()+ "   " +
                alleOmschrijvingen.get(i).getBedrag()+ "   " +
                alleOmschrijvingen.get(i).getBedrag() * alleOmschrijvingen.get(i).getAantal()+ "   " +
                alleOmschrijvingen.get(i).getBtw());
    }
}
