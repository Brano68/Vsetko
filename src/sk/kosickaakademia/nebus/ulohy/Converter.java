package sk.kosickaakademia.nebus.ulohy;

import java.util.Scanner;

/**
 * Trieda converter
 */

public class Converter {

    ///konstruktor
    public Converter(){

    }

    ///konvertorove metody
    public void convertToBinary(int cislo) {
        //inicializacia premennych
        int velkostPola = 0;
        int pomocneCislo = cislo;
        //zisti velkost pola
        while (pomocneCislo != 0) {
            pomocneCislo = pomocneCislo / 2;
            velkostPola++;
        }
        int[] pole = new int[velkostPola];
        //ulozenie do pola
        for (int i = 0; i < velkostPola; i++) {
            pole[i] = cislo % 2;
            cislo = cislo / 2;
        }
        //vypis pola od zadu
        for (int j = velkostPola - 1; j >= 0; j--) {
            System.out.print(pole[j]);
        }
    }

    public void convertToOcta(int cislo) {
        //inicializacia premennych
        int velkostPola = 0;
        int pomocneCislo = cislo;
        //zisti velkost pola
        while (pomocneCislo != 0) {
            pomocneCislo = pomocneCislo / 8;
            velkostPola++;
        }
        int[] pole = new int[velkostPola];
        //ulozenie do pola
        for (int i = 0; i < velkostPola; i++) {
            pole[i] = cislo % 8;
            cislo = cislo / 8;
        }
        //vypis pola od zadu
        for (int j = velkostPola - 1; j >= 0; j--) {
            System.out.print(pole[j]);
        }
    }

    public void convertToHexa(int cislo) {
        //inicializacia premennych
        int velkostPola = 0;
        int pomocneCislo = cislo;
        //zisti velkost pola
        while (pomocneCislo != 0) {
            pomocneCislo = pomocneCislo / 16;
            velkostPola++;
        }
        int[] pole = new int[velkostPola];
        //ulozenie do pola
        for (int i = 0; i < velkostPola; i++) {
            pole[i] = cislo % 16;
            cislo = cislo / 16;
        }
        //vypis pola od zadu
        for (int j = velkostPola - 1; j >= 0; j--) {
            //System.out.print(pole[j]);
            /*
            if(pole[j] == 10){
                System.out.print("A");
            }else if(pole[j] == 11){
                System.out.print("B");
            }else if(pole[j] == 12){
                System.out.print("C");
            }else if(pole[j] == 13){
                System.out.print("D");
            }else if(pole[j] == 14){
                System.out.print("E");
            }else if(pole[j] == 15){
                System.out.print("F");
            }else{
                System.out.print(pole[j]);
            }
             */
            //vypis cez switch
            switch (pole[j]) {
                case (10):
                    System.out.print("A");
                    break;
                case (11):
                    System.out.print("B");
                    break;
                case (12):
                    System.out.print("C");
                    break;
                case (13):
                    System.out.print("D");
                    break;
                case (14):
                    System.out.print("E");
                    break;
                case (15):
                    System.out.print("F");
                    break;
                default:
                    System.out.print(pole[j]);
            }
        }
    }

    public void convertFromBinToDec(int cislo) {
        int dlzka = 0;
        int pomocneCislo = cislo;
        int vysledok = 0;
        //zisti velkost pola
        while (pomocneCislo != 0) {
            pomocneCislo = pomocneCislo / 10;
            dlzka++;
        }
        int[] pole = new int[dlzka];
        //ulozi do pola cisla na kazdy index jedno cislo
        for (int i = 0; i < dlzka; i++) {
            pole[i] = cislo % 10;
            cislo = cislo / 10;
        }
        //od zadu pola robim mocniny
        for (int i = dlzka - 1; i >= 0; i--) {
            vysledok = vysledok + pole[i] * (int) Math.pow(2, i);
        }
        System.out.println("Hodnota je: " + vysledok);
    }

