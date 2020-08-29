package pratice.demo.ThreadTest;

public class myThreadDemo implements Runnable{

    public static void main(String[] args) {
        myThreadDemo a = new myThreadDemo();
        Thread a_1 = new Thread(a);
//        a.start();
        a_1.start();
    }
    public void run(){
        for(int i=0; i<= 100; i++){
            System.out.println(Thread.currentThread().getName()+"-->" +i);
        }
    }

}
