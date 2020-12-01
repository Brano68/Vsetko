package sk.kosickaakademia.nebus.polymorfizmus.generic;


import java.util.Random;

//genericka trieda
public class AlgorithmG<T> {
    public T random(T a, T b, T c){

        int index= new Random().nextInt(3);
        switch(index){
            case 0:  return a;
            case 1:  return b;
            default: return c;
        }
    }

    public void checktType(T obj){
        if(obj instanceof Number)
            System.out.println("It is a number "+obj.getClass());
        else if(obj instanceof String)
            System.out.println("It is a string");
        else
            System.out.println("Unknown type : "+obj.getClass());

    }

    }

