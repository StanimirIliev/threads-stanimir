public class Add<T> extends Thread {
    private final WorkStack<T> stack;
    private final T item;

    public Add(T item, WorkStack<T> stack){
        this.item = item;
        this.stack = stack;
    }

    public void run(){
        try{
            stack.add(item);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
