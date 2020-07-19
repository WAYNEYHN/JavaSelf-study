package pratice.demo.Enum;

import pratice.demo.Enum.Color;

import java.util.Arrays;
import java.util.Scanner;


public class eunmTest {
    public static void main(String[] args) {
//        for(Color c : Color.values()){
//            System.out.println(c.getName()+" "+c.getIndex());
//            System.out.println(c.toString());
//            System.out.println(c.ordinal());
//        }

        System.out.println(Color.valueOf("YELLOW").toString());
        Scanner in = new Scanner(System.in);
        System.out.println("请输入枚举的名字");
        String c = in.next();
        Color color = Color.valueOf(c.toUpperCase().trim());
        System.out.println(color.toString());

    }



}

