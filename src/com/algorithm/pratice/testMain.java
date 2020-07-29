package com.algorithm.pratice;
import com.algorithm.QafterClass.Queue;
import com.algorithm.QafterClass.ResizingArrayStack;
import com.algorithm.QafterClass.Stack;
import com.algorithm.leetcodeTest.*;
import com.algorithm.leetcodeTest.*;
public class testMain {
    public static void main(String[] args) {


//        int[][] flag = new int[][]{
//            {3, 2, -1,-1,-1}, {2, -1, -2, -3,-3}, {1, 1, -3, -4,-4}
//        };
//

//            int a = 1234567898;
//            System.out.println(Reverse.reverse_1(a));
//        Long a = Long.parseLong("8646324351");

        //ResizingArrayStack Test
        ResizingArrayStack<Integer> resizingArrayStack = new ResizingArrayStack<>(10);
        resizingArrayStack.push(1);
        resizingArrayStack.push(2);
        resizingArrayStack.push(3);
        resizingArrayStack.push(4);

        //        System.out.println(resizingArrayStack.size());
//        for(Integer a : resizingArrayStack){
//            System.out.println(a);
//        }
//        Stack<Integer> stack = new Stack<>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        System.out.println(stack.size());
//
//        for(Integer a : stack){
//            System.out.println(a);
//        }

        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        for(Integer a : queue){
            System.out.println(a);
        }

    }

    public static int taijie(int n){
        if(n==1) return 1;
        if(n==2) return 2;
        return taijie(n-1)+taijie(n-2) ;
    }
}
