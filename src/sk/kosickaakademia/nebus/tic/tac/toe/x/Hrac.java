package sk.kosickaakademia.nebus.tic.tac.toe.x;

public class Hrac {
    private String meno;

    public Hrac(String meno){
        this.meno = meno;
    }

    public String getMeno() {
        return meno;
    }

    public void zoznamHracov(Hrac hrac1, Hrac hrac2, Hrac hrac3){
        System.out.println("------VITAJTE--------");
        System.out.println(hrac1.meno + ", " + hrac2.meno + ", " + hrac3.meno + "prajem vela stastia!!!");
    }

}
