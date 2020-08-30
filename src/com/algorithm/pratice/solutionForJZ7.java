package com.algorithm.pratice;

public class solutionForJZ7 {

    public static void main(String[] args) {
        System.out.println(Fibonacci(1000));
    }
    public static int Fibonacci(int n){
        if(n==1) return 1;
        if(n==2) return 1;
        return Fibonacci(n-1) + Fibonacci(n-2);
    }
}
