package pratice.demo.reflectLearing;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射： 程序在运行时可以获得程序或程序中每一个类型成员和成员的信息
 */
public class reflectTouch {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        //第一步，获取类
        Class<?> c = A.class;
        Object object = c.newInstance();
        if (object instanceof A) {
            System.out.println(object instanceof A);

        }


        Method[] methods = c.getMethods();
        Method[] declaremethods = c.getDeclaredMethods();

        Method method = c.getMethod("add", int.class, int.class);
        System.out.println("getMethods获取的方法");
        
        for(Method m:methods)
            System.out.println(m);
        System.out.println("getDeclareMethods获取的方法");
        for(Method m:declaremethods)
            System.out.println(m);
        Field field = c.getField("fuck");
        System.out.println(field);
        
        Object result = method.invoke(object, 1, 2);
        System.out.println(result);
//        Method method1 = c.getMethod("muti", int.class, int.class);
//        Object result2 = method1.invoke(object, 1, 2);
//        System.out.println(result2);

    }


}

class A{
    A(){
        System.out.println("l");
    }
    public final int fuck = 3;
    public int  add(int a, int b){
        return a+b;
    }
    public int sub(int a, int b){
        return a-b;
    }
    private int muti(int a, int b){
        return a*b;
    }
}