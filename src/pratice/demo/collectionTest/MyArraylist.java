package pratice.demo.collectionTest;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class MyArraylist{
    public static void main(String[] args){
        ArrayList arrayList = new ArrayList(12);
        arrayList.add(10);

        arrayList.add("123");

        String a = String.valueOf(arrayList.get(1));
        for(Object e : arrayList){
            System.out.println(e);
            try{
                System.out.println(arrayList.get(1));
            }catch (Exception ex){
               ex.printStackTrace();
            }

        }
        arrayList.remove(1);

        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        linkedList.add(1);
        linkedList.add(2);
        System.out.println(linkedList.get(1));
    }


}
