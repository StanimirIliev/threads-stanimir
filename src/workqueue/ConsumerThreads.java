package workqueue;

public class ConsumerThreads<T> extends Thread {
    private final WorkQueue<T> stack;

    public ConsumerThreads(WorkQueue<T> stack){
        this.stack = stack;
    }

    public void run(){
        try{
            stack.remove();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
