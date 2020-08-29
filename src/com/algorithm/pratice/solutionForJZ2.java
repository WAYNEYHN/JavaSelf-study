package com.algorithm.pratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class solutionForJZ2 {

    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("wo are you")));
    }
    public static String  replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == ' ') sb.append("%20");
            else sb.append(c);
        }
        return sb.toString();

    }
}
