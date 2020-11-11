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
            File file = new File("output/" + getFileName());
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


    private String getFileName() {
        Calendar calendar = Calendar.getInstance();
        Date cas = calendar.getTime();

        DateFormat dateFormat = new SimpleDateFormat("hhmmss");
        String retazec2 = dateFormat.format(cas);

        String retazec1 = "b_";
        String retazec3 = ".txt";
        return retazec1+retazec2+retazec3;
    }
}

