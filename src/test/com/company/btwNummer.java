package com.company;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class btwNummer {

    @Test
    public void btwNummerTest() {
        ArrayList<String> alleTestBtwNummers = new ArrayList<>();
        alleTestBtwNummers.add("12");
        alleTestBtwNummers.add("12345678");
        alleTestBtwNummers.add("1");
        alleTestBtwNummers.add("123456789");
        alleTestBtwNummers.add("1234567890");
        alleTestBtwNummers.add("11111111111");
        alleTestBtwNummers.add("12345678901");
        String zin = "";


        System.out.println("voer je btwnummer in");
        for (int i = 0; i < alleTestBtwNummers.size(); i++) {
            if (alleTestBtwNummers.get(i).length() != 9) {
                    if (alleTestBtwNummers.get(i).length() > 9) {
                        zin = "Btwnummer is te groot";
                    }

                    if (alleTestBtwNummers.get(i).length() < 9) {
                        zin = "Btwnummer is te klein";
                    }
            } else {
                zin = "Btwnummer klopt";
            }

            if(i == 0) {
                assertEquals(zin, "Btwnummer is te klein");
            }
            if(i == 1) {
                assertEquals(zin, "Btwnummer is te klein");
            }
            if(i == 2) {
                assertEquals(zin, "Btwnummer is te klein");
            }
            if(i == 3) {
                assertEquals(zin, "Btwnummer klopt");
            }
            if(i == 4) {
                assertEquals(zin, "Btwnummer is te groot");
            }
            if(i == 5) {
                assertEquals(zin, "Btwnummer is te groot");
            }
            if(i == 6) {
                assertEquals(zin, "Btwnummer is te groot");
            }

        }
    }
}
