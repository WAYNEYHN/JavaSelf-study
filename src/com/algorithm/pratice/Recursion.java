package com.algorithm.pratice;

public class Recursion {
    public static void main(String[] args) {

        System.out.println(taijie(10));
    }

    public static int taijie(int n){
        if(n==1) return 1;
        if(n==2) return 2;
        return taijie(n-1)+taijie(n-2) ;
    }
}
