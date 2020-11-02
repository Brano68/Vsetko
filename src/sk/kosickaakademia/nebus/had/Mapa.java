package sk.kosickaakademia.nebus.had;



public class Mapa {
    private char mapa[][];

    public Mapa(int dlzka) {
        this.mapa = new char[dlzka][dlzka];
    }

    public void urobHraniceMapy() {
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa.length; j++) {
                if (i == 0 || j == 0 || i == mapa.length - 1 || j == mapa.length - 1) {
                    mapa[i][j] = '#';
                } else {
                    mapa[i][j] = ' ';
                }
            }
        }
    }


    public void vykresliMapuHada() {
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa.length; j++) {
                System.out.print(mapa[i][j]);
            }
            System.out.println();
        }
    }

    public void naplnMapuHadom(Had had){
        int j;
        j = had.getHad().length();
        //vykresli hada pekne z prednej casti
        for (int i = 0; i < had.getHad().length(); i++) {
            mapa[mapa.length/2][i+1] = had.getHad().charAt(j-1);
            j--;
        }
    }

    public void hadHybSa(Had had){
        //hada na poziciu 3riadok 2 stlpec
        int j;
        j = had.getHad().length();
        //vykresli hada pekne z prednej casti
        for (int i = 0; i < had.getHad().length(); i++) {
            mapa[mapa.length/2][1] = ' ';
            mapa[mapa.length/2][i+2] = had.getHad().charAt(j-1);
            j--;
        }

    }


}
