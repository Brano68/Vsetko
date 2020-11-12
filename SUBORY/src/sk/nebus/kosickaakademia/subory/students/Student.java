package sk.nebus.kosickaakademia.subory.students;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Student {
    private String firstName;
    private String lastName;
    private String id;
    private int age;
    private double height;
    private int weight;
    private Contact contact;

    public Student(String firstName, String lastName, String id, double height, int weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.height = height;
        this.weight = weight;
        this.contact = null;
        setAge();
    }

    public void setAge() {
        //tu nastavime vek prislusny aktualny
        //age = 15;

        int datumAktualny = getDateInNumber(); //ddMMyyyy

        String retazec = getDateID(); //vytiahnute prve 6cislie z ID

        int prvaCislica = Character.getNumericValue(retazec.charAt(0));
        int druhaCislica = Character.getNumericValue(retazec.charAt(1));
        int tretiaCislica = Character.getNumericValue(retazec.charAt(2));
        int stvrtaCislica = Character.getNumericValue(retazec.charAt(3));
        int piataCislica = Character.getNumericValue(retazec.charAt(4));
        int siestaCislica = Character.getNumericValue(retazec.charAt(5));
        int denNarodenia = piataCislica*10 + siestaCislica;
        int mesiacNarodenia;
        int rokNarodenia;


        if(tretiaCislica == 1 || tretiaCislica == 0){
            mesiacNarodenia = tretiaCislica*10 + stvrtaCislica;
        }else{
            mesiacNarodenia = tretiaCislica*10 + stvrtaCislica - 50;
        }
        rokNarodenia = prvaCislica*10 + druhaCislica;
        if(rokNarodenia<20){
            rokNarodenia = rokNarodenia + 2000;
        }else{
            rokNarodenia = rokNarodenia + 1900;
        }


        if((mesiacNarodenia == ((datumAktualny/10000)%100)) && (denNarodenia > datumAktualny/1000000)){
            age = datumAktualny%10000 - rokNarodenia -1;
        }else{
            age = datumAktualny%10000 - rokNarodenia;
        }
    }

    private int getDateInNumber(){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        String datum = date.format(formatter);
        int cislovyDatum = Integer.parseInt(datum);
        return cislovyDatum;
    }

    private String getDateID(){
        String retazecID = "";
        for(int i = 0; i < 6; i++){
            retazecID += id.charAt(i);
        }
    return retazecID;
    }


    public Gender getGender(){
        return id.charAt(2)<'2' ? Gender.MALE:Gender.FEMALE;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Contact getContact() {
        return contact;
    }

}
