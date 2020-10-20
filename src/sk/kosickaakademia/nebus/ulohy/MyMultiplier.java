package sk.kosickaakademia.nebus.ulohy;

import java.util.Scanner;

/**
 * Toto je trieda MyMultiplier je tu metoda nasobilka
 *pre
 */

public class MyMultiplier {

    public void nasobilka(int max){
        Scanner sc = new Scanner(System.in);
        int a, b, vysledok, odpoved;
        int pocitadlo = 0;

        System.out.println("Budes testovany na 10tich prikladoch na konci sa dozvies % vysledok");

        for(int i = 0; i < 10; i++){
            a = (int)(Math.random()*max+1);
            b = (int)(Math.random()*max+1);
            vysledok = a*b;
            System.out.println("Kolko je:" + a + "*" + b);
            odpoved = sc.nextInt();
            if(vysledok == odpoved){
                pocitadlo++;
            }
        }
        System.out.println("Tvoje percentualne hodnotenie je: " +(pocitadlo*10)+ "%");
    }
}
