package sk.kosickaakademia.nebus.school;

public class Grades {
    private int math;
    private int eng;
    private int pro;

    //konstruktor
    public Grades(int math, int eng, int pro) {
        this.math = math;
        this.eng = eng;
        this.pro = pro;
    }

    //gettery
    public int getMath() {
        return math;
    }

    public int getEng() {
        return eng;
    }

    public int getPro() {
        return pro;
    }


    //metoda vrati retazec znamok
    @Override
    public String toString() {
        return "Grades: MAT " + math + " ENG" + eng + "PRO" + pro;
    }
}
