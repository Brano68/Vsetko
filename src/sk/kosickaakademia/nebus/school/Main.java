package sk.kosickaakademia.nebus.school;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //vytvorenie pola typu Student
        Student[] studenti;
        //naplnenie pola
        studenti = Main.vytvorStudentov();

        //metoda na vypis studentov z N1 tiredy
        Main.printN1Student(studenti);
        System.out.println();

        //vypis studentov kde prospech lepsi ako 2
        Main.printStudentsWhereAverageLE2(studenti);
        System.out.println();

        //vypis studentov co sa narodili nad rokom 2000
        Main.printStudentsWhereYearIsMoreThan2000(studenti);
        System.out.println();

        //vypis studentov kolko maju rokov
        Main.printAge(studenti);
        System.out.println();


        ///////////////////////////////
        /*
        //Main.printAge(studenti);
        //System.out.println(studenti[0].getDob());
        //String datum = convertDateToString(studenti[0].getDob());
        //System.out.println(datum);
        //Main.vypisPocetRokov(studenti);

         */
        //Main.zoradStudentov(studenti);
        //System.out.println();
        //Main.printStudentsWhereYearIsMoreThan2000SecondOption(studenti);
    }

    //metoda na vytvorenie studentov
    private static Student[] vytvorStudentov() {
        Student[] s = new Student[10];

        //vytvorenie 1 studenta
        Grades gradesS1 = new Grades(3, 2, 1);
        Student s1 = new Student("Marek", "Baca", gradesS1,
                ClassName.N1, createDob("2010-11-02"));

        s[0] = s1;

        //vytvorenie 2 studenta
        Student s2 = new Student("Jakub", "Novak", new Grades(4, 2, 3),
                ClassName.N2, createDob("2015-05-08"));
        s[1] = s2;

        //vytvorenie 3 studenta
        Student s3 = new Student("Janko", "Mrazik", new Grades(1, 1, 4),
                ClassName.N3, createDob("1999-05-20"));

        s[2] = s3;

        //vytvorenie 4 studenta
        Student s4 = new Student("Brano", "Kolodzej", new Grades(1, 1, 1),
                ClassName.N2, createDob("1993-01-08"));


        s[3] = s4;

        //vytvorenie 5 studenta
        Student s5 = new Student("Jan", "Kolik", new Grades(3, 5, 2),
                ClassName.N1, createDob("2012-05-08"));

        s[4] = s5;

        //vytvorenie 6 studenta
        Student s6 = new Student("Matej", "Augustin", new Grades(2, 2, 2),
                ClassName.N2, createDob("1999-05-20"));
        s[5] = s6;

        //vytvorenie 7 studenta
        Student s7 = new Student("Honza", "Trulik", new Grades(1, 2, 3),
                ClassName.N3, createDob("1999-05-20"));
        s[6] = s7;

        //vytvorenie 8 studenta
        Student s8 = new Student("Johan", "Labus", new Grades(3, 2, 3),
                ClassName.N2, createDob("1999-05-20"));
        s[7] = s8;

        //vytvorenie 9 studenta
        Student s9 = new Student("Michal", "Kic", new Grades(4, 1, 1),
                ClassName.N2, createDob("1996-05-22"));
        s[8] = s9;

        //vytvorenie 10 studenta
        Student s10 = new Student("Ondrej", "Oravec", new Grades(1, 1, 3),
                ClassName.N1, createDob("1997-04-21"));
        s[9] = s10;

        return s;
    }

    //metoda na vypis ak rok narodenia je vacsii ako 2000
    private static void printStudentsWhereYearIsMoreThan2000(Student[] studenti) {
        System.out.println("Year of born is bigger than 2000");

        for (int i = 0; i < studenti.length; i++) {
            if(studenti[i].getDob() != null){
                int year = studenti[i].getDob().getYear()+1900;
                if (year >= 2000) {
                    System.out.println(studenti[i].printStudent());
            }
            }
        }
    }

    //metoda na vypis ak rok narodenia je vacsii ako 2000 iny sposob
    private static void printStudentsWhereYearIsMoreThan2000SecondOption(Student[] studenti) {
        System.out.println("Year of born is bigger than 2000");

        for (int i = 0; i < studenti.length; i++) {
            if(studenti[i].getDob() != null){
                Date date = studenti[i].getDob();
                DateFormat dateFormat = new SimpleDateFormat("yyyy");
                String strDate = dateFormat.format(date);
                int year = Integer.parseInt(strDate);
                //int year = studenti[i].getDob().getYear()+1900;
                if (year >= 2000) {
                    System.out.println(studenti[i].printStudent());
                }
            }
        }
    }

    //metoda na vypis studentov ktori maju priemer lepsi ako 2
    private static void printStudentsWhereAverageLE2(Student[] studenti) {
        double average;
        System.out.println("Average is better than 2");
        for (int i = 0; i < studenti.length; i++) {
            Grades znamky = studenti[i].getGrades();
            average = (znamky.getEng() + znamky.getMath() + znamky.getPro()) / 3;
            if (average < 2) {
                System.out.println("Student: " + studenti[i].getFirstName() + " " + studenti[i].getLastName());
            }
        }
    }

    //metoda na vypis studentov z triedy N1
    private static void printN1Student(Student[] studenti) {
        int dlzka = studenti.length;
        System.out.println("---List 1N---");
        for (int i = 0; i < dlzka; i++) {
            if (studenti[i].getClassName() == ClassName.N1) {
                System.out.println(studenti[i].getFirstName() + " " + studenti[i].getLastName());
            }
        }
    }

    //metoda na vztvorenie datumu typu DATE cez String
    private static Date createDob(String dateS){
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateS);
        }catch(ParseException e){
            e.printStackTrace();
        }
        return null;
    }

    //metoda na konvertovanie Date na String
    private static String convertDateToString(Date datum){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(datum);
        return  strDate;
    }

    //metoda na vypis studentov a ich pocet rokov
    private static void printAge(Student[] studenti){
        System.out.println("How old are you??");
        Date aktualnyDatum = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(aktualnyDatum);
        int todaysDay = c.get(Calendar.DAY_OF_MONTH);
        int todaysMonth = c.get(Calendar.MONTH)+1;
        int todaysYear = c.get(Calendar.YEAR);
        System.out.println("Actual date is: ");
        System.out.println(todaysYear +" "+ todaysMonth +" " +todaysDay);

        int rok;
        int mesiac;
        int den;
        for(int i = 0; i < studenti.length; i++){
            if(studenti[i].getDob() != null){
                String datum = convertDateToString(studenti[i].getDob());
                int datumovecislo = cisloDokopy(datum);
                //System.out.println(datumovecislo);
                rok = datumovecislo/10000;
                mesiac = (datumovecislo-rok*10000)/100;
                den = datumovecislo%100;
                //System.out.print(rok + " " + mesiac + " " + den);
                if(mesiac == todaysMonth && todaysDay < den){
                    System.out.println(studenti[i].getFirstName()+ " " + studenti[i].getLastName()
                            + " ma " + ((todaysYear-rok)-1) + " rokov");
                }else{
                    System.out.println(studenti[i].getFirstName()+ " " + studenti[i].getLastName()
                            + " ma " + (todaysYear-rok) + " rokov");
                }

            }
            //System.out.println();
        }

    }

    //pomocna metoda to string format napr 2010-05-05 -> 20100505
    private static int cisloDokopy(String datum){
        int dlzka = datum.length();
        int cislo = 0;
        for(int i = 0; i < datum.length(); i++){
            if(i == 4 || i == 7){
                continue;
            }
            cislo = cislo*10+Character.getNumericValue(datum.charAt(i));
        }
        return cislo;
    }

    //napise ktory student je na akom mieste v priemere
    private static void zoradStudentov(Student[] studenti){
        //Student[] zoradeniStudenti = new Student[studenti.length];
        double[] priemerStudentov = new double[studenti.length];
        double priemer;

        for(int i = 0; i < studenti.length; i++){
            priemer = (studenti[i].getGrades().getEng() + studenti[i].getGrades().getMath()+
                    studenti[i].getGrades().getPro())/3.0;
            priemerStudentov[i] = priemer;
        }

        //zoradit od najhorsieho po najmensi
        double k,l;
        for(int i = 0; i < studenti.length; i++){
            for(int j = studenti.length-1; j > 0; j--){
                if(priemerStudentov[j] > priemerStudentov[j-1]){
                    k = priemerStudentov[j];
                    l = priemerStudentov[j-1];
                    priemerStudentov[j] = l;
                    priemerStudentov[j-1] = k;
                }
            }
        }

        //prehodenie od najlepsich po najhorsi a iba raz ked sa opakuje dat do pola
        double[] pole = new double[studenti.length];
        int j = studenti.length-1;
        for(int i = 0; i < studenti.length; i++){
            pole[i] = priemerStudentov[j];
            j--;
        }
        j=0;
        double[] poleSkratene = new double[studenti.length];
        for(int i = 0; i < studenti.length-1; i++){
            if(pole[i] == pole[i+1]){
                continue;
            }else{
                poleSkratene[j] = pole[i];
                j++;
            }
        }


        for(int i = 0; i < studenti.length; i++){
            priemer = (studenti[i].getGrades().getEng() + studenti[i].getGrades().getMath()+
                    studenti[i].getGrades().getPro())/3.0;
            for(j = 0; j < poleSkratene.length; j++){
                if(priemer == poleSkratene[j]){
                    System.out.println(studenti[j].getFirstName() + " " + studenti[i].getLastName()
                    + " je na mieste " + (j+1));
                    break;
                }
            }
        }
    }



}



