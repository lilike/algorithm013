package com.lilike.homework;

/**
 * 搜索二维矩阵
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 *
 * @Author llk
 * @Date 2020/10/27 17:08
 * @Version 1.0
 */
public class SearchMatrix {


    /**
     * 二分查找是最经典的
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0, right = row * col - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int x = middle / col;
            int y = middle % col;
            if (matrix[x][y] == target) {
                return true;
            }else if (matrix[x][y] > target) {
                right = middle - 1;
            }else if (matrix[x][y] < target) {
                left = middle + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}};

        boolean b = new SearchMatrix().searchMatrix(matrix, 3);
        System.out.println(b);


    }

}
