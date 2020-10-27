package sk.kosickaakademia.nebus.tic.tac.toe.x;

import java.util.Scanner;

public class Mapa {
    private int[][] mapa;

    public Mapa(int dlzka){
        this.mapa = new int[dlzka][dlzka];
        //vynulujeme pole
        for(int i = 0; i < dlzka; i++){
            for(int j = 0; j < dlzka; j++){
                mapa[i][j] = 0;
            }
        }
    }

    public void vykresliMapu(){
        for(int i = 0; i < mapa.length; i++){
            for(int j = 0; j < mapa[0].length; j++){
                System.out.print(mapa[i][j]);
            }
            System.out.println();
        }
    }

    public int zadajPolickoKdeChcesPolozitZnak(){
        System.out.println("Od 1 do " + (mapa.length* mapa.length));
        Scanner sc = new Scanner(System.in);
        int cislo = sc.nextInt();
        return cislo;
    }

    public int zistiSuradnice(int cislo){
        int indexy = 0;
        int pocitadlo = 0;
        for(int i = 0; i < mapa.length; i++){
            for(int j = 0; j < mapa[0].length; j++){
                pocitadlo++;
                if(pocitadlo == cislo){
                    indexy = i*10+j;
                }
            }
        }
        return indexy;
    }

    public boolean overSuradnice(int suradnice){
        int riadok = suradnice/10;
        int stlpec = suradnice%10;
        if(mapa[riadok][stlpec] == 0){
            return true;
        }
        return false;
    }

    public void hrajHrac1(){
        while (true) {
            int policko = zadajPolickoKdeChcesPolozitZnak();
            int suradnice = zistiSuradnice(policko);
            int riadok = (suradnice / 10);
            int stlpec = (suradnice % 10);
            if (overSuradnice(suradnice) == true) {
                mapa[riadok][stlpec] = 1;
                break;
            }else{
                System.out.println("Pozicia nie je volna!!!");
            }
        }
    }

