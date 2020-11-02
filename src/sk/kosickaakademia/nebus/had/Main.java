package sk.kosickaakademia.nebus.had;


import java.io.IOException;

public class Main {
    public static void main(String[] args){
        //Main.clrscr();
        //vytvorenie objektu mapa
        Mapa mapa = new Mapa(10);

        //ohranicenie mapy
        mapa.urobHraniceMapy();

        //vytvorenie objektu hada
        Had had = new Had(3);

        mapa.naplnMapuHadom(had);
        mapa.vykresliMapuHada();

        Main.spi(500);
        Main.clrscr();
        mapa.hadHybSa(had);
        mapa.vykresliMapuHada();

        //System.out.println("Ahoj");
    }



    public static void clrscr(){

        //Clears Screen in java

        try {

            if (System.getProperty("os.name").contains("Windows"))

                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            else

                Runtime.getRuntime().exec("clear");

        } catch (IOException | InterruptedException ex) {}

    }

    public static void spi(int cas){
        try {
            Thread.sleep(cas);
        } catch (InterruptedException e) {}
    }

}












