package com.company;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;
public class ProductFactuurTest {
    protected ArrayList<Omschrijving> alleOmschrijvingen = new ArrayList<>();
    User user1 = new User("henk", "1234", "man", 19);

    Factuur product = new ProductFactuur(user1,"testfactuur",  "10-10-2022");

    @Test
    public void printFactuur() {
        product.alleOmschrijvingen.add(new Omschrijving("productNaam", 3, 2.0, 21));
        System.out.println("Factuurnummer: " + 2);
        System.out.println("factuurdatum: " + "10-10-2022");
        System.out.println();
        for (int i = 0; i < alleOmschrijvingen.size(); i++){
            System.out.println(alleOmschrijvingen.get(i).getTitel()+ "   " +
                    alleOmschrijvingen.get(i).getAantal()+ "   " +
                    alleOmschrijvingen.get(i).getStukPrijs()+ "   " +
                    alleOmschrijvingen.get(i).getStukPrijs() * alleOmschrijvingen.get(i).getAantal()+ "   " +
                    alleOmschrijvingen.get(i).getBtw());
        }
        System.out.println("------------------------------------------------------------------------");
        System.out.println("totaal exc BTW      " + 6);
        System.out.println("BTW                 " + 1.27);
        System.out.println("----------------------------------");
        System.out.println("Totaal inc BTW      " + 7.27);

        assertEquals(product.alleOmschrijvingen.get(0).getTitel(), "productNaam");
        assertEquals(product.alleOmschrijvingen.get(0).getAantal(), 3);

    }
}
