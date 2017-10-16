package twothreadscount;

public class Counter extends Thread {

    final int finalValue;
    private Thread otherThread;

    public Counter(int finalValue) {
        this.finalValue = finalValue;
    }

    public void addRef(Thread otherThread){
        this.otherThread = otherThread;
    }

    public void run(){
        try{
            for(int i = 1; i <= finalValue; i ++){
                Thread.sleep(750);
                threadMessage(String.valueOf(i));
            }
        }
        catch(InterruptedException e){
            threadMessage("I was interrupted and exit");
        }
        otherThread.interrupt();
    }

    private void threadMessage(String message){
        System.out.printf("%s:\t%s\n", Thread.currentThread().getName(), message);
    }
}
