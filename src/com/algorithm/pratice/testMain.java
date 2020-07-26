package com.algorithm.pratice;
import com.algorithm.leetcodeTest.*;
public class testMain {
    public static void main(String[] args) {


//        int[][] flag = new int[][]{
//            {3, 2, -1,-1,-1}, {2, -1, -2, -3,-3}, {1, 1, -3, -4,-4}
//        };
//

            int a = 1234567898;
            System.out.println(Reverse.reverse_1(a));
//        Long a = Long.parseLong("8646324351");

    }

    public static int taijie(int n){
        if(n==1) return 1;
        if(n==2) return 2;
        return taijie(n-1)+taijie(n-2) ;
    }
}
