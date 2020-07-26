package pratice.demo.Map;

import com.algorithm.Sort.InsertionSort;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;


/**
 * Map最常见的实现类是hashmap
 * 如果将自己写的类作为key， 那么必须实现hashcode() 和 equals()方法，并且保证不可变
 */
public class Maptest {
    public static void MapIOTest(){
        Map<String , Integer> m_map = createMap(20);
        m_map.put(null, 0);
//Returns the value to which the specified key is mapped,
//or {@code null} if this map contains no mapping for the key.
        System.out.println("the value of My_key12:" + m_map.get("My_key12"));
        System.out.println("the value of null:" + m_map.get(null));
        System.out.println("the value of 11:" + m_map.get(11));



        System.out.println("------------------遍历key ， value--------------------");
        for(Map.Entry<String , Integer> entry : m_map.entrySet()){
//            Entry是Map的一个内部类
//            System.out.println(entry instanceof String);
            System.out.println("key :" + entry.getKey() + "   value :" + entry.getValue());
        }

        System.out.println("------------------遍历key--------------------");
        for(String key: m_map.keySet()){
            System.out.println(m_map.get(key));
        }

        System.out.println("------------------遍历value-------------------");
        for(Integer value: m_map.values()){
            System.out.println(value);
        }
    }

    public static Map<String, Integer> createMap(int n){
        Map<String, Integer> temp = new HashMap<>();
        String st = "My_key";
        for(int i = 0; i < n; i++){
            temp.put(st+i, i);
        }
        return temp;
    }

}
