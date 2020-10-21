package sk.kosickaakademia.nebus.game.guesscity;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class City {
    public static void main(String[] args) {
        City city = new City();
        city.play();
    }

    public String getRandomCity() {
        String[] array = new String[]{"Zvolen", "Bratislava", "Presov", "Poprad",
                "Michalovce"};
        Random rnd = new Random();
        int num = rnd.nextInt(array.length);
        return array[num];
    }

    public void play(){
        String city=getRandomCity().toUpperCase();
        int zivot = 3;
        String tip = "";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Mas tolko zivotov: " + zivot);


        while(zivot > 0) {
            System.out.println(napovedz(city));
            System.out.println("Zadaj odpoved: ");
            tip = scanner.nextLine();
            if (city.compareToIgnoreCase(tip) == 0){
                System.out.println("Vyhral si!!! a zostalo ti tolko " + zivot + " zivotov.");
                break;
            }else{
                zivot--;
            }
            if(zivot>0){
                System.out.println("Neuhadol si a mas tolko zivotov: " + zivot);
            }
            if(zivot==0){
                System.out.println("Prehral si!!!");
            }
        }
    }

    public String napovedz(String retazec){
        int dlzka = retazec.length();
        char[] pole = retazec.toCharArray();
        int[] cisla3 = new int[3];
        int pocitadlo = 0;

        Random random = new Random();
        int cislo;
        //vyplni pole znakmi _
        for(int i = 0; i < dlzka; i++){
            pole[i] = '_';
        }
        //do pola cisla3 sa ulozia 3 indexi od 0 po dlzku slova bez opakovania
        for(int i = 0; i < 3; i++){
            while(true) {
                cislo = random.nextInt(retazec.length());
                for(int j = 0; j < 3; j++){
                    if(cisla3[j] == cislo){
                        pocitadlo++;
                    }
                }
                if(pocitadlo == 0){
                    cisla3[i] = cislo;
                    pocitadlo = 0;
                    break;
                }
                pocitadlo = 0;
            }
        }

        //nahradime pole na mieste indexov pismenami
        for(int i = 0; i < 3; i++){
            int index = cisla3[i];
            pole[index] = retazec.charAt(index);
        }

        //prevedieme pole na retazec String ktory vratime
        String retazecPomocny = "";
        for(int i = 0; i < pole.length; i++){
            retazecPomocny = retazecPomocny + pole[i];
        }
        return retazecPomocny;
    }

}