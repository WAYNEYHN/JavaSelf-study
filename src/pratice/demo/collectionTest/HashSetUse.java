package pratice.demo.collectionTest;

import java.util.Collection;
import java.util.HashSet;


public class HashSetUse {

    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        addElementsTOCollecion(hashSet);
        printCollecionElement(hashSet);
        String  a = null;

    }

    public static Collection addElementsTOCollecion(Collection collection){
        for(int i=0 ;i<10;i++){
            collection.add("str"+i%5);
        }
        return collection;
    }
    public static void printCollecionElement(Collection collection){
        for(Object a: collection){
            System.out.println(a.toString());
        }
    }
}
