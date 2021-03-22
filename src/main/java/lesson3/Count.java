package lesson3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Count {
    private Integer value;
    private Lock lock;

    final Integer TIME_WAIT = 7000;
    final Integer TIME_SLIP = 5000;

    public Count() {
        this.value = 0;
        this.lock = new ReentrantLock();
    }

    public void increment(){
        boolean locked = false;
        try {
            locked = lock.tryLock(TIME_SLIP, TimeUnit.MILLISECONDS);
            if (locked){
                System.out.println("count lock");
                value++;
            }
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }finally {
            System.out.println("count incremented - " + value);
            if (locked){
                System.out.println("count unlock - ");
                lock.unlock();

            }
        }
    }
}
