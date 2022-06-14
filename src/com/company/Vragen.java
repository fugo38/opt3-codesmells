package com.company;

import java.util.Scanner;

public class Vragen {



    public static void DienstFactuurVragen(Factuur dienst){
        Scanner scanner = new Scanner(System.in);
        System.out.println("op welke locatie werkte U?");
        String titel = scanner.nextLine();
        System.out.println("welke werkgever?");
        String werkgever = scanner.nextLine();
        System.out.println("om hoeveel btw gaat het?");
        int btw = scanner.nextInt();
        System.out.println("hoeveel is de uurloon?");
        int bedrag = scanner.nextInt();
        System.out.println("hoeveel uur heeft u gewerkt?");
        int aantalUur = scanner.nextInt();
        scanner.nextLine();
        dienst.alleOmschrijvingen.add(new Omschrijving(titel, werkgever, btw, bedrag, aantalUur));
    }

    public static void productFactuurvragen(Factuur product){
        Scanner scanner = new Scanner(System.in);
        System.out.println("naam van het product?");
        String productNaam = scanner.nextLine();
        System.out.println("Aantal?");
        int productAantal = scanner.nextInt();
        System.out.println("Kosten per stuk?");
        double kostenPerStuk = scanner.nextDouble();
        System.out.println("btw van het product?");
        int productBtw = scanner.nextInt();
        scanner.nextLine();
        product.alleOmschrijvingen.add(new Omschrijving(productNaam, productAantal, kostenPerStuk, productBtw));
    }
}
