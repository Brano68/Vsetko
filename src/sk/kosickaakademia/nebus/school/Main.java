package sk.kosickaakademia.nebus.school;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args){
        //vytvorenie 1 studenta
        Grades gradesS1 = new Grades(3,2,1);
        Student s1 = new Student("Marek", "Baca", gradesS1, ClassName.N1);
        LocalDate datum = LocalDate.of(2000, Month.MARCH, 9);
        s1.setDob(datum);
        System.out.println("Meno: " + s1.getFirstName() + " narodeny " + s1.getDob());

        //vytvorenie 2 studenta
        Student s2 = new Student("Jakub", "Novak", null, ClassName.N2);
        datum = LocalDate.of(2003, Month.JANUARY, 5);
        s2.setDob(datum);
        System.out.println("Meno: " + s2.getFirstName() + " narodeny " + s2.getDob());

        //vytvorenie 3 studenta
        Student s3 = new Student("Janko", "Mrazik", null, ClassName.N2);
        datum = LocalDate.of(1996, Month.APRIL, 18);
        s3.setDob(datum);
        System.out.println("Meno: " + s3.getFirstName() + " narodeny " + s3.getDob());
    }

    }

