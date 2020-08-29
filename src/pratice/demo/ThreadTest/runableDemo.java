package pratice.demo.ThreadTest;

public class runableDemo implements Runnable{

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        for(int i=0; i<= 100; i++){
            System.out.println(Thread.currentThread().getName()+"-->" +i);
        }
    }

    public static void main(String[] args){
        runableDemo a = new runableDemo();
        Thread t1 = new Thread(a, "1");
        t1.start();
    }
}
