package pratice.demo.template;


public class in1Impl implements in1 {
    @Override
    public void display() {
        System.out.println(a);
    }
}

interface in1{
    public static final int a = 1;//接口中的变量都是public， static， final的
    void display();
}