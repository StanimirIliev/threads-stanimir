package timeouthashtable;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;

import static java.lang.Thread.sleep;

public class TimeoutHashtable<K, V> {

    private class Timeout implements Runnable {

        private K key;

        private Timeout(K key) {
            this.key = key;
        }

        @Override
        public void run() {
            try {
                sleep(millis);
                entries.remove(key);
            } catch (InterruptedException e) {}
        }
    }

    private class TimeoutNode {
        private V value;
        private Thread timeout;

        private TimeoutNode(V value, Thread timeout) {
            this.value = value;
            this.timeout = timeout;
            timeout.start();
        }

        private void resetTimer(K key){
            timeout.interrupt();
            timeout = new Thread(new Timeout(key));
            timeout.start();
        }
    }

    private Map<K, TimeoutNode> entries = new Hashtable<>();
    final long millis;

    public TimeoutHashtable(long millis) {
        this.millis = millis;
    }

    public void put(K key, V value){
        entries.put(key, new TimeoutNode(value, new Thread(new Timeout(key))));
    }

    public synchronized V get(K key){
        TimeoutNode node = entries.get(key);
        if(node != null){
            if(node.timeout.isAlive()){
                node.resetTimer(key);
                return node.value;
            }
            entries.remove(key);
        }
        return null;
    }

    public synchronized V remove(K key){
        TimeoutNode node = entries.get(key);
        if(node != null){
            if(node.timeout.isAlive()){
                entries.remove(key);
                return node.value;
            }
            entries.remove(key);
        }
        return null;
    }
}