package sk.kosickaakademia.nebus.polymorfizmus.stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> zasobnik = new Stack(5);
        try {
            zasobnik.push(15);
            zasobnik.push(10);
            zasobnik.push(-115);
            zasobnik.push(15);
            zasobnik.print();
            zasobnik.push(16);
            //zasobnik.push(17);
            zasobnik.print();
            zasobnik.pop();
            zasobnik.print();

            Stack<String> zasobnikMien = new Stack<>(2);
            zasobnikMien.push("Iveta");
            zasobnikMien.push("Radovan");
            zasobnikMien.print();
        }
    catch (StackException ex){
        ex.printStackTrace();
    }

    ///teraz queue
    Queue<Integer> fronta = new Queue<>(3);
        try {
            fronta.enqueue(1);
            fronta.enqueue(2);
            fronta.enqueue(3);
            //fronta.enqueue(8);
            fronta.print();
            fronta.dequeue();
            fronta.print();
            fronta.printBack();
        }
   catch (QueueException ex){
            ex.printStackTrace();
   }
    }
}
