package firsttask;

import java.util.Scanner;

public class WaitingForChar implements Runnable{

    Scanner in = new Scanner(System.in);

    @Override
    public void run() {
        try{
            Thread.sleep(1000);
            in.hasNextLine();// Waits until something is entered by the user
        }
        catch(InterruptedException e){
            // Can't find a way to interrupt the scanner if the user is not entered something
        }
    }
}
