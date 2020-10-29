package sk.kosickaakademia.nebus.school;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args){
        Student[] studenti;
        studenti = Main.vytvorStudentov();
        printN1Student(studenti);
        printStudentsWhereAverageLE2(studenti);
        printStudentsWhereYearIsMoreThan2000(studenti);
    }

    private static void printStudentsWhereYearIsMoreThan2000(Student[] studenti) {
        System.out.println("Year of born is bigger than 2000");
        for (int i = 0; i < studenti.length; i++){
            int year = studenti[i].getDob().getYear();
            if(year >= 2000){
                System.out.println(studenti[i].printStudent());
            }
        }
    }

    private static void printStudentsWhereAverageLE2(Student[] studenti) {
        double average;
        System.out.println("Average is better than 2");
        for(int i = 0; i < studenti.length; i++){
            Grades znamky = studenti[i].getGrades();
            average = (znamky.getEng() + znamky.getMath() + znamky.getPro()) / 3;
            if(average < 2){
                System.out.println("Student: " + studenti[i].getFirstName() + " " + studenti[i].getLastName());
            }
        }
    }


    private static Student[] vytvorStudentov(){
        //vytvorenie 1 studenta
        Grades gradesS1 = new Grades(3,2,1);
        Student s1 = new Student("Marek", "Baca", gradesS1, ClassName.N1);
        LocalDate datum = LocalDate.of(2000, Month.MARCH, 20);
        s1.setDob(datum);
        //System.out.println("Meno: " + s1.getFirstName() + " narodeny " + s1.getDob());
        Student[] s = new Student[10];
        s[0] = s1;

        //vytvorenie 2 studenta
        Student s2 = new Student("Jakub", "Novak", new Grades(4,2,3), ClassName.N2);
        datum = LocalDate.of(2003, Month.JANUARY, 5);
        s2.setDob(datum);
        //System.out.println("Meno: " + s2.getFirstName() + " narodeny " + s2.getDob());
        s[1] = s2;

        //vytvorenie 3 studenta
        Student s3 = new Student("Janko", "Mrazik", new Grades(1,1,4), ClassName.N3);
        datum = LocalDate.of(1996, Month.APRIL, 18);
        s3.setDob(datum);
        //System.out.println("Meno: " + s3.getFirstName() + " narodeny " + s3.getDob());
        s[2] = s3;

        //vytvorenie 4 studenta
        Student s4 = new Student("Brano", "Kolodzej", new Grades(1,1,1), ClassName.N2);
        datum = LocalDate.of(1994, Month.DECEMBER, 14);
        s4.setDob(datum);
        //System.out.println("Meno: " + s4.getFirstName() + " narodeny " + s4.getDob());
        s[3] = s4;

        //vytvorenie 5 studenta
        Student s5 = new Student("Jan", "Kolik", new Grades(3,5,2), ClassName.N1);
        datum = LocalDate.of(2003, Month.APRIL, 10);
        s5.setDob(datum);
        //System.out.println("Meno: " + s4.getFirstName() + " narodeny " + s4.getDob());
        s[4] = s5;

        //vytvorenie 6 studenta
        Student s6 = new Student("Matej", "Augustin", new Grades(2,2,2), ClassName.N2);
        datum = LocalDate.of(2000, Month.APRIL, 18);
        s6.setDob(datum);
        //System.out.println("Meno: " + s4.getFirstName() + " narodeny " + s4.getDob());
        s[5] = s6;

        //vytvorenie 7 studenta
        Student s7 = new Student("Honza", "Trulik", new Grades(1,2,3), ClassName.N3);
        datum = LocalDate.of(1978, Month.APRIL, 18);
        s7.setDob(datum);
        //System.out.println("Meno: " + s4.getFirstName() + " narodeny " + s4.getDob());
        s[6] = s7;

        //vytvorenie 5 studenta
        Student s8 = new Student("Johan", "Labus", new Grades(3,2,3), ClassName.N2);
        datum = LocalDate.of(1999, Month.APRIL, 13);
        s8.setDob(datum);
        //System.out.println("Meno: " + s4.getFirstName() + " narodeny " + s4.getDob());
        s[7] = s8;

        //vytvorenie 5 studenta
        Student s9 = new Student("Michal", "Kic", new Grades(4,1,1), ClassName.N2);
        datum = LocalDate.of(2010, Month.APRIL, 12);
        s9.setDob(datum);
        //System.out.println("Meno: " + s4.getFirstName() + " narodeny " + s4.getDob());
        s[8] = s9;

        //vytvorenie 5 studenta
        Student s10 = new Student("Ondrej", "Oravec", new Grades(1,1,3), ClassName.N1);
        datum = LocalDate.of(2003, Month.APRIL, 22);
        s10.setDob(datum);
        //System.out.println("Meno: " + s4.getFirstName() + " narodeny " + s4.getDob());
        s[9] = s10;

        return s;
    }


    private static void printN1Student(Student[] studenti){
        int dlzka = studenti.length;
        System.out.println("---List 1N---");
        for(int i = 0; i < dlzka; i++){
            if(studenti[i].getClassName() == ClassName.N1){
                System.out.println(studenti[i].getFirstName() + " " + studenti[i].getLastName());
            }
        }
    }

    }

