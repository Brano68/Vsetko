package sk.nebus.kosickaakademia.subory.students;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //vytvorenie pola studentov
        Student[] array = null;

        //naplni pole studentmi zo subora
        array = getStudentsFromFile(array);

        //vytlaci vsetkych
        System.out.println("Vsetci studenti");
        printAllStudents(array);
        System.out.println("----");
        //vytlaci zeny
        System.out.println("Vsetke zeny");
        printAllWomen(array);

        System.out.println("----");
        //prideli kontakt na zaklade suboru constacts
        putContactFromFile(array);
        //vypise studentov s danym kontaktom
        System.out.println("Vsetci a ich kontakty: ");
        printStudentsContacts(array);

    }

    private static Student[] getStudentsFromFile(Student[] array) {
        try {
            FileReader fr = new FileReader("resource/students.dat");
            String line;
            BufferedReader bf = new BufferedReader(fr);
            line = bf.readLine();
            int num = Integer.parseInt(line);
            System.out.println("File contains " + num + " records");
            array = new Student[num];
            for(int i = 0; i < num; i++){
                line = bf.readLine();
                String[] temp = line.split(" ");
                Student s = new Student(temp[0], temp[1], temp[2], Double.parseDouble(temp[3]), Integer.parseInt(temp[4]));
                array[i] = s;
            }

            fr.close();

        }catch (IOException ex){
            ex.printStackTrace();
        }
        return array;
    }

    public static void printAllStudents(Student[] array){
        int len = array.length;
        for(int i = 0; i < len; i++){
            System.out.println(array[i].getFirstName() + " " + array[i].getLastName()
            + " " + array[i].getHeight()+ " " + array[i].getWeight() + " roky: " + array[i].getAge());
        }
    }

    public static void printAllWomen(Student[] array){
        int len = array.length;
        for(int i = 0; i < len; i++){
            if(array[i].getId().charAt(2) == '5' || array[i].getId().charAt(2) == '6'){
                System.out.println(array[i].getFirstName() + " " + array[i].getLastName());
            }
        }
    }

    private static void printStudentsContacts(Student[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i].getFirstName() + " " + array[i].getLastName());
            if(array[i].getContact() != null){
                if(array[i].getContact().getMobil() != null){
                    System.out.print(" " + "Mobil: " + array[i].getContact().getMobil());
                }
                if(array[i].getContact().getEmail() != null){
                    System.out.print(" " + "Email: " + array[i].getContact().getEmail());
                }
                if(array[i].getContact().getSkype() != null){
                    System.out.print(" " + "Skype: " + array[i].getContact().getSkype());
                }
                System.out.println();
            }else{
                System.out.println(" Nema ziadne kontakty");
            }
        }
    }

    private static void putContactFromFile(Student[] array) {
        try {
            FileReader fr = new FileReader("resource/contacts.dat");
            String line;
            BufferedReader bf = new BufferedReader(fr);

            int pocitadlo = 0;
            //kolko riadov je zistime pocitadlom a vsetke nacitame do retazca oddelene enterom
            String retazec = "";
            while ((line = bf.readLine()) != null){
                retazec += line + '\n';
                pocitadlo++;
            }
            //System.out.println(retazec);

            //teraz jednotlive vety prekopirujeme do pola pomocou while
            String[] pole = new String[pocitadlo];
            int l = 0;
            String riadok = "";

            for(int i = 0; i < pole.length; i++){
                while(retazec.charAt(l) != '\n'){
                    riadok = riadok + retazec.charAt(l);
                    l++;
                }
                l++;
                pole[i] = riadok;
                riadok = "";
                //System.out.println(pole[i]);
            }
            //System.out.println();

            //teraz prejdeme pole jednotlivy riadok ulozime do line

            for(int i = 0; i < pocitadlo; i++){
                line = pole[i];
                //na zaklade funkcie split urobime pole kde sa bude nachadzat na 0.pozicii Meno na 1. pozicii Priezviko
                //a na ostatnych nieco moze ale nemusi byt
                String[] temp = line.split(" ");

                //tymto forom budeme prechadzat pole Studentov a kontrolovac ci sa zhoduju mena
                //ak sa mena zhoduju a ked aj ma nejaky kontakt tak mu ho priradi
                for(int j = 0; j < array.length; j++){
                    String meno = array[j].getFirstName();
                    String priezvisko = array[j].getLastName();
                    if((temp[0].equals(meno)) && (temp[1].equals(priezvisko))){
                        int dlzka = temp.length;
                        if(dlzka > 1){
                            Contact contact = new Contact();
                            for(int k = 2; k < dlzka; k++){
                                if(temp[k].contains("skype")){
                                    String skype = temp[k].substring(6,temp[k].length());
                                    contact.setSkype(skype);
                                    array[j].setContact(contact);
                                }
                                if(temp[k].contains("email")){
                                    String email = temp[k].substring(6,temp[k].length());
                                    contact.setEmail(email);
                                    array[j].setContact(contact);
                                }
                                if(temp[k].contains("mobil")){
                                    String mobil = temp[k].substring(6,temp[k].length());
                                    contact.setMobil(mobil);
                                    array[j].setContact(contact);
                                }
                            }
                        }
                    }
                }
            }

            //tu uz iba zavrieme subor
            fr.close();

        }catch (IOException ex){
            ex.printStackTrace();
        }
    }



}
