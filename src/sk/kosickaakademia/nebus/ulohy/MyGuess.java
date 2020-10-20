package sk.kosickaakademia.nebus.ulohy;

import java.util.Scanner;
/**
 * Toto je trieda MyGuess tu je ulozena
 * metoda na hadanie cisla
 */
public class MyGuess {

    public void guessNumber(){
        Scanner sc = new Scanner(System.in);
        int PCcislo = (int)(Math.random()*100+1);
        int cislo;

        System.out.println("Hadaj cislo od 1 do 100");
        do {
            System.out.println("Zadaj cislo: ");
            cislo = sc.nextInt();
            if(cislo==PCcislo){
                System.out.println("Vyhral si!!!");
            }else if(cislo<PCcislo){
                System.out.println("PC si mysli vacsie cislo");
            }else{
                System.out.println("PC si mysli mensie cislo");
            }
        }while (cislo != PCcislo);
    }
}
