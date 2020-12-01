package sk.kosickaakademia.nebus.polymorfizmus.abstrakt.tree.leafy.fruits;

import sk.kosickaakademia.nebus.polymorfizmus.abstrakt.Tree;

public class AppleTree extends Tree {

    public AppleTree(int age){
        super(age);
    }

    @Override
    public void description() {
        System.out.println("Som Apple tree. Mam sladucke jablcka!!!");
    }




    @Override
    public void getFruit() {
        System.out.println("Moje plody su sladke jablcka");
    }

    public void mojachut(){
        System.out.println("vynikajuca");
    }

}
