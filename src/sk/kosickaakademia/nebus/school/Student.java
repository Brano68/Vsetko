package sk.kosickaakademia.nebus.school;

import java.util.Date;

public class Student {
    private String firstName;
    private String lastName;
    private ClassName className;
    private int salary;
    private Date dob;
    private Grades grades;

    //konstruktor prvy
    public Student(String firstName, String lastname, Grades grades, ClassName className){
        this.firstName = firstName;
        this.lastName = lastname;
        this.grades = grades;
        this.className = className;
    }

    //konstruktor druhy
    public Student(String firstName, String lastname, Grades grades, ClassName className, Date dob){
        this(firstName, lastname, grades, className);
        this.dob = dob;
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


}
