public class MainClass {


    public static void main(String[] args) {
        Thread task = new Thread(new MyThread(5));
        Thread scanner = new Thread(new WaitingForChar());
        task.start();
        scanner.start();
        while(task.isAlive() && scanner.isAlive()){

        }
        if(task.isAlive()){
            task.interrupt();
        }
        else{
            scanner.interrupt();
        }
    }
}
