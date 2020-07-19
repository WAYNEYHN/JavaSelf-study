package com.algorithm.QafterClass;

public class MatrixClass {
    /**
     * 向量点乘
     * @param x
     * @param y
     * @return
     */
    public static double dot(double[] x, double[] y){
        if(x.length != y.length) return -1;
        double result = 0;
        for(int i=0; i<x.length;i++){
            result+=x[i]*y[i];
        }
        return result;
    }

    /**
     * 矩阵和矩阵之积
     * @param a
     * @param b
     * @return
     */
    public static double[][] mult(double[][] a, double[][] b){
        if(a.length != b[0].length) return null;
        double[][] temp = new double[a.length-1][b[0].length-1];

        for(int i=0;i<a.length;i++) {
            for(int j=0;j<b[0].length;j++) {
                for(int k=0;k<a[0].length;k++) {
                    temp[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return temp;
    }

    /**
     * 转置矩阵
     * @param a
     * @return
     */
    public static  double[][] transpose(double[][] a){
        double[][] result = new double[a[0].length][a.length];
        for(int i=0; i < a[0].length; i++){
            for (int j=0; j < a.length; j++){
                result[i][j] = a[j][i];
            }
        }
        return result;
    }

    /**
     * 矩阵和向量之积
     * @param a
     * @param x
     * @return
     */
    public static double[] mult(double[][]a, double[] x) {
        return null;
    }

    /**
     * 向量和矩阵之积
     * @param y
     * @param a
     * @return
     */
    public static double[] mult(double[] y, double[][] a){
        return null;
    }
}
