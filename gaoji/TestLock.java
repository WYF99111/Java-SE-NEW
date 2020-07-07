package gaoji;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args){
        TestLock2 testLock2 = new TestLock2();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
    }
}
class TestLock2 implements Runnable{
    int ticket=10;
    //定义lock锁
    private final ReentrantLock lock =new ReentrantLock();//可重复锁
    @Override
    public void run() {
       while (true){
           try {
               lock.lock();//加锁
               if (ticket <= 0) {
                   break;
               } else {
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println(ticket--);
               }
           }
           finally {
               //解锁
               lock.unlock();
           }

       }
    }
}