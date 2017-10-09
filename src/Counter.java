import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter extends Thread {

    private boolean locked = false;
    private final int finalValue;
    private final Lock lock = new ReentrantLock();
    private Counter otherThread;

    public Counter(int finalValue) {
        this.finalValue = finalValue;
    }

    public void addRef(Counter otherThread){
        this.otherThread = otherThread;
    }

    public boolean isLocked(){
        return locked;
    }

    public void run(){
        try{
            for(int i = 1; i <= finalValue; i++){
                Thread.sleep(1000);
                if(otherThread.isLocked()){
                    i--;
                    continue;
                }
                try{
                    locked = lock.tryLock();
                    threadMessage(String.valueOf(i));
                }
                finally{
                    lock.unlock();
                    locked = false;
                }
            }
        }
        catch(InterruptedException e){
            threadMessage("I was interrupted and exit");
        }
    }

    private void threadMessage(String message){
        System.out.printf("%s:\t%s\n", Thread.currentThread().getName(), message);
    }

}
