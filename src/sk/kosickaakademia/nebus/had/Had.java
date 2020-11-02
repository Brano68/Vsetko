package sk.kosickaakademia.nebus.had;

public class Had {
    String had = "";

    public Had(int dlzka){
        for(int i = 0; i < dlzka; i++){
            if(i == 0){
                had = had + "X";
            }else{
                had = had + "O";
            }
        }
    }

    public String getHad() {
        return had;
    }
}
