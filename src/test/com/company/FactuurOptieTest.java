package com.company;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FactuurOptieTest {

    private String bedrijfType;
    private  boolean abbonement;
    private String factuurType;
    private boolean specialFeatures;
    private int bedrag;
    ArrayList<FactuurOptie> alleFactuurOptie = new ArrayList<>();


    @Test
    public void kosten() {

        FactuurOptie factuurOptie1 = new FactuurOptie(0.4, true, "Dienst", true, "ZZP");
        FactuurOptie factuurOptie2 = new FactuurOptie(0.4, false, "Product", false, "ZZP");
        FactuurOptie factuurOptie3 = new FactuurOptie(0.6, true, "Product", true, "ZZP");
        FactuurOptie factuurOptie4 = new FactuurOptie(0.7, false, "Dienst", false, "ZZP");
        FactuurOptie factuurOptie5 = new FactuurOptie(0.2, true, "Dienst", false, "ZZP");
        FactuurOptie factuurOptie6 = new FactuurOptie(0.8, false, "Product", true, "ZZP");
        alleFactuurOptie.add(factuurOptie1);
        alleFactuurOptie.add(factuurOptie2);
        alleFactuurOptie.add(factuurOptie3);
        alleFactuurOptie.add(factuurOptie4);
        alleFactuurOptie.add(factuurOptie5);
        alleFactuurOptie.add(factuurOptie6);
        for (int i = 0; i < alleFactuurOptie.size(); i++) {

            float kosten = 0;
            if (alleFactuurOptie.get(i).getFactuurType().equals("Dienst")) {
                kosten = 2;
            }
            if (alleFactuurOptie.get(i).getFactuurType().equals("Product")) {
                kosten = 3;
            }

            kosten *= alleFactuurOptie.get(i).getKorting();

            if (alleFactuurOptie.get(i).getAbbonement()) {
                kosten *= 0.7;
            }
            if (alleFactuurOptie.get(i).getSpecialFeatures()) {
                kosten *= 1.4;
            }

            System.out.println(kosten);

        }

    }
}