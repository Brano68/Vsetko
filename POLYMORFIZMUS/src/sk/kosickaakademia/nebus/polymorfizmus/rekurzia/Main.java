package sk.kosickaakademia.nebus.polymorfizmus.rekurzia;

public class Main {
    public static void main(String[] args) {
        double number = sucet(1);
        System.out.println("Result is: " + number);
    }

    public static double sucet(double n){
        if(1/n<0.001){
            return 1/n;
        }else{
            return 1/n + sucet(n+1);
        }
    }
}
