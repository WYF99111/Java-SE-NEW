package Lambda;

public class Lambda2 {
    public static void main(String[] args){
        Ilove love =new Love();
        love.love(2);
    }
}
interface Ilove{
    void love(int a);
}
class Love implements Ilove{
    @Override
    public void love(int a) {
        System.out.println("i love you-->"+a);
    }
}