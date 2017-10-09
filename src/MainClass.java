import java.util.Scanner;

public class MainClass {


    public static void main(String[] args) {
        Thread thread = new Thread(new Counter(10));
        thread.start();
        Scanner in = new Scanner(System.in);
        if(in.hasNextLine());
        if(thread.isAlive()){
            thread.interrupt();
        }
    }
}
