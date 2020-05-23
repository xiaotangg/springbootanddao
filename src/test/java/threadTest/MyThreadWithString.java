package threadTest;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MyThreadWithString implements Runnable {

    private static StringBuilder buffer = new StringBuilder();

    private static final AtomicLong number=new AtomicLong();

    private String flag;

    public MyThreadWithString(String flag){
        this.flag=flag;
    }

    @Override
    public void run() {
       if("A".equals(flag)){
           for (int i = 0; i < 10; i++) {
               buffer.append("a"+i);
               number.incrementAndGet(); //跟getAndIncrement区别在于前者是返回新值，后者是返回旧值;
               System.out.println(buffer.toString());
           }
       }else{
           for (int i = 0; i < 10; i++) {
               buffer.append("b"+i);
               System.out.println(buffer.toString());
           }
       }
    }


    public static void main(String[] args) {
        ConcurrentHashMap<String,Integer> concurrentHashMap=new ConcurrentHashMap<>();
        Thread thread1=new Thread(new MyThreadWithString("A"));
       Thread thread2=new Thread(new MyThreadWithString("B"));
       thread1.start();
       thread2.start();

    }
}
