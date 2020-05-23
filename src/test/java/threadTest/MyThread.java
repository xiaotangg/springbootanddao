package threadTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread implements Runnable {
    private final Lock lock;
    private final Condition currentCondition;
    private final Condition nextCondition;
    private String print;
    private int times;

    public MyThread(Lock lock, Condition currentCondition, Condition nextCondition, String print, int times) {
        this.lock = lock;
        this.currentCondition = currentCondition;
        this.nextCondition = nextCondition;
        this.print = print;
        this.times = times;
    }

    @Override
    public void run() {
        int time = 0;

        lock.lock();
        try {
            while (time < times) {
                System.out.print(print);
                nextCondition.signal();
                if (time < times - 1) {    //最后一次不用锁住自己了
                    currentCondition.await();
                }
                time++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("释放锁" + print);
            lock.unlock();
            ;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        Thread threadA = new Thread(new MyThread(lock, conditionA, conditionB, "A", 10));
        Thread threadB = new Thread(new MyThread(lock, conditionB, conditionC, "B", 10));
        Thread threadC = new Thread(new MyThread(lock, conditionC, conditionA, "C", 10));

        threadA.start();
        Thread.sleep(1000);
        threadB.start();
        Thread.sleep(1000);
        threadC.start();
        Thread.sleep(1000);


    }

}
