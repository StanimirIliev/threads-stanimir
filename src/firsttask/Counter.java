package firsttask;

public class Counter implements Runnable {

    private final int finalValue;
    private int value = 0;

    public Counter(int value){
        finalValue = value;
    }

    @Override
    public void run() {
        while(value < finalValue){
            try {
                Thread.sleep(1000);
                value++;
            } catch (InterruptedException e) {
                System.out.println("The last value is -> " + value);
                return;
            }
        }
        System.out.println("Reached the final value\n\nEnter something to stop the program");
    }
}
