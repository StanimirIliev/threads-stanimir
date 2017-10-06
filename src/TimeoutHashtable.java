import java.util.LinkedList;
import java.util.List;

public class TimeoutHashtable<K, V> {

    private class Node {

        private class Timeout extends Thread {

            private boolean isDone = false;

            public void run(){
                isDone = false;
                try{
                    Thread.sleep(millis);
                }
                catch(InterruptedException e){
                    return;
                }
                isDone = true;
            }
        }

        private K key;
        private V value;
        private Timeout timeoutThread;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
            timeoutThread = new Timeout();
            timeoutThread.start();
        }

        private V get(K key){
            timeoutThread.interrupt();
            timeoutThread.run();
            return value;
        }

        private void put(V value){
            this.value = value;
            timeoutThread.interrupt();
            timeoutThread.run();
        }
    }

    private List<Node> nodes;
    final long millis;

    public TimeoutHashtable(long millis) {
        this.millis = millis;
        nodes = new LinkedList<>();
    }

    public void put(K key, V value){
        for(Node node : nodes){
            if(node.get(key) != null){
                if(node.timeoutThread.isAlive()){
                    nodes.remove(node);
                    nodes.add(new Node(key, value));
                }
                node.put(value);
            }
        }
        nodes.add(new Node(key, value));
    }

    public V get(K key){
        for(Node node : nodes){
            if(node.key.equals(key)){
                if(node.timeoutThread.isDone){
                    nodes.remove(node);
                    return null;
                }
                return node.get(key);
            }
        }
        return null;
    }

    public V remove(K key){
        for(int i = 0; i < nodes.size(); i++){
            if(nodes.get(i).key.equals(key)){
                V temp = nodes.get(i).value;
                nodes.remove(i);
                return temp;
            }
        }
        return null;
    }
}