    public void convertFromOctToDec(int cislo) {
        int dlzka = 0;
        int pomocneCislo = cislo;
        int vysledok = 0;
        //zisti velkost pola
        while (pomocneCislo != 0) {
            pomocneCislo = pomocneCislo / 10;
            dlzka++;
        }
        int[] pole = new int[dlzka];
        //ulozi do pola cisla na kazdy index jedno cislo
        for (int i = 0; i < dlzka; i++) {
            pole[i] = cislo % 10;
            cislo = cislo / 10;
        }
        //od zadu pola robim mocniny
        for (int i = dlzka - 1; i >= 0; i--) {
            vysledok = vysledok + pole[i] * (int) Math.pow(8, i);
        }
        System.out.println("Hodnota je: " + vysledok);
    }

    public void convertFromHexToDec(String retazec) {
        //System.out.println("Testovanie " + retazec);
        int dlzka = retazec.length();
        int vysledok = 0;
        int j = 0;

        for (int i = dlzka - 1; i >= 0; i--) {
            if (retazec.charAt(i) == '0') {
                vysledok = vysledok + 0 * (int) Math.pow(16, j);
            } else if (retazec.charAt(i) == '1') {
                vysledok = vysledok + 1 * (int) Math.pow(16, j);
            } else if (retazec.charAt(i) == '2') {
                vysledok = vysledok + 2 * (int) Math.pow(16, j);
            } else if (retazec.charAt(i) == '3') {
                vysledok = vysledok + 3 * (int) Math.pow(16, j);
            } else if (retazec.charAt(i) == '4') {
                vysledok = vysledok + 4 * (int) Math.pow(16, j);
            } else if (retazec.charAt(i) == '5') {
                vysledok = vysledok + 5 * (int) Math.pow(16, j);
            } else if (retazec.charAt(i) == '6') {
                vysledok = vysledok + 6 * (int) Math.pow(16, j);
            } else if (retazec.charAt(i) == '7') {
                vysledok = vysledok + 7 * (int) Math.pow(16, j);
            } else if (retazec.charAt(i) == '8') {
                vysledok = vysledok + 8 * (int) Math.pow(16, j);
            } else if (retazec.charAt(i) == '9') {
                vysledok = vysledok + 9 * (int) Math.pow(16, j);
            } else if (retazec.charAt(i) == 'A') {
                vysledok = vysledok + 10 * (int) Math.pow(16, j);
            } else if (retazec.charAt(i) == 'B') {
                vysledok = vysledok + 11 * (int) Math.pow(16, j);
            } else if (retazec.charAt(i) == 'C') {
                vysledok = vysledok + 12 * (int) Math.pow(16, j);
            } else if (retazec.charAt(i) == 'D') {
                vysledok = vysledok + 13 * (int) Math.pow(16, j);
            } else if (retazec.charAt(i) == 'E') {
                vysledok = vysledok + 14 * (int) Math.pow(16, j);
            } else if (retazec.charAt(i) == 'F') {
                vysledok = vysledok + 15 * (int) Math.pow(16, j);
            }
            j++;
        }
        System.out.println("Hodnota je: " + vysledok);
    }

    public boolean isHexadecimalNumber(String value){
        int dlzka = value.length();
        value = value.toLowerCase();
        char znak;
        int pocitadlo = 0;
        for(int i = 0; i < dlzka; i++){
            znak = value.charAt(i);
            if(znak == '0' || znak == '1' || znak == '2' || znak == '3' || znak == '4' ||
                    znak == '5' || znak == '6' || znak == '7' || znak == '8' || znak == '9' ||
                    znak == 'a' ||znak == 'b' || znak == 'c' || znak == 'd' || znak == 'e' ||
                    znak == 'f'){
                continue;
            }else{
                pocitadlo++;
            }
        }
        if(pocitadlo > 0){
            return false;
        }else {
            return true;
        }
    }

