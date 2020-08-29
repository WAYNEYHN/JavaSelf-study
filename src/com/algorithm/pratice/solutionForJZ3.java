package com.algorithm.pratice;

import java.util.ArrayList;
import java.util.Stack;

public class solutionForJZ3 {
    public ArrayList<Integer> printList(ListNode listNode){

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        while(listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while(!stack.isEmpty()){
            arrayList.add(stack.pop());
        }
        return arrayList;
    }
}
