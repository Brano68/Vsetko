package sk.kosickaakademia.nebus.table;

public class Table {
    private int[][] arr = new int[][]{ {2,5,8,0},{0,1,7,9},{-9,1,8,14}};

    public static void main(String[] args) {
        Table t = new Table();
        int valueMin = t.min();
        int valueMax = t.max();
        double valueAverage = t.avg();
        int valueSum = t.sumUnderDiagonale();

        System.out.println("Min value is "+valueMin);
        System.out.println("Max value is "+valueMax);
        System.out.println("Average value is "+valueAverage);
        //diagonala sucet
        System.out.println("Sum is "+valueSum);
    }

    public int min(){
        int minimum=arr[0][0];
        int i,j;
        for(i=0;i<3;i++){
            for(j=0;j<4;j++){
                /*if(arr[i][j]<minimum)
                    minimum=arr[i][j];*/
                minimum=arr[i][j]<minimum?arr[i][j]:minimum;
            }
        }
        return minimum;
    }

    public int max(){
        int maximum=arr[0][0];
        int i,j;
        for(i=0;i<3;i++){
            for(j=0;j<4;j++){
                /*if(arr[i][j]<minimum)
                    minimum=arr[i][j];*/
                maximum=arr[i][j]>maximum?arr[i][j]:maximum;
            }
        }
        return maximum;
    }

    public double avg(){
        double average=0;
        int pocet = 0;
        int number = arr[0][0];
        int i,j;
        for(i=0;i<3;i++){
            for(j=0;j<4;j++){
                average = average + arr[i][j];
                        pocet++;
            }
        }
        return (average/pocet);
    }

    public int sumUnderDiagonale(){ // row>col
        int i,j;
        int sum = 0;
        for(i=0;i<3;i++){
            for(j=0;j<4;j++){
                if(i>j){
                    sum += arr[i][j];
                }
            }
        }
        return sum;
    }


}
