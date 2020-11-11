package sk.nebus.kosickaakademia.subory;

public class Main {
    public static void main(String[] args) {
    RWFile rwFile = new RWFile();
    //urobi novy tex editor s velkymi pismenami
    rwFile.copyFileWithCapital("resource/a.txt");

    //urobi novy text editor so sifrou
    rwFile.createFileCesar("resource/a.txt",-5);

    //urobi novy text editor a kde je i alebo y da _
    rwFile.createFileWithoutIorY("resource/a.txt");

    }
}
