package pratice.demo;

import pratice.demo.Array.stackArray;

import java.util.Scanner;

public class stackPra {
    public static void main(String[] args) {
        stackArray stack = new stackArray(10);
        stack.push("1001");
        stack.push("1002");
        stack.push("1003");
        stack.push("1004");
        stack.push("1005");
        stack.Show();
        System.out.println(stack.pop());
        stack.Show();
    }
}
