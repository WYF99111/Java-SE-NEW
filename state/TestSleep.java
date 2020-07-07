package state;

//模拟网络延时：放大问题的发生性
public class TestSleep implements Runnable{
    //票数
    private int ticket=10;
    @Override
    public void run() {
        while (true){
            if(ticket<=0){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->拿到了第"+ticket--+"票");
        }
    }
    public static void main(String[] args){
        TestSleep ticket = new TestSleep();
        new Thread(ticket,"小明").start();
        new Thread(ticket,"老师").start();
        new Thread(ticket,"黄牛").start();
    }
}
