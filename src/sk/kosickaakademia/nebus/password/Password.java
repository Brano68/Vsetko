package sk.kosickaakademia.nebus.password;

import java.util.Random;

public class Password {
    public static void main(String[] args) {
        Password password = new Password();
        //1uloha
        System.out.println("Password is: " + password.randomCapitalPassword());
        //2uloha
        System.out.println("Password is: " + password.randomPassword(10));
    }

    public String randomCapitalPassword(){
        String pass = "";
        Random random = new Random();

        for(int i = 0; i < 8; i++){
            char znak = (char)(random.nextInt(26)+65);
            pass = pass + znak;
        }
        return pass;
    }

    public String randomPassword(int length){
        Random random = new Random();
        String pass = "";
        int pocitadloCisel = 0;
        int pocitadloVelPismen = 0;
        int pocitadloMalPismen = 0;

        skoc:
        for(int i = 0; i < length; i++){
            int cislo = random.nextInt(3);
            switch (cislo){
                case (0):
                    pass = pass + (char)(random.nextInt(26)+65);
                    pocitadloVelPismen++;
                    break;
                case (1):
                    pass = pass + (char)(random.nextInt(26)+97);
                    pocitadloMalPismen++;
                    break;
                case (2):
                    pass = pass + (char)(random.nextInt(10)+48);
                    pocitadloCisel++;
                    break;
            }
            if(i == length-1 && (pocitadloCisel == 0 || pocitadloMalPismen == 0 || pocitadloVelPismen == 0)){
                pass = "";
                continue skoc;
            }
        }
        return pass;
    }
}
