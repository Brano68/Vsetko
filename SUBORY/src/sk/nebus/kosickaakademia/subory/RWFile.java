package sk.nebus.kosickaakademia.subory;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RWFile {

    public void copyFileWithCapital(String nameFile) {
        FileReader fr;
        BufferedReader reader;
        FileWriter fw;
        String line;

        try {
            fr = new FileReader(nameFile);
            reader = new BufferedReader(fr);
            File file = new File("output/" + getFileName('b'));
            file.createNewFile();
            fw = new FileWriter(file);

            while ((line = reader.readLine()) != null) {
                line = line.toUpperCase();
                System.out.println(line);
                fw.write(line + '\n');
            }
            fr.close();
            fw.close();
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }

    }

    private String getFileName(char preffix) {
        Calendar calendar = Calendar.getInstance();
        Date cas = calendar.getTime();

        DateFormat dateFormat = new SimpleDateFormat("HHmmss");
        String retazec2 = dateFormat.format(cas);

        String retazec3 = ".txt";
        if(preffix == 'b'){
            return "b_"+retazec2+retazec3;
        }else if(preffix == 'd'){
            return "d_"+retazec2+retazec3;
        }else if(preffix == 'c'){
            return "c_"+retazec2+retazec3;
        }
        return null;
    }

    public void createFileCesar(String nameFile, int offset){
        try{
            //objekt suboru
            FileReader fr = new FileReader(nameFile);
            //objekt suboru
            File file = new File("output/" + getFileName('c'));
            //citac
            BufferedReader br = new BufferedReader(fr);
            //vytvorenie suboru
            file.createNewFile();

            String line;
            String retazec = "";

            while ((line = br.readLine()) != null){
                retazec = retazec + line;
                retazec = retazec + '\n';
            }
            fr.close();
            //zapisovac
            FileWriter fw = new FileWriter(file);

            //dame do pola cely string
            char[] pole = new char[retazec.length()];
            //naplnime cez for pole
            for(int i = 0; i < retazec.length(); i++){
                pole[i] = retazec.charAt(i);
            }
            //zasifrujem pole
            //ked bude offset plusovy
            if(offset > 0) {
                for (int i = 0; i < retazec.length(); i++) {
                    if (pole[i] >= 'A' && pole[i] <= 'Z') {
                        for (int j = 1; j <= offset; j++) {
                            pole[i] = (char) (pole[i] + 1);
                            if (pole[i] > 'Z') {
                                pole[i] = 'A';
                            }
                        }
                    } else if (pole[i] >= 'a' && pole[i] <= 'z') {
                        for (int j = 1; j <= offset; j++) {
                            pole[i] = (char) (pole[i] + 1);
                            if (pole[i] > 'z') {
                                pole[i] = 'a';
                            }
                        }
                    } else if (pole[i] >= '0' && pole[i] <= '9') {
                        for (int j = 1; j <= offset; j++) {
                            pole[i] = (char) (pole[i] + 1);
                            if (pole[i] > '9') {
                                pole[i] = '0';
                            }
                        }
                    } else {
                        pole[i] = pole[i];
                    }
                }
            }else{
                //ked bude offset minusovi
                for (int i = 0; i < retazec.length(); i++) {
                    if (pole[i] >= 'A' && pole[i] <= 'Z') {
                        for (int j = 1; j <= offset*(-1); j++) {
                            pole[i] = (char) (pole[i] - 1);
                            if (pole[i] < 'A') {
                                pole[i] = 'Z';
                            }
                        }
                    } else if (pole[i] >= 'a' && pole[i] <= 'z') {
                        for (int j = 1; j <= offset*(-1); j++) {
                            pole[i] = (char) (pole[i] - 1);
                            if (pole[i] < 'a') {
                                pole[i] = 'z';
                            }
                        }
                    } else if (pole[i] >= '0' && pole[i] <= '9') {
                        for (int j = 1; j <= offset*(-1); j++) {
                            pole[i] = (char) (pole[i] - 1);
                            if (pole[i] < '0') {
                                pole[i] = '9';
                            }
                        }
                    } else {
                        pole[i] = pole[i];
                    }
                }
            }

            //pole nakopirujeme do suboru
            for(int i = 0; i < pole.length; i++){
                fw.write(pole[i]);
            }
            fw.close();

        }catch(IOException ex){
            System.out.println("ERROR: " + ex);
        }

    }

    public void createFileWithoutIorY(String nameFile){
        try{
            //objekt suboru
            FileReader fr = new FileReader(nameFile);
            //objekt suboru
            File file = new File("output/" + getFileName('d'));
            //citac
            BufferedReader br = new BufferedReader(fr);
            //vytvorenie suboru
            file.createNewFile();

            String line;
            String retazec = "";

            while ((line = br.readLine()) != null){
                retazec = retazec + line;
                retazec = retazec + '\n';
            }
            fr.close();
            //zapisovac
            FileWriter fw = new FileWriter(file);

            //dame do pola cely string
            char[] pole = new char[retazec.length()];
            //naplnime cez for
            for(int i = 0; i < retazec.length(); i++){
                pole[i] = retazec.charAt(i);
            }
            //pole nakopirujeme do suboru bez i alebo y
            for(int i = 0; i < pole.length; i++){
                if(pole[i] == 'i' || pole[i] == 'y'){
                    fw.write('_');
                }else{
                    fw.write(pole[i]);
                }
            }
            fw.close();

        }catch(IOException ex){
            System.out.println("ERROR: " + ex);
        }

    }
}

