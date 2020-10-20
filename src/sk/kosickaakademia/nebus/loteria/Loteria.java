package sk.kosickaakademia.nebus.loteria;

import java.util.Random;
import java.util.Scanner;

public class Loteria {
    int[] tip = new int[5];
    int[] zreb = new int[10];

    public static void main(String[] args) {
        Loteria loteria = new Loteria();
        //1
        loteria.zadajCisla();
        //2
        loteria.randomPC();
        //3
        loteria.kolkoSaZhoduje();
    }

    public void zadajCisla(){
        Scanner sc = new Scanner(System.in);
        int cislo;
        int i = 0;
        while(true){
            System.out.println("Zadaj " + (i+1) + ". cislo");
            cislo = sc.nextInt();
            if(cislo > 0 && cislo < 21 && nachadzaSa(cislo)){
                tip[i] = cislo;
                i++;
                if(i == 5){
                    break;
                }
            }
        }
        System.out.println();
        System.out.println("Zadal si tieto cisla: ");
        for(i = 0; i < tip.length; i++){
            System.out.print(tip[i] + " ");
        }
    }

    public boolean nachadzaSa(int cislo){
        int pocitadlo = 0;

        for(int i = 0; i < tip.length; i++){
            if(tip[i] == cislo){
                pocitadlo++;
            }
        }
        if(pocitadlo == 0){
            return true;
        }else{
            return false;
        }
    }

    public void randomPC(){
        int cislo;
        int i = 0;

        while(true){
            cislo = (int)(Math.random()*20+1);
            if(overCisloPC(cislo)){
                zreb[i] = cislo;
                i++;
            }
            if(i == 10){
                break;
            }
        }
        System.out.println();
        System.out.println("Cisla PC su: ");
        for (i = 0; i < zreb.length; i++){
            System.out.print(zreb[i] + " ");
        }
    }

    public boolean overCisloPC(int cislo){
        int pocitadlo = 0;

        for(int i = 0; i < zreb.length; i++){
            if(zreb[i] == cislo){
                pocitadlo++;
            }
        }
        if(pocitadlo == 0){
            return true;
        }else{
            return false;
        }
    }

    public void kolkoSaZhoduje(){
        int pocitadlo = 0;
        for(int i = 0; i < tip.length; i++){
            for(int j = 0; j < zreb.length; j++){
                if(tip[i] == zreb[j]){
                    pocitadlo++;
                }
            }
        }
        System.out.println();
        System.out.println("Uhadol si: " +pocitadlo+ " cisel!");
    }
}
