package com.algorithm.pratice;

import java.util.Stack;

public class solutionForJZ5 {

    public static void main(String[] args) {
        solutionForJZ5 solutionForJZ5 = new solutionForJZ5();
        solutionForJZ5.push(1);
        solutionForJZ5.push(2);
        solutionForJZ5.push(3);
        System.out.println(solutionForJZ5.pop());
        System.out.println(solutionForJZ5.pop());
        solutionForJZ5.push(4);
        solutionForJZ5.push(5);
    }
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            stack1.push(node);



        }

        public int pop() {

            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            int a = stack2.pop();
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            return a ;

        }


}
