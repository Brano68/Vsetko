package sk.kosickaakademia.nebus.school;

import java.util.Date;
import java.time.LocalDate;
import java.time.Month;

public class Student {
    private String firstName;
    private String lastName;
    private ClassName className;
    private int salary;
    private LocalDate dob;
    private Grades grades;

    public Student(String firstName, String lastname, Grades grades, ClassName className){
        this.firstName = firstName;
        this.lastName = lastname;
        this.grades = grades;
        this.className = className;
    }

    public Student(String firstName, String lastname, Grades grades, ClassName className, LocalDate dob){
        this(firstName, lastname, grades, className);
        this.dob = dob;
    }


    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDob(LocalDate dob) {
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

    public LocalDate getDob() {
        return dob;
    }

    public Grades getGrades() {
        return grades;
    }

    public String printStudent(){
        return getFirstName()+" "+getLastName();
    }


}
