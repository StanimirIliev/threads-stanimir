public class MainClass {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Counter(5));
        Thread t2 = new Thread(new Counter(10));
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
