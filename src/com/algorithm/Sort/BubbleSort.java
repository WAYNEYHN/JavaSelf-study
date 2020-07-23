package com.algorithm.Sort;



public class BubbleSort {
    /**
     * 冒泡排序
     * 时间复杂度 O(n2)
     * @param array
     */
    public static void bubbleSort(int []array){
        int flag = array.length;

        //外层循环确定一共需要比较多少轮
        for(int j = 0; j< array.length; j++){
            int tag = 0; //设置标志位，判断此次循环是否有进行交换
            //内层循环由于每次大循环都能确定一个数的最终位置，所以循环次数应该递减
            for(int i = 0; i < flag -1 ; i++){
                if(array[i] > array[i+1]){
                    int temp = 0;
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    tag++;
                }
            }
            if(tag == 0)
                break;
            flag--;
        }

    }
}
