package sk.kosickaakademia.nebus.ulohy;

public class MyHomework {

    public int pocetOdrazov(double vyskaCm, double koeficientOdrazu) {
        double aktualnaVyska = vyskaCm;
        int pocitadlo = 0;

        while (aktualnaVyska > 100) {
            aktualnaVyska = aktualnaVyska * koeficientOdrazu;
            pocitadlo++;
        }
        return pocitadlo;
    }

    public void zakladnyTvar(int citatel, int menovatel) {
        if (citatel == menovatel) {
            System.out.println("Zakladny tvar je: 1/1");
        } else if (citatel < menovatel) {
            for (int i = citatel; i > 0; i--) {
                if (menovatel % i == 0 && citatel % i == 0) {
                    citatel = citatel / i;
                    menovatel = menovatel / i;
                }
            }
            System.out.println("Zakladny tvar je: " + citatel + "/" + menovatel);
        } else if (menovatel < citatel) {
            for (int i = menovatel; i > 0; i--) {
                if (citatel % i == 0 && menovatel % i == 0) {
                    citatel = citatel / i;
                    menovatel = menovatel / i;
                }
            }
            System.out.println("Zakladny tvar je: " + citatel + "/" + menovatel);
        }


    }

    ////1uloha
    public void skracujRetazecOdPredu(String retazec) {
        int dlzka = retazec.length();
        for (int i = 0; i < dlzka; i++) {
            for (int j = i; j < dlzka; j++) {
                System.out.print(retazec.charAt(j));
            }
            System.out.println();
        }
    }


    ////2uloha
    //2. Vypiste vsetky cisla 8X75Y2, kde X a Y nahradite cislicami tak,
    //aby zadane cislo bolo delitelne cislom 91.
    public void vypisCislaDelitelne() {
        String retazec1 = "8X75Y2";
        //int cislo = 1;
        char[] pole = new char[retazec1.length()];
        String cisloRetazcove = "";
        int cisloMatematicke;
        int pocitadlo = 0;

        for (int i = 0; i < retazec1.length(); i++) {
            pole[i] = retazec1.charAt(i);
        }

        for (int i = 0; i < 10; i++) {
            pole[1] = (char) (i + 48); //cislo 48dekadicke je char NULA a k nej sa pripocitava postupne 1
            for (int j = 0; j < 10; j++) {
                pole[4] = (char) (j + 48);
                for (int k = 0; k < retazec1.length(); k++) {
                    ///System.out.print(pole[k]);
                    cisloRetazcove = cisloRetazcove + pole[k];
                }
                ///System.out.println();
                cisloMatematicke = Integer.valueOf(cisloRetazcove);
                //System.out.println(cisloMatematicke);
                if (cisloMatematicke % 91 == 0) {
                    System.out.println(cisloMatematicke);
                    pocitadlo++;
                }
                cisloRetazcove = "";
            }
        }
        if (pocitadlo == 0) {
            System.out.println("Take cislo neexistuje");
        }
    }


    ////3uloha
    public void urobSucet() {
        double sucet = 0;
        for (int i = 1; i <= 100; i++) {
            sucet = sucet + 1.0 / i;
        }
        System.out.println("Sucet je: " + sucet);
    }


    ////4uloha KENO
    public void keno() {
        int[] keno = new int[20];
        int nahCislo;
        int pocet = 0;

        for (int i = 0; i < keno.length; i++) {
            while (true) {
                nahCislo = (int) (Math.random() * 80 + 1);
                for (int j = 0; j < keno.length; j++) {
                    if (keno[j] == nahCislo) {
                        pocet++;
                    }
                }
                if (pocet == 0) {
                    keno[i] = nahCislo;
                    break;
                }
                pocet = 0;
            }
        }
        System.out.println("Keno cislo je: ");
        for (int i = 0; i < keno.length; i++) {
            System.out.print(keno[i] + " ");
        }
    }

    ///5opytat
    /*
    public void vypis(){
        String retazec = "AHOJ";
        char znak = retazec.charAt(1);
        //pri retazci to hlasi chybu
        //retazec.charAt(1) = '5';
        //pri poli to ide
        char[] pole = new char[5];
        pole[1] = 'A';
    }
     */

    public void vypisZnakov() {
        for (int i = 32; i <= 127; i++) {
            System.out.println(i + ":" + (char) i);
        }

        String retazec = "Kosice2020";
        String kodovanyRetazec = "";
        char[] pole = retazec.toCharArray();
        for (int i = 0; i < retazec.length(); i++) {
            pole[i] = (char) (pole[i] + 5);
        }
        kodovanyRetazec = String.valueOf(pole);
        System.out.println(kodovanyRetazec);
    }


