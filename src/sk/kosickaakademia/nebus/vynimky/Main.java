package sk.kosickaakademia.nebus.vynimky;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{14, 0, 17, -5, 8, 36, 27, 81, 8, 11};
        Scanner sc = new Scanner(System.in);
        int index1, index2;
      try {
          System.out.print("Enter index 1: ");
          index1 = sc.nextInt();
          System.out.print("Enter index 2: ");
          index2 = sc.nextInt();
          int result = arr[index1]/arr[index2];
          System.out.println("Result: " + result);
      }catch(ArithmeticException ex){
          System.out.println("Error: " + ex);
      }catch(ArrayIndexOutOfBoundsException ex){
          System.out.println("Error: " + ex);
      }catch(InputMismatchException ex){
          System.out.println("Error: " + ex);
      }catch (Exception e){
          System.out.println("Error: " + e);
      }
        finally {
          System.out.println("It goes always!!!");
      }
    }
}





