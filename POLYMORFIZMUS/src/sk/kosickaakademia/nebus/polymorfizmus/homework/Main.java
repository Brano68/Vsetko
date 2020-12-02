package sk.kosickaakademia.nebus.polymorfizmus.homework;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        //1
        System.out.println("What is different between a.txt and b.txt");
        printArray(WhatAtxtContainsDifferentThanB());

        //2
        System.out.println();
        System.out.println();
        System.out.println("What is different between b.txt and a.txt");
        printArray(WhatBtxtContainsDifferentThanA());

        //3
        System.out.println();
        ArrayList<Integer> a = readToArrayA();
        ArrayList<Integer> b = readToArrayB();
        //vytvori mnozinu z acka a becka a z mnoziny subor c.txt
        HashSet<Integer> set = makeSet(a,b);
        //z mnoziny subor c.txt
        makeFile(set);

        //4
        //zoradenie buble sortu urobime pole o velkosti mnoziny a vypise nam pole zoradene
        System.out.println();
        System.out.println("Bubble sort:");
        makeOrder(set);

        //////////////////////////////////////////////////////////////
        //2.sposob zadal cisla v riadku pisane po viacero
        System.out.println();
        System.out.println("2. sposob");
        //printArray(readToArrayA_NumberAreInLine());
        //readToArrayA_NumberAreInLine();
        //readToArrayB_NumberAreInLine();
        //1
        System.out.println("What is different between aa.txt and bb.txt");
        printArray(WhatAAtxtContainsDifferentThanBB());

        //2
        System.out.println();
        System.out.println("What is different between bb.txt and aa.txt");
        printArray(WhatBBtxtContainsDifferentThanAA());

        //3
        ArrayList<Integer> aa = readToArrayA_NumberAreInLine();
        ArrayList<Integer> bb = readToArrayB_NumberAreInLine();
        HashSet<Integer> sett = makeSet(aa,bb);
        makeFilee(sett);

        //4
        System.out.println();
        System.out.println("Bubble sort:");
        makeOrder(sett);
    }

    //vracia arraylist a dokument
    private static ArrayList readToArrayA(){
        ArrayList<Integer> a = new ArrayList<>();
        try {
            FileReader fr = new FileReader("resource/a.txt");
            BufferedReader reader = new BufferedReader(fr);
            String cislo;
            while ((cislo = reader.readLine()) != null) {
                a.add(Integer.parseInt(cislo));
            }
            fr.close();
        }catch (IOException e){
            System.out.println("Error: " + e);
        }
        /*
        for(Integer i:a){
            System.out.print(i + " ");
        }
         */
        return a;
    }

    //vracia arraylist b dokument
    private static ArrayList readToArrayB(){
        ArrayList<Integer> b = new ArrayList<>();
        try {
            FileReader fr = new FileReader("resource/b.txt");
            BufferedReader reader = new BufferedReader(fr);
            String cislo;
            while ((cislo = reader.readLine()) != null) {
                b.add(Integer.parseInt(cislo));
            }
            fr.close();
        }catch (IOException e){
            System.out.println("Error: " + e);
        }
        /*
        for(Integer i:b){
            System.out.print(i + " ");
        }
         */
        return b;
    }

    //metoda napis co ma A ine abo B
    private static ArrayList WhatAtxtContainsDifferentThanB(){
    ArrayList<Integer> a = readToArrayA();
    ArrayList<Integer> b = readToArrayB();
    ArrayList<Integer> c = new ArrayList<>();

    for(Integer i:a){
        if(b.contains(i)){
            continue;
        }else{
            c.add(i);
        }
    }
    /*
    for (Integer i:c){
        System.out.print(i + " ");
    }
     */
    return c;
    }

    //metoda napis co ma A ine abo B
    private static ArrayList WhatBtxtContainsDifferentThanA(){
        ArrayList<Integer> a = readToArrayA();
        ArrayList<Integer> b = readToArrayB();
        ArrayList<Integer> c = new ArrayList<>();

        for(Integer i:b){
            if(a.contains(i)){
                continue;
            }else{
                c.add(i);
            }
        }
        /*
        for (Integer i:c){
            System.out.print(i + " ");
        }
         */
        return c;
    }

    //metoda na vypis mnoziny
    private static void printArray(ArrayList<Integer> a){
        for (Integer i:a){
            System.out.print(i + " ");
        }
    }

    //vracia mnozinu obsah a aj b
    private static HashSet makeSet(ArrayList<Integer> a, ArrayList<Integer> b){
        HashSet<Integer> set = new HashSet<>();
        //najprv prida do mnoziny list a
        for(Integer i:a){
            set.add(i);
        }
        //teraz prida do mnoziny list b
        for(Integer i:b){
            set.add(i);
        }
        /*
        for(Integer i:set){
            System.out.print(i + " ");
        }
         */
        return set;
    }

    //urobi subor
    private static void makeFile(HashSet<Integer> set){
        try {
            File file = new File("output/" + "c.txt");
            file.createNewFile();
            FileWriter fw = new FileWriter(file);

            for(Integer i:set){
                String cislo = String.valueOf(i);
                fw.write(cislo + '\n');
            }

            fw.close();
            System.out.println("File c.txt has been created sucessfully.");
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    //zoradi bubble sortom
    private static void makeOrder(HashSet<Integer> set){
        int dlzka = set.size();
        int[] pole = new int[dlzka];
        int k = 0;
        for (int i:set){
            pole[k] = i;
            k++;
        }
        /*
        for(int i = 0; i < dlzka; i++){
            System.out.print(pole[i] + " ");
        }
         */
        //Bubble sort
        for(int i = dlzka-1; i >= 0; i--){
            for(int j = 0; j < i; j++){
                if(pole[j]>pole[j+1]){
                    int max = pole[j];
                    pole[j] = pole[j+1];
                    pole[j+1] = max;
                }
            }
        }
        //print
        for(int i = 0; i < pole.length; i++){
            System.out.print(pole[i] + " ");
        }
    }



    //nedal cisla do riadku po jednom ale viacero
    private static ArrayList readToArrayA_NumberAreInLine(){
        ArrayList<Integer> a = new ArrayList<>();
        try {
            FileReader fr = new FileReader("resource/aa.txt");
            BufferedReader reader = new BufferedReader(fr);
            String cislo;
            String ciselko = "";
            while ((cislo = reader.readLine()) != null) {
                for(int i = 0; i < cislo.length(); i++){
                    if(cislo.charAt(i) != ' '){
                        ciselko += cislo.charAt(i);
                        continue;
                    }
                    if(cislo.charAt(i) == ' ' && ciselko != ""){
                        a.add(Integer.parseInt(ciselko));
                        ciselko = "";
                    }
                }
                //a.add(Integer.parseInt(cislo));
            }
            fr.close();
        }catch (IOException e){
            System.out.println("Error: " + e);
        }
        /*
        for(Integer i:a){
            System.out.print(i + " ");
        }
         */
        return a;
    }

    private static ArrayList readToArrayB_NumberAreInLine(){
        ArrayList<Integer> b = new ArrayList<>();
        try {
            FileReader fr = new FileReader("resource/bb.txt");
            BufferedReader reader = new BufferedReader(fr);
            String cislo;
            String ciselko = "";
            while ((cislo = reader.readLine()) != null) {
                for(int i = 0; i < cislo.length(); i++){
                    if(cislo.charAt(i) != ' '){
                        ciselko += cislo.charAt(i);
                        continue;
                    }
                    if(cislo.charAt(i) == ' ' && ciselko != ""){
                        b.add(Integer.parseInt(ciselko));
                        ciselko = "";
                    }
                }
                //b.add(Integer.parseInt(cislo));
            }
            fr.close();
        }catch (IOException e){
            System.out.println("Error: " + e);
        }
        /*
        for(Integer i:b){
            System.out.print(i + " ");
        }
         */
        return b;
    }

    private static ArrayList WhatAAtxtContainsDifferentThanBB(){
        ArrayList<Integer> a = readToArrayA_NumberAreInLine();
        ArrayList<Integer> b = readToArrayB_NumberAreInLine();
        ArrayList<Integer> c = new ArrayList<>();

        for(Integer i:a){
            if(b.contains(i)){
                continue;
            }else{
                c.add(i);
            }
        }
    /*
    for (Integer i:c){
        System.out.print(i + " ");
    }
     */
        return c;
    }

    private static ArrayList WhatBBtxtContainsDifferentThanAA(){
        ArrayList<Integer> a = readToArrayA_NumberAreInLine();
        ArrayList<Integer> b = readToArrayB_NumberAreInLine();
        ArrayList<Integer> c = new ArrayList<>();

        for(Integer i:b){
            if(a.contains(i)){
                continue;
            }else{
                c.add(i);
            }
        }
        /*
        for (Integer i:c){
            System.out.print(i + " ");
        }
         */
        return c;
    }

    private static void makeFilee(HashSet<Integer> set){
        try {
            File file = new File("output/" + "cc.txt");
            file.createNewFile();
            FileWriter fw = new FileWriter(file);

            for(Integer i:set){
                String cislo = String.valueOf(i);
                fw.write(cislo + '\n');
            }

            fw.close();
            System.out.println("File c.txt has been created sucessfully.");
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }



}
