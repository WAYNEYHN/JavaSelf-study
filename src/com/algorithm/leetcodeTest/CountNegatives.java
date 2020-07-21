package com.algorithm.leetcodeTest;

public class CountNegatives {
    /**
     * 第一次尝试：使用
     * @param grid 二维数组
     * @return  数组中负数的个数
     */
    public int CountNegatives(int [][]grid){
        int result = 0;
        int grid_lenght = grid.length;
        int grid_1_length = grid[0].length;
        for(int i = 0; i < grid_lenght; i++){
            for(int j = 0; j < grid_1_length; j++){
                if(grid[i][j] < 0){
                    result +=  grid_1_length- j;
                    break;
                }
            }
        }
        System.out.println(result);
        return result;

    }

    /**
     * 通过二分查找的方法进行每一行负数的查找
     * @param grid 二维数组
     * @return    数组中负数的个数
     */
    public int CountNegatives_binarySearch(int [][]grid){
        int result = 0;
        int left, right;
        for(int []temp : grid){
            left = 0;
            right = temp.length;

            if(temp[right-1] >= 0) {
                result += 0;
                continue;
            }
            if(temp[left] <0){
                result += right;
                continue;
            }
            while(left < right){
                int mid = left + ((right - left) >> 1);
                if(temp[mid]>=0){
                    left = mid + 1;
                }else {
                    if(temp[mid -1] >= 0){
                        result += temp.length - mid;
//
//                        System.out.println(mid);
                        break;
                    }
                    right = mid  ;
                }
            }

        }
//        System.out.println(result);
        return result;
    }
}
