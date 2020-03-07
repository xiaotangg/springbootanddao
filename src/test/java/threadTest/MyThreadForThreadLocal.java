package threadTest;


import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

public class MyThreadForThreadLocal implements Runnable {

    private  static ThreadLocal<Integer> threadLocal=new ThreadLocal<Integer>();
    @Override
    public void run() {
        Integer integer = threadLocal.get();
        System.out.println(integer == null);
        integer =integer == null ? 0:integer;
        for (int i = 0; i < 10; i++) {
            integer++;
            System.out.println(Thread.currentThread().getName()+":"+integer);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        RedissonClient redission = Redisson.create();
        RLock lock = redission.getLock("aaa");
        lock.tryLock();
        MyThreadForThreadLocal myThreadForThreadLocal=new MyThreadForThreadLocal();
      Thread thread1=new Thread(myThreadForThreadLocal);
      thread1.setName("thread1");
      Thread thread2=new Thread(myThreadForThreadLocal);
      thread2.setName("thread2");
      thread1.start();
      thread2.start();
    }

}
