package syn;


//不安全的买票
public class Unsafebuyticket {
    public static void main(String[] args){
        Buyticket station = new Buyticket();
        new Thread(station,"小明").start();
        new Thread(station,"小红").start();
        new Thread(station,"老师").start();
    }
}
class Buyticket implements Runnable{
    //票
    private int ticket=10;
    boolean flag=true;


    @Override
    public void run() {
        while (flag){
            buy();
        }
    }
    //synchronized 同步方法，锁的是this
    private synchronized void buy(){
        //判断是否有票
        if (ticket<=0){
            flag=false;
            return;
        }
        else{
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"拿到了第"+ticket--+"张票");
        }
    }
}