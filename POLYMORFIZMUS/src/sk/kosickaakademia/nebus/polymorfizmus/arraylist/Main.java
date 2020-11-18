package sk.kosickaakademia.nebus.polymorfizmus.arraylist;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        ArrayList<String> pole = new ArrayList<>();
        pole.add("Janko");
        pole.add("Filip");
        pole.add("Milan");

        System.out.println("Pocet prvkov v poli: " + pole.size());
        System.out.println(pole.get(1));
        pole.remove(0);
        System.out.println(pole.get(1));
        try {
            System.out.println(pole.get(2));
        }catch (IndexOutOfBoundsException e){
            System.out.println("Nastala chyba: " + e);
        }


         */
        //Homework
        ArrayList<Integer> poleCisel = new ArrayList<>();
        System.out.println("Kolko cisel chces generovat: ");
        Scanner sc = new Scanner(System.in);
        int pocet = sc.nextInt();
        System.out.println("Ake cislo si myslis ze tam bude?");
        int tip = sc.nextInt();
        Random random = new Random();
        int cislo;
        for (int i = 0; i < pocet; i++) {
            cislo = random.nextInt(100); // od 0 do 99
            poleCisel.add(cislo);
        }
        if (poleCisel.contains(tip)) {
            System.out.println("Myslel si si spravne cislo " + tip + " sa v poli nachadza!!!");
        } else {
            System.out.println("Myslel si si nespravne cislo " + tip + " sa v poli nenachadza!!!");
        }
        System.out.println("Pole pozostava z tychto cisel: ");
        for (int i = 0; i < pocet; i++) {
            System.out.print(poleCisel.get(i) + " ");
        }
        System.out.println();
        hladajNajviacFrekventovaneCisloAleboCisla(poleCisel);
    }

    public static void hladajNajviacFrekventovaneCisloAleboCisla(ArrayList pole){
        int frekventovanie = 0;
        int maxFrekventovanie = 0;
        int skuska = 0;
        //vyriesenie frekventovania
        for(int i = 0; i < pole.size(); i++){
            int hodnotaIndexu = (int)pole.get(i);
            for(int j = 0; j < pole.size(); j++){
                if(hodnotaIndexu == (int)pole.get(j)){
                    frekventovanie++;
                }
            }
            if(frekventovanie>maxFrekventovanie){
                maxFrekventovanie = frekventovanie;
                //skuska = hodnotaIndexu;
            }
            frekventovanie = 0;
        }
        //System.out.println("Max frekventovanie " + maxFrekventovanie + " cislo " + skuska);

        ////
        ArrayList<Integer> vysledok = new ArrayList<>();

        for(int i = 0; i < pole.size(); i++){
            int hodnotaIndexu = (int)pole.get(i);
            for(int j = 0; j < pole.size(); j++){
                if(hodnotaIndexu == (int)pole.get(j)){
                    frekventovanie++;
                }
            }
            if(frekventovanie==maxFrekventovanie){
                //maxFrekventovanie = frekventovanie;
                //skuska = hodnotaIndexu;
                if(vysledok.contains(hodnotaIndexu) == false){
                    vysledok.add(hodnotaIndexu);
                }

            }
            frekventovanie = 0;
        }

        //
        System.out.println();
        System.out.println("Najfrekventovanejsie cisla opakujuce sa " + maxFrekventovanie + " krat su:");
        for(int i = 0; i < vysledok.size(); i++){
            System.out.print(vysledok.get(i) + " ");
        }
    }
}