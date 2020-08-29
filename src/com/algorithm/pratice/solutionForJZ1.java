package com.algorithm.pratice;

public class solutionForJZ1 {
    public boolean Find(int target, int[][] array){
        if(array == null) return false;
        int cols = array[0].length;
        int rows = array.length;
        int row = 0;
        int col = cols - 1;
        while(row<rows && col>=0){
            if(array[row][col] == target) return true;
            else if(array[row][col] > target) col--;
            else row++;
        }
        return false;

    }
}
