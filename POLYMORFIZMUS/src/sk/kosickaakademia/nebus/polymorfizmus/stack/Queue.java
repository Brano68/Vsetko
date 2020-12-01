package sk.kosickaakademia.nebus.polymorfizmus.stack;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {
    private int capacity;
    private List<T> array;

    public Queue(int capacity){
        this.capacity = capacity;
        array = new ArrayList<>();
    }

    public int getCapacity(){
        return capacity;
    }

    public int getSize(){
        return array.size();
    }

    public boolean isEmpty(){
        return array.isEmpty();
    }

    public boolean isFull(){
        return capacity==array.size();
    }

    public void enqueue(T value)throws QueueException{
        if(isFull()){
            //System.out.println("Queue is full");
            //try {
            //    throw new QueueException("Queue is full!!!");
            //} catch (QueueException e) {
            //    e.printStackTrace();
            //}
            throw new QueueException("Queue is full!!!");
        }else {
            array.add(0,value);
        }
    }

    public void dequeue() throws QueueException{
        if(isEmpty()){
            //System.out.println("Queue is empty");
            throw new QueueException("Queue is full!!!");
        }else {
            array.remove(array.size()-1);
        }
    }

    public T top(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }else {
            return array.get(array.size()-1);
        }
    }

    public void print(){
        System.out.println();
        for(T t : array){
            System.out.print(t + " ");
        }
    }

    public void printBack(){
        System.out.println();
        System.out.println("Queue od zadu");
        if(array.isEmpty() == false){
            for(int i = array.size()-1; i >= 0; i--){
                System.out.print(array.get(i)+" ");
            }
        }else{
            System.out.println("QUEUE IS EMPTY");
        }
    }

    public void clear(){
        array.clear();
    }
}
