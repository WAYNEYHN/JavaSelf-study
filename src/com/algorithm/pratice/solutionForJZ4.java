package com.algorithm.pratice;

import sun.reflect.generics.tree.Tree;

import java.util.Arrays;

public class solutionForJZ4 {
    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode a = reConstructBinaryTree(pre, in);
        scanTree(a);
    }

    public static void scanTree(TreeNode treeNode){
        if(treeNode==null)return;
        System.out.println(treeNode.val);
        scanTree(treeNode.left);
        scanTree(treeNode.right);
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in){

        if(pre.length ==0 || in.length == 0) return null;
        TreeNode treeNode = new TreeNode(pre[0]);
        for(int i = 0; i< in.length; i++){
            if(pre[0] == in[i]){



                int[] preLeft = Arrays.copyOfRange(pre, 1, i+1);
                int[] inleft = Arrays.copyOfRange(in, 0, i);
                treeNode.left = reConstructBinaryTree(preLeft, inleft);

                int[] preRight = Arrays.copyOfRange(pre, i+1, in.length);
                int[] inRight = Arrays.copyOfRange(in, i+1, in.length);
                treeNode.right = reConstructBinaryTree(preRight, inRight);
                break;
            }

        }
        return  treeNode;

    }
}
