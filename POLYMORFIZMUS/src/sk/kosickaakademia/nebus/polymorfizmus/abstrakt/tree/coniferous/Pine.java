package sk.kosickaakademia.nebus.polymorfizmus.abstrakt.tree.coniferous;

import sk.kosickaakademia.nebus.polymorfizmus.abstrakt.Coniferous;
import sk.kosickaakademia.nebus.polymorfizmus.abstrakt.Tree;

public class Pine extends Tree implements Coniferous {

    public Pine(int age){
        super(age);
    }

    @Override
    public void description() {
        System.out.println("Som sucha a opadava mi ihlicie!!!");
    }
}
