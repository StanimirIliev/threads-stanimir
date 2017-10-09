import java.util.LinkedList;
import java.util.List;


public class MainClass {
    public static void main(String[] args) {
        WorkStack<Integer> stack = new WorkStack<>(3);
        List<Add<Integer>> adds = new LinkedList<>();
        for(int i = 0; i < 7; i++){
            adds.add(new Add<>(i + 1, stack));
        }
        List<Remove<Integer>> removes = new LinkedList<>();
        for(int i = 0; i < 6; i++){
            removes.add(new Remove<>(stack));
        }
        adds.get(0).start();
        adds.get(1).start();
        adds.get(2).start();
        adds.get(3).start();
        adds.get(4).start();
        removes.get(0).start();
        removes.get(1).start();
        removes.get(2).start();
        removes.get(3).start();
        removes.get(4).start();
        removes.get(5).start();
        adds.get(5).start();
        adds.get(6).start();
    }
}
