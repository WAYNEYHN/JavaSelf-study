package com.algorithm.leetcodeTest;

import java.util.HashSet;
import java.util.Stack;

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
