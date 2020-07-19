package pratice.demo.collectionTest;

import pratice.demo.collectionTest.ExtendEx.Children;
import pratice.demo.collectionTest.ExtendEx.Parent;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest {
    public static void main(String[] args) {
        List<String> a= createArrayList();;

        for(String temp:a){
            System.out.println(temp);
        }
        GenericsClass<String> temp = new GenericsClass<>("woshishui");
        GenericsClass<Integer> temp1 = new GenericsClass<Integer>(1);
        //让一个已定类型的泛型引用指向一个未定义类型的泛型对象的时候不会有checked Exception，
        //当使用get方法获得变量的时候，在返回回来后会进行一次类型强转
        GenericsClass temp2 = new GenericsClass(1);
        GenericsClass<String> b = temp2;
        b.show();
        Object object = b.getUnknowType();

        // java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        //String string = b.getUnknowType();
        System.out.println(object.toString());
        System.out.println(temp1.getUnknowType());

        List<? extends Parent> list;
        List<Children> list1 = null;
        list = list1;
//        list.add(new Parent());

        show(1);
        show("1");

    }

    private static List<String> createArrayList(){
        List<String> list = new ArrayList<>();
        for(int i = 0; i<10;i++){
            list.add("Str"+i);
        }

        return list;
    }

    //泛型其实是使用了类型擦除，在编译后String和Interge会被擦除成原始类
    //而反射是在编译时获取对象，那么通过反射获取的泛型类，就是一个原始类，可以存放任意数据
//    public void hello(List<String> list){}
//    public void hello(List<Integer> list){}

    /**
     * 泛型方法
     * @param ls
     * @param <T>
     */
    public static <T> void show(T ls){
        System.out.println(ls);
    }

}

