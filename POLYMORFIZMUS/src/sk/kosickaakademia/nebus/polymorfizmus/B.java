package sk.kosickaakademia.nebus.polymorfizmus;

public class B extends A implements I2{

    public B(){
        System.out.println("I am constructor B()");
    }

    @Override //anotacia - pretoze metoda sa uz nachadza prekryly sme ju
    public void print(){
        System.out.println("Class B: print()");
    }

    @Override
    public void wildAnimal() {
        System.out.println("Cow");
    }

    public void programmingLanguage(){
        System.out.println("Class B love Java");
    }
}
