package wayne.learn.ExtendsLearn;


import java.lang.reflect.Field;

public class ExtendLearn{
    public static void main(String[] args) throws NoSuchFieldException {
        merchandise merchandise_1 = new PC("1", "dell", 10, 900.0, "windows");
        merchandise merchandise_2 = new Phone("2", "HuaWei", 102, 1223, "android");
        //多态？
        merchandise_1.Print();
        System.out.println();
        merchandise_2.Print();
        merchandise_2.describe();

        Class clazz = merchandise_1.getClass();
//        Class<?> strClass = Class.forName(clazz"Name");
        System.out.println(clazz.getClass());
        System.out.println(clazz.getSimpleName());
    }


}
