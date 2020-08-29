package com.algorithm.leetcodeTest;

public class IsPalindrome {
    public static boolean isPalindrome(int x){
        if(x < 0)
            return false;
        else if(x == 0)
            return true;
        else{
            int cur = 0;
            int num = x;
            while(num != 0){
                cur = cur*10 + num%10;
                num = num/10;
            }

            if(x == cur){
                return true;
            }
        }
        return false;
    }

    public static boolean isProlinrome_1(int x){
        if(x < 0) return false;
        String oldStr= "" + x;
        String newStr = new StringBuilder("" + x).reverse().toString();
        return oldStr.equals(newStr);
    }
}
