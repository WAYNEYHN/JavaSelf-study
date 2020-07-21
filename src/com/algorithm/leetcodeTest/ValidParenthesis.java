package com.algorithm.leetcodeTest;

import java.util.HashSet;
import java.util.Stack;

/**
 *进行左右括号的匹配，监测字符串中所有的括号都是成对的
 */
public class ValidParenthesis {
    public  boolean isvaild(String s){
        String LastParenthesis = ")}]";
        String FirstParenthesis = "({[";
        if(s.isEmpty()){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        if(s.length()%2 == 0){
            for(char temp : s.toCharArray()){
                if(FirstParenthesis.indexOf(temp) != -1){
                    stack.push(LastParenthesis.charAt(FirstParenthesis.indexOf(temp)));

                }
                else if(stack.isEmpty()||stack.pop()!=temp){
                    return false;
                }


            }
        }else{
            return false;
        }
        return stack.isEmpty();
    }


}
