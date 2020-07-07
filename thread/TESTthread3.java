package thread;


//多个线程同时操作一个对象
//买火车票的例子
//发现问题：多个线程操作同一个资源的情况下，线程不安全，数据紊乱
public class TESTthread3 implements Runnable {
    //票数
    private int ticketNum=10;

    @Override
    public void run() {
        while(true){
            if(ticketNum<=0) {
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Thread.currentThread().getName()可以获得当前线程的名字
            System.out.println(Thread.currentThread().getName() + "-->拿到了第" + ticketNum-- + "票");
        }
    }
    public static void main(String[] args){
        TESTthread3 ticket = new TESTthread3();
        new Thread(ticket,"小明").start();
        new Thread(ticket,"老师").start();
        new Thread(ticket,"黄牛").start();
    }
}