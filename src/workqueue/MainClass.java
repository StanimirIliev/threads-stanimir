package workqueue;

import java.util.LinkedList;
import java.util.List;


public class MainClass {
    public static void main(String[] args) {
        WorkQueue<Integer> queue = new WorkQueue<>(3);
        for(int i = 0; i < 12; i++){
            if(i <= 4){
                new ProducerThread<>(i, queue).start();
            }
            else if(i <= 10){
                new ConsumerThreads<>(queue).start();
            }
            else{
                new ProducerThread<>(i, queue).start();
            }
        }
    }
}
