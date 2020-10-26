package sk.kosickaakademia.nebus.hra.piskorky;

import java.util.Scanner;

public class Mapa {
    private char[][] mapa;
    private Scanner sc = new Scanner(System.in);

    public Mapa(int riadky, int stlpce){
        this.mapa = new char[riadky][stlpce];
        for(int i = 0; i < riadky; i++){
            for(int j = 0; j < stlpce; j++){
                mapa[i][j] = ' ';
            }
        }
    }

    public char[][] getMapa() {
        return mapa;
    }

    public void hrajHruHrac1(Hrac hrac1){
        System.out.println(hrac1.getMeno() + " zadaj indexi pola kde chces zadat znak 'o'");
        while(true){
            System.out.println("Riadok: ");
            int riadok = sc.nextInt();
            System.out.println("Stlpec: ");
            int stlpec = sc.nextInt();
            if(skontrolujPole(riadok, stlpec) == true){
                mapa[riadok][stlpec] = 'o';
                break;
            }else{
                System.out.println("Zadal si zle rozmery alebo sa tam uz nieco nachadza!!!");
                continue;
            }
        }
    }

    public void hrajHruHrac2(Hrac hrac2){
        System.out.println(hrac2.getMeno() + " zadaj indexi pola kde chces zadat znak 'x'");
        while(true){
            System.out.println("Riadok: ");
            int riadok = sc.nextInt();
            System.out.println("Stlpec: ");
            int stlpec = sc.nextInt();
            if(skontrolujPole(riadok, stlpec) == true){
                mapa[riadok][stlpec] = 'x';
                break;
            }else{
                System.out.println("Zadal si zle rozmery alebo sa tam uz nieco nachadza!!!");
                continue;
            }
        }
    }

    public boolean skontrolujPole(int riadok, int stlpec){
        if(mapa[riadok][stlpec] == ' '){
            return true;
        }
        else{
            return false;
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

    public boolean overHrac1(){
        int i, j;
        int pocitadlo = 0;

        //prejdeme riadky
        for(i = 0; i < mapa.length; i++){
            for(j = 0; j < mapa[0].length; j++){
                if(mapa[i][j] == 'o'){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length){
                    return true;
                }
            }
            pocitadlo = 0;
        }

        pocitadlo = 0;
        //prejdeme stlpce
        for(j = 0; j < mapa[0].length; j++){
            for(i = 0; i < mapa.length; i++){
                if(mapa[i][j] == 'o'){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length){
                    return true;
                }
            }
            pocitadlo = 0;
        }

        pocitadlo = 0;
        //prejdeme uhlopriecku 00 11 22 33 ...
        for(i = 0; i < mapa.length; i++){
            for(j = 0; j < mapa[0].length; j++){
                if((i==j) && (mapa[i][j] == 'o')){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length){
                    return true;
                }
            }
        }
        pocitadlo = 0; ///tutututu
        //prejdeme druhu uhlopriecku
        //tak ju prejdeme ze maticu zrkadlime
        char[][] obratenaMapa = new char[mapa.length][mapa[0].length];
        int k = mapa[0].length-1;
        for(i = 0; i < mapa.length; i++){
            for(j = 0; j < mapa[0].length; j++){
                obratenaMapa[i][j] = mapa[i][k];
                k--;
            }
            k = mapa[0].length-1;
        }
        //obratenu mapu prejdem a pozriem uhlopriecku
        for(i = 0; i < obratenaMapa.length; i++){
            for(j = 0; j < obratenaMapa[0].length; j++){
                if((i == j) && (obratenaMapa[i][j] == 'o')){
                    pocitadlo++;
                }
                if(pocitadlo == obratenaMapa.length){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean overHrac2(){
        int i, j;
        int pocitadlo = 0;

        //prejdeme riadky
        for(i = 0; i < mapa.length; i++){
            for(j = 0; j < mapa[0].length; j++){
                if(mapa[i][j] == 'x'){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length){
                    return true;
                }
            }
            pocitadlo = 0;
        }

        pocitadlo = 0;
        //prejdeme stlpce
        for(j = 0; j < mapa[0].length; j++){
            for(i = 0; i < mapa.length; i++){
                if(mapa[i][j] == 'x'){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length){
                    return true;
                }
            }
            pocitadlo = 0;
        }

        pocitadlo = 0;
        //prejdeme uhlopriecku 00 11 22 33 ...
        for(i = 0; i < mapa.length; i++){
            for(j = 0; j < mapa[0].length; j++){
                if((i==j) && (mapa[i][j] == 'x')){
                    pocitadlo++;
                }
                if(pocitadlo == mapa.length){
                    return true;
                }
            }
        }

        pocitadlo = 0;
        //prejdeme druhu uhlopriecku
        //tak ju prejdeme ze maticu zrkadlime
        char[][] obratenaMapa = new char[mapa.length][mapa[0].length];
        int k = mapa[0].length-1;
        for(i = 0; i < mapa.length; i++){
            for(j = 0; j < mapa[0].length; j++){
                obratenaMapa[i][j] = mapa[i][k];
                k--;
            }
            k = mapa[0].length-1;
        }
        //obratenu mapu prejdem a pozriem uhlopriecku
        for(i = 0; i < obratenaMapa.length; i++){
            for(j = 0; j < obratenaMapa[0].length; j++){
                if((i == j) && (obratenaMapa[i][j] == 'x')){
                    pocitadlo++;
                }
                if(pocitadlo == obratenaMapa.length){
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
                if(mapa[i][j] == ' '){
                    pocitadlo++;
                }
            }
        }
        if(pocitadlo == 0){
            return false;
        }else{
            return true;
        }
    }

}
