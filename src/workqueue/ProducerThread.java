package workqueue;

public class ProducerThread<T> extends Thread {
    private final WorkQueue<T> stack;
    private final T item;

    public ProducerThread(T item, WorkQueue<T> stack){
        this.item = item;
        this.stack = stack;
    }

    public void run(){
        try{
            stack.add(item);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
