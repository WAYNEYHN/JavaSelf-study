package wayne.learn.ObjectLearn;


import java.lang.reflect.Field;

public class hashcodeAndEqual {
    public static void main(String[] args) throws NoSuchFieldException {
        /**
         * 测试String产生的
         */
        String c = "123";
        System.out.println("c:" + c.hashCode());
        String d = "123456";
        c = c.concat("456");
        System.out.println("c:"+ c.hashCode());
        System.out.println(c.equals(d));


        StringBuffer a = new StringBuffer("123456");
        System.out.println("a:"+ a.hashCode());
        StringBuffer b = new StringBuffer("123456");
        System.out.println("b:"+ b.hashCode());
        System.out.println(a==b);

        Class clazz = d.getClass();
        System.out.println(clazz.getClass());
        System.out.println(clazz.getSimpleName());
        Field valuefield = clazz.getField("hash");

    }
}
