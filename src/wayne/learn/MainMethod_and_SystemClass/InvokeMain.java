package wayne.learn.MainMethod_and_SystemClass;

public class InvokeMain {
    public static void main(String[] args) {
        String[] argsv = new String[3];
        argsv[0] = "yang";
        argsv[1] = "hao";
        argsv[2] = "nan";
        String[][] ls = new String[2][];
        ls[0] = new String[3];
        ls[1] = new String[2];
        StringBuilder la = new StringBuilder("123");
        la.append("yanghaonan\n");
        System.out.println(la.delete(0, 3));//左开右闭
        System.out.println(la.reverse());   //倒叙

        MainMethed.main(argsv);


    }
    protected String MainMethed_1 = "1";
}
