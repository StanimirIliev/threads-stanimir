import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TimeoutHashtableTest {

    @Test
    public void timeout(){
        TimeoutHashtable<Integer, String> hash = new TimeoutHashtable<>(1000);
        try{
            hash.put(1, "one");
            assertThat(hash.get(1), is(equalTo("one")));
            sleep(2000);
            assertThat(hash.get(1), is(equalTo(null)));
            hash.put(1, "one");
            sleep(500);
            assertThat(hash.get(1), is(equalTo("one")));

            sleep(2000);//  clear the hash

            hash.put(1, "one");
            sleep(500);
            hash.put(2, "two");
            sleep(750);
            assertThat(hash.get(1), is(equalTo(null)));
            assertThat(hash.get(2), is(equalTo("two")));
        }
        catch(InterruptedException e){

        }
    }

    @Test
    public void addAndGet(){
        TimeoutHashtable<Integer, String> hash = new TimeoutHashtable<>(5000);
        hash.put(1, "one");
        hash.put(2, "two");
        assertThat(hash.get(1), is(equalTo("one")));
        assertThat(hash.get(2), is(equalTo("two")));
    }

    @Test
    public void remove(){
        TimeoutHashtable<Integer, String> hash = new TimeoutHashtable<>(5000);
        hash.put(1, "one");
        assertThat(hash.remove(1), is(equalTo("one")));
        assertThat(hash.get(1), is(equalTo(null)));
    }

    @Test
    public void addDuplicateKeys(){
        TimeoutHashtable<Integer, String> hash = new TimeoutHashtable<>(5000);
        hash.put(1, "one");
        assertThat(hash.get(1), is(equalTo("one")));
        hash.put(1, "two");
        assertThat(hash.get(1), is(equalTo("two")));
    }

    @Test
    public void getWithNotExistingKey(){
        TimeoutHashtable<Integer, String> hash = new TimeoutHashtable<>(5000);
        hash.put(1, "one");
        assertThat(hash.get(3), is(equalTo(null)));
    }

    @Test
    public void removeWithNotExistingKey(){
        TimeoutHashtable<Integer, String> hash = new TimeoutHashtable<>(5000);
        hash.put(1, "one");
        assertThat(hash.remove(3), is(equalTo(null)));
    }
}