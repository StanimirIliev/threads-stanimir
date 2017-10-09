public class MainClass {
    public static void main(String[] args){
        Counter t1 = new Counter(5);
        Counter t2 = new Counter(7);
        t1.setName("Thread 1");
        t2.setName("Thread 2");
        t1.addRef(t2);
        t2.addRef(t1);
        t1.start();
        t2.start();
    }
}
