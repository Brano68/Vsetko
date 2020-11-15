package sk.kosickaakademia.nebus.polymorfizmus;

public class C extends B{

    public C(){
        System.out.println("I am constructor C()");
    }

    @Override
    public void print(){
        System.out.println("Class C: print()");
    }

}
