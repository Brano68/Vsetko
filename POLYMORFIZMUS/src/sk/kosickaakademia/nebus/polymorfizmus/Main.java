package sk.kosickaakademia.nebus.polymorfizmus;

public class Main {
    public static void main(String[] args) {
        B p1 = new B();  //zavola sa konstruktor A, potom B
        p1.print(); //zavola sa metoda print() z triedy B

        A p2 = new C(); //zavola sa konstruktor A potom B potom C
        p2.print(); // zavola sa print z triedy C
        ((B)p2).print(); //vypise print z triedy C

        p2.wildAnimal(); //vypise Cow

        A p3 = new A(); //vola sa konstruktor A
        p3.wildAnimal(); //vypise Horse
        //((B)p3).wildAnimal(); neda sa pretypovat ked bolo vytvorene ako A na svojho potomka!!!

        I1 p4 = new B(); //vypise sa konstruktor A, B
        p4.wildAnimal(); //vypise Cow

        ((B) p2).programmingLanguage(); //pretypovanie na B
        ((C) p2).programmingLanguage(); //mozes pretypovat aj na C lebo zdedi ju z Becka
        ((A)p4).print(); //metoda print nie je sucastou I1 a preto je mozne ju volat len po pretipovani na A alebo B


        C p5 = new C(); //vola sa konstruktor A B a nakoniec C
        p5.print(); //vypise C

        A p6 = new A("mobil phone");

        A p7 = new A("mobil phone", "Milan");

    }
}
