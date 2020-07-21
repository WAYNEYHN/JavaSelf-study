package com.algorithm.pratice;
import com.algorithm.leetcodeTest.*;
public class Recursion {
    public static void main(String[] args) {

        int[][] flag = new int[][]{
            {3, 2, -1,-1,-1}, {2, -1, -2, -3,-3}, {1, 1, -3, -4,-4}
        };

        CountNegatives countNegatives = new CountNegatives();
        countNegatives.CountNegatives_binarySearch(flag);
        System.out.println(taijie(10));
    }

    public static int taijie(int n){
        if(n==1) return 1;
        if(n==2) return 2;
        return taijie(n-1)+taijie(n-2) ;
    }
}
