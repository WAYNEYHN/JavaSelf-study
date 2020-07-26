package com.algorithm.leetcodeTest;

import java.util.Stack;

public class Reverse {

    /**
     * 使用栈来实现整数反转
     * 发现有点蠢，通过运算就能得到用栈有点小题大作了
     * @param x
     * @return
     */
    public static int reverse(int x){

        int flag = 0;
        if(x < 0) {
            x = -x;
            flag = 1;
        }
        String xString = Integer.valueOf(x).toString();
        Stack<Character> a = new Stack<>();
        char []result = new char[xString.length()];
        for(int i = 0; i < xString.length(); i++){
            a.push(xString.charAt(i));
        }
        for(int i = 0; i < xString.length(); i++){
             result[i] = a.pop();
        }

        try{
            x = Integer.parseInt(String.valueOf(result));
        }catch (Exception ex){
            return 0;
        }

        if(flag == 1) x = -x;

        return x;

    }


    /**
     * 整数反转
     * @param x
     * @return
     */
    public static int reverse_1(int x){
            long result = 0;

            while(x != 0){
                result = result*10 + x%10;
                x = x / 10;
            }

            return (int)result==result? (int)result:0;
    }

}
