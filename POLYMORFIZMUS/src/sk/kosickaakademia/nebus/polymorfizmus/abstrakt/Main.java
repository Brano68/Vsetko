package sk.kosickaakademia.nebus.polymorfizmus.abstrakt;

import sk.kosickaakademia.nebus.polymorfizmus.abstrakt.tree.coniferous.Pine;
import sk.kosickaakademia.nebus.polymorfizmus.abstrakt.tree.leafy.fruits.AppleTree;
import sk.kosickaakademia.nebus.polymorfizmus.abstrakt.tree.leafy.fruits.Golden;
import sk.kosickaakademia.nebus.polymorfizmus.abstrakt.tree.leafy.fruits.Jonatan;

public class Main {
    public static void main(String[] args) {
        Tree S1 = new Golden(5);

        Tree p2=new Golden(5);   // zavola sa kontruktor A, potom B, potom C
        p2.description();   // zavola sa print z triedy C

        ((AppleTree)p2).mojachut(); // vypise print z triedy C
        ((Golden)p2).volamGolden();
        //((Jonatan)p2).description(); chyba

    }
}
