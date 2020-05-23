package threadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadWithActiveCount implements Runnable {

    static AtomicInteger atomicInteger = new AtomicInteger(0);

    static int number=0;

    private final ExecutorService executorService= Executors.newSingleThreadExecutor();

    @Override
    public void run() {
        try {


//            while (Thread.activeCount() > 2) {
//                Thread.yield();
//            }
//            atomicInteger.getAndIncrement();
//            System.out.println(Thread.currentThread().getName() + ":" + atomicInteger);
//            Thread.sleep(100000);
            synchronized (MyThreadWithActiveCount.class){
                number++;
            }
            System.out.println(Thread.currentThread().getName() + ":" + number);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        MyThreadWithActiveCount myThreadWithActiveCount = new MyThreadWithActiveCount();
        for (int i = 0; i < 7; i++) {
            Thread thread = new Thread(myThreadWithActiveCount);
            thread.setName("" + i);
            thread.start();
//            thread.interrupt();
        }


    }
}
