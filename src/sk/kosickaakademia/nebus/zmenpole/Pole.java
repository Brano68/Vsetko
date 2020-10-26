package sk.kosickaakademia.nebus.zmenpole;

import java.util.Random;

public class Pole {
    private static int[][] pole = new int[][]{ {2,5,8,0},{0,1,7,9},{-9,0,8,14}};

    public static void main(String[] args) {
        Pole.changeArray(pole);
    }


    public static void changeArray(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] < 0){
                    arr[i][j] = absolutnaHodnota(arr[i][j]);
                }else if(arr[i][j] > 0 && arr[i][j]%2 != 0){
                    arr[i][j] = urobParneCislo(arr[i][j]);
                }else if(arr[i][j] == 0){
                    arr[i][j] = vygenerujCislo();
                }
            }
        }
        ////vypise
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
            System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int absolutnaHodnota(int cislo){
        cislo = cislo * (-1);
        return cislo;
    }

    public static int urobParneCislo(int cislo){
        if(cislo%10 == 1 || cislo%10 == 3){
            return cislo-1;
        }else{
            return cislo+1;
        }
    }

    public static int vygenerujCislo(){
        Random random = new Random();
        int cislo = random.nextInt(90)+10;
        return cislo;
    }

}
