import java.util.ArrayList;
import java.util.List;

public class WorkStack<T> {
    private int maxSize;// stores the set maximum of elements
    private List<T> list = null;// the list with elements

    /**
     * Creates new instance of this class with set maxSize of the list
     * @param size
     */
    public WorkStack(int size){
        list = new ArrayList<>(size);// creates instance of the class ArrayList with the specific maxSize
        this.maxSize = size;// stores the maxSize
    }

    /**
     * Adding new element at the end of the list
     * @param element -> the new element
     * @throws IllegalStateException if the list is full
     */
    public synchronized void add(T element) throws InterruptedException {
        while(list.size() == maxSize){
            wait();
        }
        this.list.add(element);// and add the new element
        notify();
    }

    /**
     * Removes the last element of the list
     * @throws IllegalStateException if the list is empty
     */
    public synchronized void remove() throws InterruptedException {
        while(list.size() == 0){
            wait();
        }
        this.list.remove(list.size() - 1);
        notify();
    }

    /**
     * Print all elements to the console
     */
    public void printAllElements(){
        System.out.println(list);
    }

    public int size(){
        return list.size();
    }

}