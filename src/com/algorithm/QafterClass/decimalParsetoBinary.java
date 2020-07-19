package com.algorithm.QafterClass;

import java.util.Scanner;

public class decimalParsetoBinary {
    public static void main(String[] args) {
        System.out.println("请输入一个正整数：");
        Scanner scanner = new Scanner(System.in);
        Integer decimal = Integer.parseInt(scanner.nextLine());
        String result = "";
        for(int n=decimal; n>0;n/=2){
            result =  n%2 + result ;
        }
        System.out.println(result);
        System.out.println(lg(decimal));
    }

    /**
     * 返回不大于log2(N)的最大整数
     * @param N
     * @return
     */
    public static int lg(int N){
        int i = 0;
        while(pow(2,i) < N){
            i++;
        }
        return i;
    }
    public static int pow(int x,int y){
        int temp = x;
        for(;y>0;y--){
            x=x*temp;
        }
        return x;
    }
}
