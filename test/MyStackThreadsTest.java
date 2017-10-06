import org.junit.jupiter.api.Test;

import static java.lang.Thread.sleep;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MyStackThreadsTest {

    MyStack<Integer> list = new MyStack<>(3);

    public  class Add extends Thread{
        private final int number;

        public Add(int number) {
            this.number = number;
        }

        public void run(){
            try {
                list.add(number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public class Remove extends Thread{

        public void run(){
            try {
                list.remove();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void addAndRemoveThreads() throws InterruptedException {
        Thread add1 = new Add(1);
        Thread add2 = new Add(2);
        Thread add3 = new Add(3);
        Thread add4 = new Add(4);
        Thread add5 = new Add(5);
        Thread add6 = new Add(6);
        Thread add7 = new Add(7);
        Thread remove1 = new Remove();
        Thread remove2 = new Remove();
        Thread remove3 = new Remove();
        Thread remove4 = new Remove();
        Thread remove5 = new Remove();
        Thread remove6 = new Remove();
        assertThat(list.size(), is(equalTo(0)));
        add1.start();
        sleep(1);
        assertThat(list.size(), is(equalTo(1)));
        add2.start();
        sleep(1);
        assertThat(list.size(), is(equalTo(2)));
        add3.start();
        sleep(1);
        assertThat(list.size(), is(equalTo(3)));
        add4.start();
        sleep(1);
        assertThat(list.size(), is(equalTo(3)));
        add5.start();
        sleep(1);
        assertThat(list.size(), is(equalTo(3)));
        remove1.start();
        sleep(1);
        assertThat(list.size(), is(equalTo(3)));
        remove2.start();
        sleep(1);
        assertThat(list.size(), is(equalTo(3)));
        remove3.start();
        sleep(1);
        assertThat(list.size(), is(equalTo(2)));
        remove4.start();
        sleep(1);
        assertThat(list.size(), is(equalTo(1)));
        remove5.start();
        sleep(1);
        assertThat(list.size(), is(equalTo(0)));
        remove6.start();
        sleep(1);
        assertThat(list.size(), is(equalTo(0)));
        add6.start();
        sleep(1);
        assertThat(list.size(), is(equalTo(0)));
        add7.start();
        sleep(1);
        assertThat(list.size(), is(equalTo(1)));
    }
}