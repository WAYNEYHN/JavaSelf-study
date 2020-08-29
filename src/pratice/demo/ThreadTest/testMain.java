package pratice.demo.ThreadTest;

public class testMain {
    public static void main(String[] args) {
        climbThread climb_1 = new climbThread("老年人", 3000, 4);
        climbThread climb_2 = new climbThread("年轻人", 1000, 20);
        Thread thread_1  = new Thread(climb_1);
        Thread thread_2  = new Thread(climb_2);
        thread_1.setName(climb_1.getName());
        thread_2.setName(climb_2.getName());
        thread_1.start();
        thread_2.start();
    }
}
