package sk.kosickaakademia.nebus.vynimky.citanie.zo.subora;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            FileReader fr = new FileReader("D:\\data.txt");
            int i;

            while ((i = fr.read()) != -1){
                System.out.print((char)i);
            }
            fr.close();

        }catch (FileNotFoundException e){
            System.out.println("Subor nenajdeny!!!");
        }catch (IOException ex){
            System.out.println("Error: " + ex);
        }
    }
}
