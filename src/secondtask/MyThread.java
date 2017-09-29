package secondtask;

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
            for(int i = 1; i <= finalValue; i ++){
                Thread.sleep(750);
                threadMessage(String.valueOf(i));
            }
        }
        catch(InterruptedException e){
            threadMessage("I was interrupted and exit");
        }
    }
}
