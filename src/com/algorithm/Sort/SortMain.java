package com.algorithm.Sort;
import com.algorithm.Sort.*;

/**
 *
 * 归并排序
 */
public class SortMain {
    public static void main(String[] args) {
        int[] a = {26, 5, 98, 108, 28, 99, 100, 56, 34, 1};
        printArray(a);
//        MergSort.mergeSort(a);
//        BubbleSort.bubbleSort(a);
//        InsertionSort.insertionSort(a);
        printArray(a);

    }

    /**
     * 输出数组
     * @param temp 目标数组
     */
    public static void printArray( int temp[]) {
        for (int i = 0; i < temp.length; i++)
            System.out.print(temp[i] + " ");
        System.out.println();
    }


}



