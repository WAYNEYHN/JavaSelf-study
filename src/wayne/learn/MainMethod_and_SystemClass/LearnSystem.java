package wayne.learn.MainMethod_and_SystemClass;

public class LearnSystem {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int counter = 0;
        for (int i = 0; i < 10; i++) {
            counter++;
        }
        long endTime_ = System.currentTimeMillis();
        long endTime = System.nanoTime();
        System.out.println(endTime-startTime);
    }
}
