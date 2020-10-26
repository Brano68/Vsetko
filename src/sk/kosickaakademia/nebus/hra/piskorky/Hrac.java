package sk.kosickaakademia.nebus.hra.piskorky;

public class Hrac {
    private String meno;

    public Hrac(String meno){
        this.meno = meno;
    }

    public String getMeno() {
        return meno;
    }

    public void vypisUvod(Hrac hrac1, Hrac hrac2){
        System.out.println(hrac1.meno + " bude pouzivat znak o");
        System.out.println(hrac2.meno + " bude pouzivat znak x");
    }


}
