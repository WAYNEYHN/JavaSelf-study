package pratice.demo.ClassLearing;

public class StaticInnerClass {

    public static int i = 0;
    StaticInnerClass(){

    }
    private static class inner{
        private int a = i;
    }
}
