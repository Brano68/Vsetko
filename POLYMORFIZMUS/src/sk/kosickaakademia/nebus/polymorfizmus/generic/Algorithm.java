package sk.kosickaakademia.nebus.polymorfizmus.generic;

public class Algorithm {
    public int add(int a, int b){
        return a+b;
    }
    //overload - pretazovanie
    public double add(double a, double b){
        return a+b;
    }
    //overload - pretazovanie
    public int add(int a, int b, int c){
        return a+b+c;
    }
}
