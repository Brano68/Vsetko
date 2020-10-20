package sk.kosickaakademia.nebus.loteria;

import java.util.Random;
import java.util.Scanner;

public class Loteria {
    private final int TIP_CISLO = 5;
    private final int ZREB_CISLO = 10;
    private final int MAXIMUM = 20;

    private int[] tip = new int[TIP_CISLO];
    private int[] zreb = new int[ZREB_CISLO];

    public static void main(String[] args) {

        Loteria loteria = new Loteria();

        //0
        int vklad = loteria.zadajVklad();
        //1
        System.out.println("Chces zadat svoje cisla ty tak stalc 1 ak ich ma " +
                "vygenerovat PC stlac 2");
        Scanner sc = new Scanner(System.in);
        int cislo = sc.nextInt();
        if(cislo == 1){
            loteria.zadajCisla();
        }else{
            loteria.randomPcForUser();
        }
        //2
        loteria.randomPC();
        //3
        int uhadnuteCisla = loteria.kolkoSaZhoduje();
        //4
        loteria.vypisVyhru(vklad, uhadnuteCisla);
    }

    public int zadajVklad(){
        int vklad;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Zadaj vklad: ");
            vklad = sc.nextInt();
        }while(vklad <= 0);
        return vklad;
    }

    public void zadajCisla(){
        Scanner sc = new Scanner(System.in);
        int cislo;
        int i = 0;
        while(true){
            System.out.println("Zadaj " + (i+1) + ". cislo");
            cislo = sc.nextInt();
            if(cislo > 0 && cislo < MAXIMUM+1 && nachadzaSa(cislo)){
                tip[i] = cislo;
                i++;
                if(i == TIP_CISLO){
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

    public void randomPcForUser(){
        int cislo;
        int i = 0;

        while(true){
            cislo = (int)(Math.random()*MAXIMUM+1);
            if(nachadzaSa(cislo)){
                tip[i] = cislo;
                i++;
            }
            if(i == TIP_CISLO){
                break;
            }
        }
        System.out.println();
        System.out.println("Tvoje cisla vygenerovane PC su: ");
        for (i = 0; i < tip.length; i++){
            System.out.print(tip[i] + " ");
        }
    }

    public void randomPC(){
        int cislo;
        int i = 0;

        while(true){
            cislo = (int)(Math.random()*MAXIMUM+1);
            if(overCisloPC(cislo)){
                zreb[i] = cislo;
                i++;
            }
            if(i == ZREB_CISLO){
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

    public int kolkoSaZhoduje(){
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
        return pocitadlo;
    }

    public void vypisVyhru(int vklad, int uhadnuteCisla){
        switch (uhadnuteCisla){
            case (0):
                System.out.println("Vyhral si 0 €");
                break;
            case (1):
                System.out.println("Vyhral si 0 €");
                break;
            case (2):
                System.out.println("Vyhral si " + vklad*2 + "€");
                break;
            case (3):
                System.out.println("Vyhral si " + vklad*15 + "€");
                break;
            case (4):
                System.out.println("Vyhral si " + vklad*500 + "€");
                break;
            case (5):
                System.out.println("Vyhral si " + vklad*10000 + "€");
                break;
        }
    }
}
