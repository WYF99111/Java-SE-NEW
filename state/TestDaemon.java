package state;

//测试守护线程
//上帝守护
public class TestDaemon {
    public static void main(String[] args){
        GOD god = new GOD();
        YOU you = new YOU();
        Thread thread =new Thread(god);
        thread.setDaemon(true);//默认false是用户线程，正常的线程都是用户线程
        thread.start();//守护线程启动
        new Thread(you).start();//用户线程启动

    }
}
//上帝
class GOD implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("上帝保佑你");
        }
    }
}
//人
class YOU implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("开心的活着"+i);
        }
        System.out.println("good bye world");
    }
}