    public boolean overHraca1Prvypripad(){
        //pole treba overit ako keby v nom sa nachadzalo 4polia
        int pocitadlo = 0;
        //overenie pola lavy horny roh
        //riadky
        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                if(mapa[i][j] == 1){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
            pocitadlo = 0;
        }
        pocitadlo = 0;
        //stlpce
        for(int j = 0; j < mapa[0].length-1; j++){
            for(int i = 0; i < mapa.length-1; i++){
                if(mapa[i][j] == 1){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
            pocitadlo = 0;
        }
        pocitadlo = 0;
        //uhlopriecka
        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                if(i == j && mapa[i][j] == 1){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
        }

        pocitadlo = 0;

        //obratena uhlopriecka
        int[][] zrkadlovaMatica = new int[mapa.length-1][mapa[0].length-1];
        int k = mapa[0].length-2;
        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                zrkadlovaMatica[i][j] = mapa[i][k];
                k--;
            }
            k = mapa[0].length-2;
        }

        //overit obratenu maticu
        for(int i = 0; i < zrkadlovaMatica.length; i++){
            for(int j = 0; j < zrkadlovaMatica[0].length; j++){
                if(i == j && zrkadlovaMatica[i][j] == 1){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean overHraca1Druhypripad(){
        //pole treba overit ako keby v nom sa nachadzalo 4polia
        int pocitadlo = 0;
        //overenie pola lavy dolny roh
        //riadky
        for(int i = 1; i < mapa.length; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                if(mapa[i][j] == 1){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
            pocitadlo = 0;
        }
        pocitadlo = 0;
        //stlpce
        for(int j = 0; j < mapa[0].length-1; j++){
            for(int i = 1; i < mapa.length; i++){
                if(mapa[i][j] == 1){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
            pocitadlo = 0;
        }
        pocitadlo = 0;
        //uhlopriecka
        //ale treba zase kopirovat do pomocneho pola
        //lebo sa to posuva
        //a uz mi to robi problem
        //lebo na diagonale sa indexi nerovnaju
        int[][] pomocnePole = new int[mapa.length-1][mapa[0].length-1];
        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                pomocnePole[i][j] = mapa[i+1][j];
            }
        }

        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                if(i == j && pomocnePole[i][j] == 1){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
        }

        pocitadlo = 0;

        //obratena uhlopriecka
        int[][] zrkadlovaMatica = new int[mapa.length-1][mapa[0].length-1];
        int k = mapa[0].length-2;
        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                zrkadlovaMatica[i][j] = mapa[i+1][k];
                k--;
            }
            k = mapa[0].length-2;
        }

        //overit obratenu maticu
        for(int i = 0; i < zrkadlovaMatica.length; i++){
            for(int j = 0; j < zrkadlovaMatica[0].length; j++){
                if(i == j && zrkadlovaMatica[i][j] == 1){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean overHraca1Tretipripad(){
        //pole treba overit ako keby v nom sa nachadzalo 4polia
        int pocitadlo = 0;
        //overenie pola pravy horny roh
        //riadky
        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 1; j < mapa[0].length; j++){
                if(mapa[i][j] == 1){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
            pocitadlo = 0;
        }
        pocitadlo = 0;
        //stlpce
        for(int j = 1; j < mapa[0].length; j++){
            for(int i = 0; i < mapa.length-1; i++){
                if(mapa[i][j] == 1){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
            pocitadlo = 0;
        }
        pocitadlo = 0;
        //uhlopriecka
        //ale treba zase kopirovat do pomocneho pola
        //lebo sa to posuva
        //a uz mi to robi problem
        //lebo na diagonale sa indexi nerovnaju
        int[][] pomocnePole = new int[mapa.length-1][mapa[0].length-1];
        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                pomocnePole[i][j] = mapa[i][j+1];
            }
        }

        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                if(i == j && pomocnePole[i][j] == 1){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
        }

        pocitadlo = 0;

        //obratena uhlopriecka
        int[][] zrkadlovaMatica = new int[mapa.length-1][mapa[0].length-1];
        int k = mapa[0].length-1;
        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                zrkadlovaMatica[i][j] = mapa[i][k];
                k--;
            }
            k = mapa[0].length-1;
        }

        //overit obratenu maticu
        for(int i = 0; i < zrkadlovaMatica.length; i++){
            for(int j = 0; j < zrkadlovaMatica[0].length; j++){
                if(i == j && zrkadlovaMatica[i][j] == 1){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean overHraca1Stvrtypripad(){
        //pole treba overit ako keby v nom sa nachadzalo 4polia
        int pocitadlo = 0;
        //overenie pola pravy dolny roh
        //riadky
        for(int i = 1; i < mapa.length; i++){
            for(int j = 1; j < mapa[0].length; j++){
                if(mapa[i][j] == 1){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
            pocitadlo = 0;
        }
        pocitadlo = 0;
        //stlpce
        for(int j = 1; j < mapa[0].length; j++){
            for(int i = 1; i < mapa.length; i++){
                if(mapa[i][j] == 1){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
            pocitadlo = 0;
        }
        pocitadlo = 0;
        //uhlopriecka
        //ale treba zase kopirovat do pomocneho pola
        //lebo sa to posuva
        //a uz mi to robi problem
        //lebo na diagonale sa indexi nerovnaju
        //tu by som mohol robit aj jak som robil v pripade jedna
        //lebo indexi sa nemenia
        int[][] pomocnePole = new int[mapa.length-1][mapa[0].length-1];
        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                pomocnePole[i][j] = mapa[i+1][j+1];
            }
        }

        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                if(i == j && pomocnePole[i][j] == 1){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
        }

        pocitadlo = 0;

        //obratena uhlopriecka
        int[][] zrkadlovaMatica = new int[mapa.length-1][mapa[0].length-1];
        int k = mapa.length-1;
        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                zrkadlovaMatica[i][j] = mapa[i+1][k];
                k--;
            }
            k = mapa.length-1;
        }

        //overit obratenu maticu
        for(int i = 0; i < zrkadlovaMatica.length; i++){
            for(int j = 0; j < zrkadlovaMatica[0].length; j++){
                if(i == j && zrkadlovaMatica[i][j] == 1){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
        }

        return false;
    }



    public void hrajHrac2(){
        while (true) {
            int policko = zadajPolickoKdeChcesPolozitZnak();
            int suradnice = zistiSuradnice(policko);
            int riadok = (suradnice / 10);
            int stlpec = (suradnice % 10);
            if (overSuradnice(suradnice) == true) {
                mapa[riadok][stlpec] = 2;
                break;
            }else{
                System.out.println("Pozicia nie je volna!!!");
            }
        }
    }

    public boolean overHraca2Prvypripad(){
        //pole treba overit ako keby v nom sa nachadzalo 4polia
        int pocitadlo = 0;
        //overenie pola lavy horny roh
        //riadky
        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                if(mapa[i][j] == 2){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
            pocitadlo = 0;
        }
        pocitadlo = 0;
        //stlpce
        for(int j = 0; j < mapa[0].length-1; j++){
            for(int i = 0; i < mapa.length-1; i++){
                if(mapa[i][j] == 2){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
            pocitadlo = 0;
        }
        pocitadlo = 0;
        //uhlopriecka
        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                if(i == j && mapa[i][j] == 2){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
        }

        pocitadlo = 0;

        //obratena uhlopriecka
        int[][] zrkadlovaMatica = new int[mapa.length-1][mapa[0].length-1];
        int k = mapa[0].length-2;
        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                zrkadlovaMatica[i][j] = mapa[i][k];
                k--;
            }
            k = mapa[0].length-2;
        }

        //overit obratenu maticu
        for(int i = 0; i < zrkadlovaMatica.length; i++){
            for(int j = 0; j < zrkadlovaMatica[0].length; j++){
                if(i == j && zrkadlovaMatica[i][j] == 2){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean overHraca2Druhypripad(){
        //pole treba overit ako keby v nom sa nachadzalo 4polia
        int pocitadlo = 0;
        //overenie pola lavy dolny roh
        //riadky
        for(int i = 1; i < mapa.length; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                if(mapa[i][j] == 2){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
            pocitadlo = 0;
        }
        pocitadlo = 0;
        //stlpce
        for(int j = 0; j < mapa[0].length-1; j++){
            for(int i = 1; i < mapa.length; i++){
                if(mapa[i][j] == 2){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
            pocitadlo = 0;
        }
        pocitadlo = 0;
        //uhlopriecka
        //ale treba zase kopirovat do pomocneho pola
        //lebo sa to posuva
        //a uz mi to robi problem
        //lebo na diagonale sa indexi nerovnaju
        int[][] pomocnePole = new int[mapa.length-1][mapa[0].length-1];
        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                pomocnePole[i][j] = mapa[i+1][j];
            }
        }

        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                if(i == j && pomocnePole[i][j] == 2){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
        }

        pocitadlo = 0;

        //obratena uhlopriecka
        int[][] zrkadlovaMatica = new int[mapa.length-1][mapa[0].length-1];
        int k = mapa[0].length-2;
        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                zrkadlovaMatica[i][j] = mapa[i+1][k];
                k--;
            }
            k = mapa[0].length-2;
        }

        //overit obratenu maticu
        for(int i = 0; i < zrkadlovaMatica.length; i++){
            for(int j = 0; j < zrkadlovaMatica[0].length; j++){
                if(i == j && zrkadlovaMatica[i][j] == 2){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean overHraca2Tretipripad(){
        //pole treba overit ako keby v nom sa nachadzalo 4polia
        int pocitadlo = 0;
        //overenie pola pravy horny roh
        //riadky
        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 1; j < mapa[0].length; j++){
                if(mapa[i][j] == 2){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
            pocitadlo = 0;
        }
        pocitadlo = 0;
        //stlpce
        for(int j = 1; j < mapa[0].length; j++){
            for(int i = 0; i < mapa.length-1; i++){
                if(mapa[i][j] == 2){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
            pocitadlo = 0;
        }
        pocitadlo = 0;
        //uhlopriecka
        //ale treba zase kopirovat do pomocneho pola
        //lebo sa to posuva
        //a uz mi to robi problem
        //lebo na diagonale sa indexi nerovnaju
        int[][] pomocnePole = new int[mapa.length-1][mapa[0].length-1];
        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                pomocnePole[i][j] = mapa[i][j+1];
            }
        }

        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                if(i == j && pomocnePole[i][j] == 2){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
        }

        pocitadlo = 0;

        //obratena uhlopriecka
        int[][] zrkadlovaMatica = new int[mapa.length-1][mapa[0].length-1];
        int k = mapa[0].length-1;
        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                zrkadlovaMatica[i][j] = mapa[i][k];
                k--;
            }
            k = mapa[0].length-1;
        }

        //overit obratenu maticu
        for(int i = 0; i < zrkadlovaMatica.length; i++){
            for(int j = 0; j < zrkadlovaMatica[0].length; j++){
                if(i == j && zrkadlovaMatica[i][j] == 2){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean overHraca2Stvrtypripad(){
        //pole treba overit ako keby v nom sa nachadzalo 4polia
        int pocitadlo = 0;
        //overenie pola pravy dolny roh
        //riadky
        for(int i = 1; i < mapa.length; i++){
            for(int j = 1; j < mapa[0].length; j++){
                if(mapa[i][j] == 2){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
            pocitadlo = 0;
        }
        pocitadlo = 0;
        //stlpce
        for(int j = 1; j < mapa[0].length; j++){
            for(int i = 1; i < mapa.length; i++){
                if(mapa[i][j] == 2){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
            pocitadlo = 0;
        }
        pocitadlo = 0;
        //uhlopriecka
        //ale treba zase kopirovat do pomocneho pola
        //lebo sa to posuva
        //a uz mi to robi problem
        //lebo na diagonale sa indexi nerovnaju
        //tu by som mohol robit aj jak som robil v pripade jedna
        //lebo indexi sa nemenia
        int[][] pomocnePole = new int[mapa.length-1][mapa[0].length-1];
        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                pomocnePole[i][j] = mapa[i+1][j+1];
            }
        }

        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                if(i == j && pomocnePole[i][j] == 2){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
        }

        pocitadlo = 0;

        //obratena uhlopriecka
        int[][] zrkadlovaMatica = new int[mapa.length-1][mapa[0].length-1];
        int k = mapa.length-1;
        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                zrkadlovaMatica[i][j] = mapa[i+1][k];
                k--;
            }
            k = mapa.length-1;
        }

        //overit obratenu maticu
        for(int i = 0; i < zrkadlovaMatica.length; i++){
            for(int j = 0; j < zrkadlovaMatica[0].length; j++){
                if(i == j && zrkadlovaMatica[i][j] == 2){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
        }

        return false;
    }


    public void hrajHrac3(){
        while (true) {
            int policko = zadajPolickoKdeChcesPolozitZnak();
            int suradnice = zistiSuradnice(policko);
            int riadok = (suradnice / 10);
            int stlpec = (suradnice % 10);
            if (overSuradnice(suradnice) == true) {
                mapa[riadok][stlpec] = 3;
                break;
            }else{
                System.out.println("Pozicia nie je volna!!!");
            }
        }
    }

    public boolean overHraca3Prvypripad(){
        //pole treba overit ako keby v nom sa nachadzalo 4polia
        int pocitadlo = 0;
        //overenie pola lavy horny roh
        //riadky
        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                if(mapa[i][j] == 3){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
            pocitadlo = 0;
        }
        pocitadlo = 0;
        //stlpce
        for(int j = 0; j < mapa[0].length-1; j++){
            for(int i = 0; i < mapa.length-1; i++){
                if(mapa[i][j] == 3){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
            pocitadlo = 0;
        }
        pocitadlo = 0;
        //uhlopriecka
        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                if(i == j && mapa[i][j] == 3){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
        }

        pocitadlo = 0;

        //obratena uhlopriecka
        int[][] zrkadlovaMatica = new int[mapa.length-1][mapa[0].length-1];
        int k = mapa[0].length-2;
        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                zrkadlovaMatica[i][j] = mapa[i][k];
                k--;
            }
            k = mapa[0].length-2;
        }

        //overit obratenu maticu
        for(int i = 0; i < zrkadlovaMatica.length; i++){
            for(int j = 0; j < zrkadlovaMatica[0].length; j++){
                if(i == j && zrkadlovaMatica[i][j] == 3){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean overHraca3Druhypripad(){
        //pole treba overit ako keby v nom sa nachadzalo 4polia
        int pocitadlo = 0;
        //overenie pola lavy dolny roh
        //riadky
        for(int i = 1; i < mapa.length; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                if(mapa[i][j] == 3){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
            pocitadlo = 0;
        }
        pocitadlo = 0;
        //stlpce
        for(int j = 0; j < mapa[0].length-1; j++){
            for(int i = 1; i < mapa.length; i++){
                if(mapa[i][j] == 3){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
            pocitadlo = 0;
        }
        pocitadlo = 0;
        //uhlopriecka
        //ale treba zase kopirovat do pomocneho pola
        //lebo sa to posuva
        //a uz mi to robi problem
        //lebo na diagonale sa indexi nerovnaju
        int[][] pomocnePole = new int[mapa.length-1][mapa[0].length-1];
        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                pomocnePole[i][j] = mapa[i+1][j];
            }
        }

        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                if(i == j && pomocnePole[i][j] == 3){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
        }

        pocitadlo = 0;

        //obratena uhlopriecka
        int[][] zrkadlovaMatica = new int[mapa.length-1][mapa[0].length-1];
        int k = mapa[0].length-2;
        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                zrkadlovaMatica[i][j] = mapa[i+1][k];
                k--;
            }
            k = mapa[0].length-2;
        }

        //overit obratenu maticu
        for(int i = 0; i < zrkadlovaMatica.length; i++){
            for(int j = 0; j < zrkadlovaMatica[0].length; j++){
                if(i == j && zrkadlovaMatica[i][j] == 3){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean overHraca3Tretipripad(){
        //pole treba overit ako keby v nom sa nachadzalo 4polia
        int pocitadlo = 0;
        //overenie pola pravy horny roh
        //riadky
        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 1; j < mapa[0].length; j++){
                if(mapa[i][j] == 3){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
            pocitadlo = 0;
        }
        pocitadlo = 0;
        //stlpce
        for(int j = 1; j < mapa[0].length; j++){
            for(int i = 0; i < mapa.length-1; i++){
                if(mapa[i][j] == 3){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
            pocitadlo = 0;
        }
        pocitadlo = 0;
        //uhlopriecka
        //ale treba zase kopirovat do pomocneho pola
        //lebo sa to posuva
        //a uz mi to robi problem
        //lebo na diagonale sa indexi nerovnaju
        int[][] pomocnePole = new int[mapa.length-1][mapa[0].length-1];
        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                pomocnePole[i][j] = mapa[i][j+1];
            }
        }

        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                if(i == j && pomocnePole[i][j] == 3){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
        }

        pocitadlo = 0;

        //obratena uhlopriecka
        int[][] zrkadlovaMatica = new int[mapa.length-1][mapa[0].length-1];
        int k = mapa[0].length-1;
        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                zrkadlovaMatica[i][j] = mapa[i][k];
                k--;
            }
            k = mapa[0].length-1;
        }

        //overit obratenu maticu
        for(int i = 0; i < zrkadlovaMatica.length; i++){
            for(int j = 0; j < zrkadlovaMatica[0].length; j++){
                if(i == j && zrkadlovaMatica[i][j] == 3){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean overHraca3Stvrtypripad(){
        //pole treba overit ako keby v nom sa nachadzalo 4polia
        int pocitadlo = 0;
        //overenie pola pravy dolny roh
        //riadky
        for(int i = 1; i < mapa.length; i++){
            for(int j = 1; j < mapa[0].length; j++){
                if(mapa[i][j] == 3){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
            pocitadlo = 0;
        }
        pocitadlo = 0;
        //stlpce
        for(int j = 1; j < mapa[0].length; j++){
            for(int i = 1; i < mapa.length; i++){
                if(mapa[i][j] == 3){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
            pocitadlo = 0;
        }
        pocitadlo = 0;
        //uhlopriecka
        //ale treba zase kopirovat do pomocneho pola
        //lebo sa to posuva
        //a uz mi to robi problem
        //lebo na diagonale sa indexi nerovnaju
        //tu by som mohol robit aj jak som robil v pripade jedna
        //lebo indexi sa nemenia
        int[][] pomocnePole = new int[mapa.length-1][mapa[0].length-1];
        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                pomocnePole[i][j] = mapa[i+1][j+1];
            }
        }

        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                if(i == j && pomocnePole[i][j] == 3){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
        }

        pocitadlo = 0;

        //obratena uhlopriecka
        int[][] zrkadlovaMatica = new int[mapa.length-1][mapa[0].length-1];
        int k = mapa.length-1;
        for(int i = 0; i < mapa.length-1; i++){
            for(int j = 0; j < mapa[0].length-1; j++){
                zrkadlovaMatica[i][j] = mapa[i+1][k];
                k--;
            }
            k = mapa.length-1;
        }

        //overit obratenu maticu
        for(int i = 0; i < zrkadlovaMatica.length; i++){
            for(int j = 0; j < zrkadlovaMatica[0].length; j++){
                if(i == j && zrkadlovaMatica[i][j] == 3){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length-1){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean overCiJeKdeZapisovat(){
        int pocitadlo = 0;
        for(int i = 0; i < mapa.length; i++){
            for(int j = 0; j < mapa[0].length; j++){
                if(mapa[i][j] == 0){
                    pocitadlo++;
                }
            }
        }
        if(pocitadlo > 0){
            return true;
        }
        return false;
    }

}
