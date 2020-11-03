package sk.kosickaakademia.nebus.school;

import sk.kosickaakademia.nebus.school.hobby.*;

import java.util.Date;

public class Student {
    private String firstName;
    private String lastName;
    private ClassName className;
    private int salary;
    private Date dob;
    private Grades grades;
    private Hobby[] hobbies;
    private int countHobbies;

    //konstruktor prvy
    public Student(String firstName, String lastname, Grades grades, ClassName className){
        this.firstName = firstName;
        this.lastName = lastname;
        this.grades = grades;
        this.className = className;
        hobbies = new Hobby[5];
        countHobbies = 0;
    }

    //konstruktor druhy
    public Student(String firstName, String lastname, Grades grades, ClassName className, Date dob){
        this(firstName, lastname, grades, className);
        this.dob = dob;
        hobbies = new Hobby[5];
        countHobbies = 0;
    }

    //settery a gettery
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ClassName getClassName() {
        return className;
    }

    public int getSalary() {
        return salary;
    }

    public Date getDob() {
        return dob;
    }

    public Grades getGrades() {
        return grades;
    }

    //metoda vracia String a vrati meno a priezvisko studenta
    public String printStudent(){
        return getFirstName()+" "+getLastName();
    }

    public void addHobby(Hobby hobby){
        if(countHobbies<hobbies.length){
            hobbies[countHobbies] = hobby;
            countHobbies++;
        }else{
            System.out.println("Maximum hobby je 5");
        }
    }

    public void printHobby(){
        System.out.println(firstName + " " + lastName);
        if(countHobbies>0){
        for(int i = 0; i < countHobbies; i++){
            if(hobbies[i] instanceof Book){
                System.out.println("Nazov Book: " + hobbies[i].getName() + " " + ((Book) hobbies[i]).getAuthor());
            }else if(hobbies[i] instanceof Movie){
                System.out.println("Nazov Movie: " + hobbies[i].getName() + " " + ((Movie) hobbies[i]).getYear());
            }else if(hobbies[i] instanceof Sport){
                System.out.println("Nazov Sport: " + hobbies[i].getName());
            }else if(hobbies[i] instanceof Music){
                System.out.println("Nazov Music: " + hobbies[i].getName());
            }else if(hobbies[i] instanceof IndoorSport){
                System.out.println("Nazov Indoor Sport: " + hobbies[i].getName());
            }
        }
        }else{
            System.out.println("Student nema ziadne Hobby");
        }
    }

}
