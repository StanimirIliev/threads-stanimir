package firsttask;

public class MainClass {


    public static void main(String[] args) {
        Thread thread = new Thread(new Counter(5));
        Thread scanner = new Thread(new WaitingForChar());
        thread.start();
        scanner.start();
        while(thread.isAlive() && scanner.isAlive()){

        }
        if(thread.isAlive()){
            thread.interrupt();
        }
        else{
            scanner.interrupt();
        }
    }
}