    public void zistiIP() {
        String IP = "1.2.3.4";
        char[] pole = IP.toCharArray();
        int pocitadlo = 0;
        String cast1 = "";
        String cast2 = "";
        String cast3 = "";
        String cast4 = "";
        for (int i = 0; i < IP.length(); i++) {
            pocitadlo++;
            if (pole[i] == '.') {
                break;
            }
            cast1 = cast1 + pole[i];
        }
        int cast1cislo = Integer.parseInt(cast1);

        for (int i = pocitadlo; i < IP.length(); i++) {
            pocitadlo++;
            if (pole[i] == '.') {
                break;
            }
            cast2 = cast2 + pole[i];
        }
        int cast2cislo = Integer.parseInt(cast2);

        for (int i = pocitadlo; i < IP.length(); i++) {
            pocitadlo++;
            if (pole[i] == '.') {
                break;
            }
            cast3 = cast3 + pole[i];
        }
        int cast3cislo = Integer.parseInt(cast3);

        for (int i = pocitadlo; i < IP.length(); i++) {
            pocitadlo++;
            if (pole[i] == '.') {
                break;
            }
            cast4 = cast4 + pole[i];
        }
        int cast4cislo = Integer.parseInt(cast4);

        System.out.print(cast1cislo + " " + cast2cislo + " " + cast3cislo + " " + cast4cislo);

        if ((cast1cislo >= 0 && cast1cislo <= 255) && (cast2cislo >= 0 && cast2cislo <= 255) &&
                (cast3cislo >= 0 && cast3cislo <= 255) && (cast4cislo >= 0 && cast4cislo <= 255)) {
            System.out.println("Moze to byt IP adresa");
        } else {
            System.out.println("Nemoze to byt IP adresa");
        }
    }

    public void textAnalyser(String text) {
        int dlzka = text.length();
        int pocetCisel = 0;
        int pocetVelkychPismen = 0;
        int pocetMalychPismen = 0;
        int pocetMedzier = 0;
        int pocetViet = 0;

        for (int i = 0; i < dlzka; i++) {
            if (text.charAt(i) >= '0' && text.charAt(i) <= '9') {
                pocetCisel++;
            }
            if (text.charAt(i) >= 'a' && text.charAt(i) <= 'z') {
                pocetMalychPismen++;
            }
            if (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z') {
                pocetVelkychPismen++;
            }
            if (text.charAt(i) == ' ') {
                pocetMedzier++;
            }
            if (text.charAt(i) == '.' || text.charAt(i) == '?' || text.charAt(i) == '!') {
                pocetViet++;
            }
        }
        System.out.println("Pocet malych pismen: " + pocetMalychPismen);
        System.out.println("Pocet velkych pismen: " + pocetVelkychPismen);
        System.out.println("Pocet cisel: " + pocetCisel);
        System.out.println("Pocet viet: " + pocetViet);
        System.out.println("Pocet medzier: " + pocetMedzier);
    }

    public void cezarSifra(String text) {
        String cezarText = "";

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) >= 'a' && text.charAt(i) <= 'w') {
                cezarText = cezarText + (char) (text.charAt(i) + 3);
            } else if (text.charAt(i) == 'x') {
                cezarText = cezarText + "a";
            } else if (text.charAt(i) == 'y') {
                cezarText = cezarText + "b";
            } else if (text.charAt(i) == 'z') {
                cezarText = cezarText + "c";
            } else if (text.charAt(i) >= 'A' && text.charAt(i) <= 'W') {
                cezarText = cezarText + (char) (text.charAt(i) + 3);
            } else if (text.charAt(i) == 'X') {
                cezarText = cezarText + "A";
            } else if (text.charAt(i) == 'Y') {
                cezarText = cezarText + "B";
            } else if (text.charAt(i) == 'Z') {
                cezarText = cezarText + "C";
            } else if (text.charAt(i) >= '1' && text.charAt(i) <= '6') {
                cezarText = cezarText + (char) (text.charAt(i) + 3);
            } else if (text.charAt(i) == '7') {
                cezarText = cezarText + "1";
            } else if (text.charAt(i) == '8') {
                cezarText = cezarText + "2";
            } else if (text.charAt(i) == '9') {
                cezarText = cezarText + "3";
            } else{
                cezarText = cezarText + text.charAt(i);
            }
        }
        System.out.println("Cezerova sifra je: " + cezarText + "a povodna je: " + text);
    }
}
