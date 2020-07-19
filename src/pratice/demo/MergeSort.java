package pratice.demo;

import javax.swing.*;

public class MergeSort {
    public void MergeSort_1(int[] temp){
        Sort(temp, 0, temp.length-1);

    }
    private static void Sort(int[] a, int left, int right){
        if(left >= right)
            return;
        int mid = (left + right) /2;
        Sort(a, left, mid);
        Sort(a, mid+1, right);
        merge(a, left, mid, right);
    }

    private static  void merge(int[] a, int left,int mid, int right){


    }

}
