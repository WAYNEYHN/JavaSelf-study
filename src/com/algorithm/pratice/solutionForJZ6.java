package com.algorithm.pratice;

public class solutionForJZ6 {
    public static void main(String[] args) {
        int[] a = new int[]{4, 5, 6, 7,  1, 2, 3};
        System.out.println(minNumberInRotateArray(a));
    }
    public static int minNumberInRotateArray(int[] array){
        if(array.length == 0) return 0;
        int left = 0;
        int right = array.length -1;
        while(left<right){
           int mid = (left+right)/2;
           if(array[mid]<array[left]){
               if(array[mid]<array[mid-1]) return array[mid];
               else right = mid-1;
           }
           else if(array[mid] > array[right]){
               if(array[mid] > array[mid+1])  return array[mid+1];
               left = mid +  1;
           }
       }
       return 0;
    }
}
