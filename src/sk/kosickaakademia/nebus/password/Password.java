package sk.kosickaakademia.nebus.password;

import java.util.Random;

public class Password {
    public static void main(String[] args) {
        Password password = new Password();
        System.out.println("Password is: " + password.randomCapitalPassword());
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
}
