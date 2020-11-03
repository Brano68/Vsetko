package sk.kosickaakademia.nebus.school;

public class Faktorial {


    public static void main(String[] args) {
        int vysledok = fakt(5);
        System.out.println("Faktorial je: " + vysledok);
    }

    private static int fakt(int i) {
        if(i == 1 || i == 0){
            return 1;
        }else{
            int vysledok = i*fakt(i-1);
            return vysledok;
        }
    }
}
