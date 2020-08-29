package pratice.demo.ThreadTest;

public class myThreadtest {

    public static void main(String[] args) throws InterruptedException {
//        printSlowly("这是一个关于拼搏的故事。。。。", 300);
        m1();
        System.out.println(Thread.currentThread().getName());
    }

    public static void printSlowly(String text, long interval) throws InterruptedException {
        for(char ch : text.toCharArray()){
            Thread.sleep(interval);
            System.out.print(ch);
        }
        System.out.println();
    }

    public static void m1(){
        int a;
        String b = new StringBuilder("123").toString();
        m2();
    }

    public static void m2(){
        System.out.println(Thread.currentThread().getName());
        m3();
    }

    public static void m3(){
        System.out.println(Thread.currentThread().getName());
        m4();
    }
    public static void m4(){
        m5();
    }
    public static void m5(){
        System.out.println("暂停");
    }

}
