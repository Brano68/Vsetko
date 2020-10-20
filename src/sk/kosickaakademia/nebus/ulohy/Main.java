package sk.kosickaakademia.nebus.ulohy;

import java.util.Scanner;
/**
 * Toto je trieda Main a v nej je vytvoreny objekt
 * converter cez ktoreho volam metody z triedy Converter.java
 */


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Converter converter = new Converter();
        int volba, cislo;
        String retazec;

        do {
            System.out.println("-----PREVOD SUSTAV-----");
            System.out.println("Zadaj co chces urobit (stlac 1, 2 - 12)");
            System.out.println("1: Prevod do dvojkovej");
            System.out.println("2: Prevod do osmickovej");
            System.out.println("3: Prevod do sesnastkovej");
            System.out.println("4: Prevod z dvojkovej do desiatkovej");
            System.out.println("5: Prevod z osmickovej do desiatkovej");
            System.out.println("6: Prevod zo sesnastkovej do desiatkovej");
            System.out.println(("7: Nekonecny cyklus na vypocet suctu"));
            System.out.println(("8: Napisem retazec od zadu"));
            System.out.println(("9: Zisti pocet samohlasok"));
            System.out.println(("10: Zisti ci to je hexa cislo"));
            System.out.println(("11: Zisti ci to je binarne cislo"));
            System.out.println(("12: Zisti ci to je octa cislo"));
            System.out.println(("13: Prekopiruj kladne cisla z pola do druheho pola"));
            System.out.println(("14: HRA - hadaj cislo"));
            System.out.println(("15: Preskusaj sa v nasobilke"));
            System.out.println(("16: Daj na zakladny tvar zlomok"));
            System.out.println(("17: Pocet odrazov"));
            System.out.println(("18: Skracuje retazec"));
            System.out.println(("19: Vypise cisla delitelne 91"));
            System.out.println(("20: Urob sucet 1 + 1/2 + 1/3 + ... + 1/100"));
            System.out.println(("21: KENO 10"));
            System.out.println(("22: ASCII"));
            System.out.println(("23: Zisti IP adresu"));
            System.out.println(("24: Text analyzer"));
            System.out.println(("25: Cezar sifra"));

            volba = sc.nextInt();
        } while (volba < 1 || volba > 25);

        switch (volba) {
            case (1):
                System.out.println("Zadaj cislo ktore chces previest: ");
                cislo = sc.nextInt();
                converter.convertToBinary(cislo);
                break;
            case (2):
                System.out.println("Zadaj cislo ktore chces previest: ");
                cislo = sc.nextInt();
                converter.convertToOcta(cislo);
                break;
            case (3):
                System.out.println("Zadaj cislo ktore chces previest: ");
                cislo = sc.nextInt();
                converter.convertToHexa(cislo);
                break;
            case (4):
                System.out.println("Zadaj cislo ktore chces previest: ");
                cislo = sc.nextInt();
                converter.convertFromBinToDec(cislo);
                break;
            case (5):
                System.out.println("Zadaj cislo ktore chces previest: ");
                cislo = sc.nextInt();
                converter.convertFromOctToDec(cislo);
                break;
            case (6):
                System.out.println("Zadaj cislo ktore chces previest: ");
                Scanner in = new Scanner(System.in);
                retazec = in.nextLine();
                converter.convertFromHexToDec(retazec);
                break;
            case (7):
                converter.countInfinity();
                break;
            case (8):
                System.out.println("Zadaj retazec a napisem ho odzadu: ");
                Scanner inS = new Scanner(System.in);
                retazec = inS.nextLine();
                converter.vypisemOdZadu(retazec);
                break;
            case (9):
                converter.zistiPocetSamohlasok();
                break;
            case(10):
                System.out.println("Zadaj cislo: ");
                Scanner inH = new Scanner(System.in);
                retazec = inH.nextLine();
                boolean hodnota = converter.isHexadecimalNumber(retazec);
                if(hodnota == true){
                    System.out.println("Je to HEXA cislo");
                }else{
                    System.out.println("Nie je to HEXA cislo");
                }
                break;
            case(11):
                System.out.println("Zadaj cislo: ");
                Scanner inB = new Scanner(System.in);
                retazec = inB.nextLine();
                hodnota = converter.isBinaryNumber(retazec);
                if(hodnota == true){
                    System.out.println("Je to Binary cislo");
                }else{
                    System.out.println("Nie je to Binary cislo");
                }
                break;
            case(12):
                System.out.println("Zadaj cislo: ");
                Scanner inO = new Scanner(System.in);
                retazec = inO.nextLine();
                hodnota = converter.isOctalNumber(retazec);
                if(hodnota == true){
                    System.out.println("Je to Octa cislo");
                }else{
                    System.out.println("Nie je to Octa cislo");
                }
                break;
            case(13):
                int[] pole = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
                        18, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37,
                        38, 39, 40};
                int[] novePole = converter.getArray(pole);
                int dlzka = novePole.length;
                for(int i = 0; i < dlzka; i++){
                    System.out.print(" " + novePole[i]);
                }
                break;
            case(14):
                System.out.println("VYTAJTE V HRE hadania cisla");
                MyGuess myGuess = new MyGuess();
                myGuess.guessNumber();
                break;
            case(15):
                MyMultiplier myMultiplier = new MyMultiplier();
                System.out.println("Preskusaj sa v nasobilke!!!");
                Scanner nacitaj = new Scanner(System.in);
                System.out.println("Do akeho maximalneho cisla ta mozem skusat?");
                int scan = nacitaj.nextInt();
                myMultiplier.nasobilka(scan);
                break;
            case(16):
                MyHomework my1Homework = new MyHomework();
                my1Homework.zakladnyTvar(110,150);
                break;
            case(17):
                MyHomework my2Homework = new MyHomework();
                System.out.println("Pocet odrazov je: " + my2Homework.pocetOdrazov(200,0.9));
                break;
            case(18):
                MyHomework my3Homework = new MyHomework();
                my3Homework.skracujRetazecOdPredu("SKOLA");
                break;
            case(19):
                MyHomework my4Homework = new MyHomework();
                my4Homework.vypisCislaDelitelne();
                break;
            case(20):
                MyHomework my5Homework = new MyHomework();
                my5Homework.urobSucet();
                break;
            case(21):
                MyHomework my6Homework = new MyHomework();
                my6Homework.keno();
                break;
            case(22):
                MyHomework my7Homework = new MyHomework();
                my7Homework.vypisZnakov();
                break;
            case(23):
                MyHomework my8Homework = new MyHomework();
                my8Homework.zistiIP();
                break;
            case(24):
                MyHomework my9Homework = new MyHomework();
                my9Homework.textAnalyser("Ahoj 455? 98 ako sa mame? 887");
                break;
            case(25):
                MyHomework my10Homework = new MyHomework();
                my10Homework.cezarSifra("Ahoj 255");
                break;

        }
    }
}
