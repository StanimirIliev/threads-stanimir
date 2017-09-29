package secondtask;

public class SecondTask {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread(5));
        Thread t2 = new Thread(new MyThread(10));
        t1.setName("Thread 1");
        t2.setName("Thread 2");
        t1.start();
        t2.start();
        while(t1.isAlive() && t2.isAlive()){
        }
        if(!t1.isAlive()){
            t2.interrupt();
        }
        else{
            t1.interrupt();
        }
    }
}
