package com.algorithm.Search;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4 , 5};
        for(int m : a){
            System.out.println(m);
        }
        Search(2, a, 0, a.length-1);
        System.out.println(Math.abs(-2147483648));

    }

//    public static void Search(int target, int a[]){
//        int lo = 0;
//        int hi = a.length-1;
//        int mid = (lo+hi)/2;
//        if(target > a[mid]){
//            Search(target, a, mid, hi);
//        }else if (target < a[mid]){
//            Search(target, a, lo, mid-1);
//        }
//    }

    public static void Search(int target, int a[], int left, int right ){
        if(right<left) System.out.println(-1);;
        int mid = left + (right - left)/2;
        System.out.println(mid);
        if(target > a[mid]){
            Search(target, a, mid+1, right);
        }else if (target < a[mid]){
            Search(target, a, left, mid-1);
        }else
            System.out.println(mid);

    }
}
