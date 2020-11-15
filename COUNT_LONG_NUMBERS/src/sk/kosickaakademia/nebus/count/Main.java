package sk.kosickaakademia.nebus.count;

/**
 * aplikacia spocitava dve kladne cisla roznej dlzky, ktpre su zadane ako String kvoli rozsahu
 */
public class Main {
    public static void main(String[] args) {

        String cislo1 = "9999188888888888888888888888888888888888666666666666666666666666";
        String cislo2 = "4328555555555555555555555555555555555555555555555";

        String retazec = Main.sucet(cislo1, cislo2);
        System.out.println("Sucet je: " + retazec);

    }

    public static String sucet (String a , String b) {
        String vysledok = "";
        int dlzkaA = a.length();
        int dlzkaB = b.length();
        int zvysok = 0;

        //overenie ci su kladne
        if(a.charAt(0) != '-' && b.charAt(0) != '-'){
            //ci su rovnako dlhe
            if(dlzkaA == dlzkaB) {
                vysledok = pocitaj(a, b);
            }else{  //v tomto else urobime to ak nebudu rovnako dlhe co nastane
                //urobime to tak ze ked nebudu rovnako dlhe urobime aby boli a to pomocou nul dopredu
                if(dlzkaA > dlzkaB){
                    int rozdiel = dlzkaA - dlzkaB;
                    String bDoplneny = "";
                    for(int i = 0; i < rozdiel; i++){
                        bDoplneny = bDoplneny + '0';
                    }
                    bDoplneny = bDoplneny + b;
                    //tuna su uz rovnako dlhe
                    vysledok = pocitaj(a, bDoplneny);
                }else {
                    int rozdiel = dlzkaB - dlzkaA;
                    String aDoplneny = "";
                    for(int i = 0; i < rozdiel; i++){
                        aDoplneny = aDoplneny + '0';
                    }
                    aDoplneny = aDoplneny + a;
                    //tuna su uz rovnako dlhe
                    vysledok = pocitaj(aDoplneny, b);
                }
            }
        }else {
            System.out.println("Treba zadat kladne cisla!!!");
            return null;
        }
        return prepisOdZadu(vysledok);
    }

    public static String pocitaj(String a, String b){
        String vysledok = "";
        int dlzkaA = a.length();
        int dlzkaB = b.length();
        int zvysok = 0;

        for(int i = dlzkaA-1; i >=0; i--){
            int cislo1 = Character.getNumericValue(a.charAt(i));
            int cislo2 = Character.getNumericValue(b.charAt(i));
            int sucet = cislo1 + cislo2;
            if((sucet+zvysok) < 10){
                vysledok = vysledok + (char)((sucet+zvysok) + '0');
                zvysok = 0;
            }else {
                vysledok = vysledok + (char)(((sucet+zvysok)%10) + '0');
                zvysok = 1;
            }
        }
        //osetrenie napr pre pripad 9999 + 4328 bez toho by dalo bez 1tky vpredu namiesto 14327 iba 4327
        if(zvysok == 1){
            vysledok = vysledok + '1';
        }
        return vysledok;
    }

    public static String prepisOdZadu(String vysledok){
        String vysledokOdPredu = "";
        for(int i = vysledok.length()-1; i >= 0; i--){
            vysledokOdPredu = vysledokOdPredu + vysledok.charAt(i);
        }
        return vysledokOdPredu;
    }
}
