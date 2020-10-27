package sk.kosickaakademia.nebus.tic.tac.toe.x;
/**
Hra pre troch hraov jeden zadava 1 druhy 2 a treti 3
 napriklad ak pole ma 5x5 tak o jedno menej v riadku
 v uhlopriecke alebo stlpci ak sa nachadzaju znaky
 ktore patria danemu hracovi tak vyjrava.
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //predstavenie hry
        System.out.println("Vytajte v hre piskorky");
        System.out.println("Hra je urcena pre 3 osoby");
        System.out.println("Na zaciatku sa dohodnite aky velky rozmer mapy chcete");
        System.out.println("Bude to stvorec a vitaz je ten kto ma v rade alebo v stlpci");
        System.out.println("alebo v uhlopriecke pocet prislusnych symbolov mensi o jedna");
        System.out.println("ako je rozmer pola!!!");
        //ake velke pole
        Scanner sc = new Scanner(System.in);
        int dlzka = sc.nextInt();

        //vytvor mapu
        Mapa mapa = new Mapa(dlzka);

        //vytvorenie hracov
        Scanner scanner = new Scanner(System.in);
        String meno;
        System.out.println("Hrac 1 zadaj svoje meno: ");
        meno = scanner.nextLine();
        Hrac hrac1 = new Hrac(meno);

        System.out.println("Hrac 2 zadaj svoje meno: ");
        meno = scanner.nextLine();
        Hrac hrac2 = new Hrac(meno);

        System.out.println("Hrac 3 zadaj svoje meno: ");
        meno = scanner.nextLine();
        Hrac hrac3 = new Hrac(meno);

        //predstav hracov
        hrac1.zoznamHracov(hrac1,hrac2,hrac3);

        //slucka hry

        while(true){
            //vykresli mapu
            mapa.vykresliMapu();
            //overi ci je volne miesto
            if(mapa.overCiJeKdeZapisovat() == false){
                System.out.println("REMIZA!!!");
                break;
            }
            //vyzve prveho hraca
            System.out.println(hrac1.getMeno() + " - hrac 1 ides!!!");
            mapa.hrajHrac1();
            //overi ci hrac1 nevyhral
            if(mapa.overHraca1Prvypripad() == true || mapa.overHraca1Druhypripad()
            || mapa.overHraca1Tretipripad() == true || mapa.overHraca1Stvrtypripad()){
                mapa.vykresliMapu();
                System.out.println("Vyhral hrac: " + hrac1.getMeno());
                break;
            }

            //priestor pre druheho hraca

            mapa.vykresliMapu();
            //overi ci je volne miesto
            if(mapa.overCiJeKdeZapisovat() == false){
                System.out.println("REMIZA!!!");
                break;
            }

            //vyzve druheho hraca
            System.out.println(hrac2.getMeno() + " - hrac 2 ides!!!");
            mapa.hrajHrac2();
            //overi ci hrac2 nevyhral
            if(mapa.overHraca2Prvypripad() == true || mapa.overHraca2Druhypripad()
                    || mapa.overHraca2Tretipripad() == true || mapa.overHraca2Stvrtypripad()){
                mapa.vykresliMapu();
                System.out.println("Vyhral hrac: " + hrac2.getMeno());
                break;
            }

            //priestor pre tretieho hraca
            mapa.vykresliMapu();
            if(mapa.overCiJeKdeZapisovat() == false){
                System.out.println("REMIZA!!!");
                break;
            }

            //vyzve tretieho hraca
            System.out.println(hrac3.getMeno() + " - hrac 3 ides!!!");
            mapa.hrajHrac3();
            //overi ci hrac3 nevyhral
            if(mapa.overHraca3Prvypripad() == true || mapa.overHraca3Druhypripad()
                    || mapa.overHraca3Tretipripad() == true || mapa.overHraca3Stvrtypripad()){
                mapa.vykresliMapu();
                System.out.println("Vyhral hrac: " + hrac3.getMeno());
                break;
            }
            if(mapa.overCiJeKdeZapisovat() == false){
                System.out.println("REMIZA!!!");
                break;
            }

        }

    }
}