    public boolean isBinaryNumber(String value){
        int dlzka = value.length();
        value = value.toLowerCase();
        char znak;
        int pocitadlo = 0;
        for(int i = 0; i < dlzka; i++){
            znak = value.charAt(i);
            if(znak == '0' || znak == '1'){
                continue;
            }else{
                pocitadlo++;
            }
        }
        if(pocitadlo > 0){
            return false;
        }else {
            return true;
        }
    }

    public boolean isOctalNumber(String value){
        int dlzka = value.length();
        value = value.toLowerCase();
        char znak;
        int pocitadlo = 0;
        for(int i = 0; i < dlzka; i++){
            znak = value.charAt(i);
            if(znak == '0' || znak == '1' || znak == '2' || znak == '3' || znak == '4' ||
                    znak == '5' || znak == '6' || znak == '7'){
                continue;
            }else{
                pocitadlo++;
            }
        }
        if(pocitadlo > 0){
            return false;
        }else {
            return true;
        }
    }

    public int[] getArray(int[] inPole){
        int dlzka = inPole.length;
        int velkost = 0;
        for(int i = 0; i < dlzka; i++){
            if(inPole[i]%2 == 0){
                velkost++;
            }
        }
        int[] outPole = new int[velkost];
        int j = 0;
        for(int i = 0; i < dlzka; i++){
            if(inPole[i]%2 == 0){
                outPole[j] = inPole[i];
                j++;
            }
        }
        return outPole;
    }


    ///metody s retazcom
    public void countInfinity() {
        Scanner sc = new Scanner(System.in);
        int cislo;
        int sucet = 0;
        int pamataPredchadzajuce = 0;
        while (true) {
            System.out.println("Zadaj cislo: ");
            cislo = sc.nextInt();
            if (cislo != 0 && cislo != pamataPredchadzajuce) {
                sucet = sucet + cislo;
            } else {
                break;
            }
            pamataPredchadzajuce = cislo;
            System.out.println("Zadaj cislo: ");
            cislo = sc.nextInt();
            if (cislo != pamataPredchadzajuce && cislo != 0) {
                sucet = sucet + cislo;
            } else {
                break;
            }
            pamataPredchadzajuce = cislo;
        }
        System.out.println("Zadal si 0 alebo dve hodnoty rovnake po sebe");
        System.out.println("Sucet cisel je: " + sucet);
    }

    public void vypisemOdZadu(String retazec) {
        int dlzka = retazec.length();
        String reverz = "";
        for (int i = dlzka - 1; i >= 0; i--) {
            reverz = reverz + retazec.charAt(i);
        }
        System.out.println("Opacny retazec je: " + reverz);
    }

    public void zistiPocetSamohlasok() {
        String data = " Procedural programming is about writing procedures or methods that perform operations on the data, while object-oriented programming is about creating objects that contain both data and methods. ";
        int dlzka = data.length();
        char znak;
        int pocet = 0;
        for (int i = 0; i < dlzka; i++) {
            znak = data.charAt(i);
            if (znak == 'a' || znak == 'A' || znak == 'á' || znak == 'Á') {
                pocet++;
            } else if (znak == 'e' || znak == 'E' || znak == 'é' || znak == 'É') {
                pocet++;
            } else if (znak == 'i' || znak == 'I' || znak == 'í' || znak == 'Í') {
                pocet++;
            } else if (znak == 'o' || znak == 'O' || znak == 'ó' || znak == 'Ó') {
                pocet++;
            } else if (znak == 'u' || znak == 'U' || znak == 'ú' || znak == 'Ú') {
                pocet++;
            } else if (znak == 'ä' || znak == 'Ä') {
                pocet++;
            } else if (znak == 'y' || znak == 'Y' || znak == 'ý' || znak == 'Ý') {
                pocet++;
            }
        }
        System.out.println("Pocet je: " + pocet);
    }


}
