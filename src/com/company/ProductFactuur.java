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
        System.out.println("totaal exc BTW      " + totaalBedragProduct());
        System.out.println("BTW                 " + (btwBedragProduct()));
        System.out.println("----------------------------------");
        System.out.println("Totaal inc BTW      " + (btwBedragProduct() + totaalBedragProduct()));
    }

    @Override
    protected void printOmschrijving(ArrayList<Omschrijving> alleOmschrijvingen, int i) {
        System.out.println(alleOmschrijvingen.get(i).getTitel()+ "   " +
                alleOmschrijvingen.get(i).getWerkgever()+ "   " +
                alleOmschrijvingen.get(i).getAantalUur()+ "   " +
                alleOmschrijvingen.get(i).getBtw()+ "   " +
                alleOmschrijvingen.get(i).getBedrag());
    }
}
