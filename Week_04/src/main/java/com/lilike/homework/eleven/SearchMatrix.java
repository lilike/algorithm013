package com.lilike.homework.eleven;

/**
 *
 * 搜索二维矩阵
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 * @Author llk
 * @Date 2020/8/19 21:21
 * @Version 1.0
 */
public class SearchMatrix {


    /**
     *  依然是采用二分查找法
     *   首先计算出总的长度 total = matrix.length * matrix[1].length
     *   计算出中间的索引,然后进行转换
     *   martrix[mid/m][mid%n]
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int m = matrix[0].length;
        int n = matrix.length * matrix[0].length;

        int left = 0;
        int right = n-1;
        int middle;

        while (left <= right) {
            middle = left + (right - left) / 2;
            int x = middle / m;
            int y = middle % m;
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] < target) {
                left = middle + 1;
            }else {
                right = middle -1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new SearchMatrix().searchMatrix(new int[][]{{1,1}},2));
    }

}
