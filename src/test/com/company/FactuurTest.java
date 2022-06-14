package com.company;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FactuurTest {

    protected ArrayList<Omschrijving> alleOmschrijvingen = new ArrayList<>();

    @Test
    public void totaalBedragProduct() {
        alleOmschrijvingen.add(new Omschrijving("productNaam", 3, 2.0, 21));
        alleOmschrijvingen.add(new Omschrijving("productNaam2", 2, 6.7, 2));
        alleOmschrijvingen.add(new Omschrijving("productNaam3", 5, 1.67, 23));

        int bedrag = 0;
        for(int i = 0; i < alleOmschrijvingen.size(); i++){
            bedrag += alleOmschrijvingen.get(i).getStukPrijs() * alleOmschrijvingen.get(i).getAantal();
        }

        assertEquals(bedrag, 27);
    }

    @Test
    public void btwBedragProduct() {
        alleOmschrijvingen.add(new Omschrijving("productNaam", 3, 2.0, 21));
        alleOmschrijvingen.add(new Omschrijving("productNaam2", 2, 6.7, 2));
        alleOmschrijvingen.add(new Omschrijving("productNaam3", 5, 1.67, 23));

        double btwBedrag = 0;
        for(int i = 0; i < alleOmschrijvingen.size(); i++){
            btwBedrag += (alleOmschrijvingen.get(i).getStukPrijs() * alleOmschrijvingen.get(i).getAantal()) * (alleOmschrijvingen.get(i).getBtw() /100);
        }
        assertEquals(btwBedrag, 3, 3.4485);
    }
}