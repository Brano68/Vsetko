package sk.kosickaakademia.nebus.polymorfizmus.generic;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Algorithm alg = new Algorithm();
        System.out.println(alg.add(5,5));
        System.out.println(alg.add(15.4,28.5));

        System.out.println( new AlgorithmG<String>().random("Janko","Ferko","Lenka"));

        new AlgorithmG<String>().checktType("Mirko");
        new AlgorithmG<Date>().checktType(new Date());
        new AlgorithmG<Integer>().checktType(38);
        new AlgorithmG().checktType(55.7);
    }
}
