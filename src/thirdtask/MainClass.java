package thirdtask;

public class MainClass {

    public static void main(String[] args){
        Thread t1 = new Thread(new MyThread(5));
        Thread t2 = new Thread(new MyThread(5));
        t1.setName("Thread 1");
        t2.setName("Thread 2");
        t1.start();
        t2.start();
    }
}
