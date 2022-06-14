package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Factuur>facturen = new ArrayList<>();
    static int btwNummer;
    private static ArrayList<User> user = new ArrayList<>();
    private static String gebruiker;
    private static boolean ingelogd;
    private static String wachtwoord;
    private static User user1;

    public static void main(String[] args) {
//        Login.inloggen();
        boolean opnieuw = true;

        Scanner scanner = new Scanner(System.in);

        while (!ingelogd){

            inloggen();
        }

        do {

        System.out.println("1- Maak een Dienstfactuur aan");
        System.out.println("2- maak een productfactuur aan");
        System.out.println("3- alle facturen bekijken");
        System.out.println("4- BtwNummer toevoegen/aanpassen");
        System.out.println("5- Inloggen met een ander account");
        System.out.println("6- Exit");

        System.out.print("Choose your option : ");

            int keuze = scanner.nextInt();
            switch (keuze) {
                case 1:
                    maakFactuur(keuze);
                    break;
                case 2:
                    maakFactuur(keuze);
                    break;
                case 3:
                    printAlleFacturen();
                    break;

                case 4:
                    btwNummerAanpassen();
                    break;

                case 5:
                    inloggen();
                    break;

                case 6:
                    System.out.println("Systeem word afgesloten");
                    opnieuw = false;
                    break;

                default:
                    System.out.println("kies een getal tussen de 1 en 4");
                    keuze = scanner.nextInt();
                    break;
            }
        } while (opnieuw);

//
//        if(Login.inloggen()){


    }

    public static void createAccount(){
        System.out.println("maak een account aan");
        System.out.println("voer je gebruikersnaam in");
        gebruiker = scanner.nextLine();
        System.out.println("voer je wachtwoord in");
        wachtwoord = scanner.nextLine();
        user.add(user1 = new User( gebruiker, wachtwoord, "man",18 ));
    }

    private static boolean checkInlog(String gebruiker, String wachtwoord) {
        for(int i = 0; i< user.size(); i++){
            if(gebruiker.equals(user.get(i).getNaam()) && wachtwoord.equals(user.get(i).getWachtwoord())){
                user1 = user.get(i);
                return true;
            }
        }
        System.out.println("er bestaat nog geen account, maak er een aan");
        createAccount();
        return true;
    }

    public static boolean inloggen(){
        Scanner scanner = new Scanner(System.in);
        if(user.size() == 0){
            createAccount();
            return ingelogd = true;
        }
        System.out.println("vul je gebruikersnaam in");
        gebruiker = scanner.nextLine();
        System.out.println("vul je wachtwoord in");
        wachtwoord = scanner.nextLine();

        checkInlog(gebruiker, wachtwoord);
        return ingelogd;
    }



    private static void setBtwNummer() {
        System.out.println("voer je btwnummer in");
        btwNummer = scanner.nextInt();
        while(String.valueOf(btwNummer).length() != 9){
            if(String.valueOf(btwNummer).length() > 9){
                System.out.println("Btwnummer is te groot");
            }

            if(String.valueOf(btwNummer).length() < 9){
                System.out.println("Btwnummer is te klein");
            }

            btwNummer = scanner.nextInt();
        }
    }


//methode om de btwnummer aan te kunnen passen
    private static void btwNummerAanpassen(){
        if(btwNummer != 0 ){
            System.out.println("in het systeem geregistreerde btwnummer: " + btwNummer);
            System.out.println("-----------------------------------------");
        }
        setBtwNummer();

        scanner.nextLine();
    }

    private static void DienstFactuurVragen(Factuur dienst){
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

    private static void productFactuurvragen(Factuur product){
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


    private static void addOmschrijving(boolean meerOmschrijvingen, Factuur factuur, int typeFactuur){

        while (meerOmschrijvingen) {
            System.out.println("hoeveel omschrijvingen wilt u?");
            int aantalOmschrijvingen = scanner.nextInt();
            scanner.nextLine();

            while (aantalOmschrijvingen > 0) {
                if(typeFactuur == 1) {
                    DienstFactuurVragen(factuur);
                }
                else {
                    productFactuurvragen(factuur);
                }
                System.out.println("omschrijving aangemaakt, nog " + (aantalOmschrijvingen -= 1) + " omschrijving(en) te gaan");
                System.out.println("--------------------------------------------------------------------");
            }

            System.out.println("wil je toch nog meer omschrijvingen toevoegen? y of n");

            String meer = scanner.nextLine();
            if (meer.equals("N") || meer.equals("n")) {
                meerOmschrijvingen = false;
            }
        }
    }

    //aanmaken van een Dienstfactuur
    private static void maakFactuur(int typeFactuur) {
        Factuur factuur;
        if (ingelogd) {
            System.out.print("factuur naam:");
            String factuurNaam = scanner.nextLine();
            boolean meerOmschrijvingen = true;
            if(typeFactuur ==1) {
                if (btwNummer == 0) {
                    btwNummerAanpassen();
                }
                factuur = new DienstFactuur(user1, factuurNaam, btwNummer, java.time.LocalDate.now().toString());
            }
            else{
                factuur = new ProductFactuur(user1,factuurNaam, java.time.LocalDate.now().toString());
            }
            addOmschrijving(meerOmschrijvingen, factuur, typeFactuur);

            facturen.add(factuur);
            factuur.printFactuur();
            System.out.println("--------------------------------------------------------------------");
        } else{ inloggen(); }
    }
//
//
//
//    //aanmaken van een Productfactuur
//    private static void maakProductFactuur(int typeFactuur) {
//        boolean meerOmschrijvingen = true;
//        System.out.print("factuur naam:");
//        String factuurNaam = scanner.nextLine();
//
//        Factuur product = new ProductFactuur(user1,factuurNaam, java.time.LocalDate.now().toString());
//
//        while (meerOmschrijvingen) {
//            System.out.println("hoeveel omschrijvingen wilt u?");
//            int aantalOmschrijvingen = scanner.nextInt();
//            scanner.nextLine();
//            while (aantalOmschrijvingen > 0) {
//
//                productFactuurvragen(product);
//
//                System.out.println("omschrijving aangemaakt, nog " + (aantalOmschrijvingen -= 1) + " omschrijving(en) te gaan");
//                System.out.println("--------------------------------------------------------------------");
//            }
//
//            System.out.println("wil je toch nog meer omschrijvingen toevoegen? y of n");
//
//            String meer = scanner.nextLine();
//            if (meer.equals("N") || meer.equals("n")) {
//                meerOmschrijvingen = false;
//            }
//        }
//        facturen.add(product);
//        product.printFactuur();
//        System.out.println("--------------------------------------------------------------------");
//    }

    private static void geenFactuur(){
        System.out.println("er zijn nog geen facturen, maak er eerst een aan!");
        System.out.println("--------------------------------------------------------------------");
        System.out.println();
    }

    private static void printAlleFacturen(){
        if(facturen.size()<= 0) {
            geenFactuur();
        }
        for (int i = 0; i < facturen.size(); i++){
            if(user1.getNaam().equals(facturen.get(i).user.getNaam())) {
                facturen.get(i).printFactuur();
                System.out.println("--------------------------------------------------------------------");
            }
        }
    }

}