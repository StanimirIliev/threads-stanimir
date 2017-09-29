package thirdtask;

public class MyThread implements Runnable {

    final int finalValue;

    public MyThread(int finalValue) {
        this.finalValue = finalValue;
    }

    private void threadMessage(String message){
        System.out.printf("%s:\t%s\n", Thread.currentThread().getName(), message);
    }

    public void run(){
        try{
            for(int i = 1; i <= finalValue; i++){
                synchronized (this){
                    threadMessage(String.valueOf(i));
                }
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e){
            threadMessage("I was interrupted and exit");
        }
    }
}
