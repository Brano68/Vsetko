package sk.kosickaakademia.nebus.polymorfizmus.abstrakt.tree.leafy.fruits;

public class Golden extends AppleTree{
    public Golden(int age){
        super(age);
    }

    @Override
    public void description() {
        //super.description();
        System.out.println("ahoj som Golden");
    }

    public void volamGolden(){
        System.out.println("123");
    }
}
