package sk.kosickaakademia.nebus.hra.piskorky;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //uvod k hre
        System.out.println("-----Ahoj v hre piskorky-----");
        System.out.println("Dohodni sa so spoluhracom aky rozmer pola chces hrat!!!");
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Zadaj rozmer pola bude to stvorec. Zadaj jedno cislo, " +
                "ktore predstavuje dlzku strany");

        int dlzka = scanner1.nextInt();

        System.out.println("Mozes zadavat indexi od 0 do " + (dlzka-1));

        //vytvorime mapu o rozmere dlzka*dlzka
        Mapa mapa = new Mapa(dlzka,dlzka);

        //vytvorime hraca 1 a 2
        System.out.println("Hrac1 zadaj svoje meno: ");
        Scanner scanner2 = new Scanner(System.in);
        String menoHrac1 = scanner2.nextLine();
        Hrac hrac1 = new Hrac(menoHrac1);

        System.out.println("Hrac2 zadaj svoje meno: ");
        String menoHrac2 = scanner2.nextLine();
        Hrac hrac2 = new Hrac(menoHrac2);

        //predstavi kto bude pouzivat znak o a kto  znak x
        hrac1.vypisUvod(hrac1, hrac2);

        //hra
        while(true){
            mapa.hrajHruHrac1(hrac1);
            mapa.vykresliMapu();
            if(mapa.overHrac1() == true){
                System.out.println("Vyhral hrac " + hrac1.getMeno());
                System.out.println("Gratulujem!!!");
                break;
            }
            if(mapa.overCiJeKdeZapisovat() == false){
                System.out.println("Nikto nevyhral a nie je miesto na zapisovanie");
                System.out.println("Remiza!!!");
                break;
            }

            mapa.hrajHruHrac2(hrac2);
            mapa.vykresliMapu();
            if(mapa.overHrac2() == true){
                System.out.println("Vyhral hrac " + hrac2.getMeno());
                System.out.println("Gratulujem!!!");
                break;
            }
            if(mapa.overCiJeKdeZapisovat() == false){
                System.out.println("Nikto nevyhral a nie je miesto na zapisovanie");
                System.out.println("Remiza!!!");
                break;
            }
        }

    }
}
