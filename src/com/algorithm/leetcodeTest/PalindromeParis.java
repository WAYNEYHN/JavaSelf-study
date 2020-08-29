package com.algorithm.leetcodeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromeParis {
    public static List<List<Integer>> palindromePairs(String[] words){
        List<List<Integer>> a = new ArrayList<>();
        int num = 0;
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words.length; j++){
                if(i==j) continue;
                String str_1 = new StringBuilder(words[i]+words[j]).reverse().toString();
                String str_2 = new StringBuilder(words[i]+words[j]).toString();
                if(str_1.equals(str_2)){
                    a.add(new ArrayList<Integer>(Arrays.asList(i,j)));
                }
            }
        }
        return a;
    }

}
