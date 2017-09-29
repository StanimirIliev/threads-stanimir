package fourthtask;

import java.util.ArrayList;
import java.util.List;

public class MyStack<T> {
    private int length = 0,// stores how much elements the list has
            size;// stores the set maximum of elements
    private List<T> list = null;// the list with elements

    /**
     * Creates new instance of this class with set size of the list
     * @param size
     */
    public MyStack(int size){
        list = new ArrayList<>(size);// creates instance of the class ArrayList with the specific size
        this.size = size;// stores the size
    }

    /**
     * Adding new element at the end of the list
     * @param element -> the new element
     * @throws IllegalStateException if the list is full
     */
    public synchronized void add(T element) throws InterruptedException {
        while(length == size){
            wait();
        }
        this.length++;// else increase the length
        this.list.add(element);// and add the new element
        notify();
    }

    /**
     * Removes the last element of the list
     * @throws IllegalStateException if the list is empty
     */
    public synchronized void remove() throws InterruptedException {
        while(this.length == 0){
            wait();
        }
        this.list.remove(--length);// else remove the last element from the list and decrease the length
        notify();
    }

    /**
     * Print all elements to the console
     */
    public void printAllElements(){
        for(int i = 0; i < this.length; i++){// Iterates every element in the list
            System.out.println(this.list.get(i).toString());// Convert it to string and print it to the console
        }
    }

    public int size(){
        return length;
    }
}
