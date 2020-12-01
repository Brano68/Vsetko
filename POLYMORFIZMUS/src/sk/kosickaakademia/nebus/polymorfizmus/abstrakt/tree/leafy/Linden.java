package sk.kosickaakademia.nebus.polymorfizmus.abstrakt.tree.leafy;

import sk.kosickaakademia.nebus.polymorfizmus.abstrakt.Tree;

public class Linden extends Tree {

    public Linden(int age){
        super(age);
    }

    @Override
    public void description() {
        System.out.println("Zasad lipu a budes mat vynikajuci caj po cely rok!!!");
    }
}
