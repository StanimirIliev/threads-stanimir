public class Remove<T> extends Thread {
    private final WorkStack<T> stack;

    public Remove(WorkStack<T> stack){
        this.stack = stack;
    }

    public void run(){
        try{
            stack.remove();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
