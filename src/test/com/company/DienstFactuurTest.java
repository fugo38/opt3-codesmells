package com.company;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DienstFactuurTest {

    protected ArrayList<Omschrijving> alleOmschrijvingen = new ArrayList<>();
    User user1 = new User("henk", "1234", "man", 19);


    Factuur dienst = new DienstFactuur(user1, "testfactuur", 123456789, "10-10-2022");


    @Test
    public void printFactuur() {
        dienst.alleOmschrijvingen.add(new Omschrijving("titel", "werkgever", 21, 2, 21));
        System.out.println("Factuurnummer: " + 2);
        System.out.println("factuurdatum: " + "10-10-2022");
        System.out.println();
        for (int i = 0; i < alleOmschrijvingen.size(); i++){
            System.out.println(alleOmschrijvingen.get(i).getTitel()+ "   " +
                    alleOmschrijvingen.get(i).getWerkgever()+ "   " +
                    alleOmschrijvingen.get(i).getBtw()+ "   " +
                    alleOmschrijvingen.get(i).getBedrag()+ "   " +
                    alleOmschrijvingen.get(i).getAantal());
        }
        System.out.println("------------------------------------------------------------------------");
        System.out.println("totaal exc BTW      " + 42);
        System.out.println("BTW                 " + 8.82);
        System.out.println("----------------------------------");
        System.out.println("Totaal inc BTW      " + 50.82);

        assertEquals(dienst.alleOmschrijvingen.get(0).getTitel(), "titel");
        assertEquals(dienst.alleOmschrijvingen.get(0).getWerkgever(), "werkgever");
        assertEquals(dienst.alleOmschrijvingen.get(0).getAantal(), 21);
        assertEquals(dienst.naam, "testfactuur");
        assertEquals(dienst.btwNummer, 123456789);
        assertEquals(dienst.factuurDatum, "10-10-2022");
    }
}