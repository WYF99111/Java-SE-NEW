package syn;
//不安全取钱
//两个人去银行取钱
public class UnsafeBank {
    public static void main(String[] args) {
        Account account=new Account(1000,"结婚基金");
        Drawing you=new Drawing(account,50,"你");
        Drawing girlfriend=new Drawing(account,100,"girlfriend");
        you.start();
        girlfriend.start();
    }
}
//账户
class Account{
    private int money;//余额
    private String name;//卡名

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }

}
//银行：模拟取款
class Drawing extends Thread{
    Account account;//账户
    //取了多少钱
    private int drawingMoney;
    //现在手里有多少钱
    private int nowmoney;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;

    }

    public int getDrawingMoney() {
        return drawingMoney;
    }

    public void setDrawingMoney(int drawingMoney) {
        this.drawingMoney = drawingMoney;
    }

    public int getNowmoney() {
        return nowmoney;
    }

    public void setNowmoney(int nowmoney) {
        this.nowmoney = nowmoney;
    }

    @Override
    public void run() {
        //锁的对象是增删改的对象
        synchronized (account){
            if (account.getMoney()-drawingMoney<0){
                System.out.println(Thread.currentThread().getName()+"钱不够，取不了");
                return;
            }
            //sleep可以放大问题的发生性
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //卡内余额=余额-取得钱
            account.setMoney(account.getMoney()-drawingMoney);
            //你手里的钱
            nowmoney=nowmoney+drawingMoney;
            System.out.println(account.getName()+"余额为"+account.getMoney());
            System.out.println(this.getName()+"手里的钱"+nowmoney);

        }
    }


}