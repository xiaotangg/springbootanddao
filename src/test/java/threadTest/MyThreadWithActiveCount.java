package threadTest;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadWithActiveCount implements  Runnable {

    static  AtomicInteger  atomicInteger=new AtomicInteger(0);

    @Override
    public void run() {
        try {

//            Thread.sleep(5000);
            while(Thread.activeCount()>2){
                Thread.yield();
            }
            atomicInteger.getAndIncrement();
            System.out.println(Thread.currentThread().getName()+":"+atomicInteger);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        MyThreadWithActiveCount myThreadWithActiveCount=new MyThreadWithActiveCount();
        for (int i = 0; i <7; i++) {
            Thread thread=new Thread(myThreadWithActiveCount);
            thread.setName(""+i);
            thread.start();
        }



    }
}
