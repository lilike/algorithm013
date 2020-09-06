package com.lilike.daily;

/**
 *  预测赢家
 *  https://leetcode-cn.com/problems/predict-the-winner/
 * @Author llk
 * @Date 2020/9/1 8:49
 * @Version 1.0
 */
public class PredictTheWinner {

    int maxSum = Integer.MIN_VALUE;
    /**
     * 使用回溯算法
     * @param nums
     * @return
     */
    public boolean PredictTheWinner(int[] nums) {
        if ( nums == null || nums.length == 0) return false;
        int dg = dg(nums, 0, nums.length - 1, 0, true);
        return dg >= 0;
    }

    /**
     *
     * @param nums
     * @param start
     * @param end
     * @param sum
     * @param flag true是先手
     */
    private int  dg(int[] nums, int start, int end, int sum,boolean flag) {

        if (start > end) {
            return sum;
        }

        if (flag) {
            // 先手
            int x1 = dg(nums, start + 1, end, sum + nums[start], false);
            int x2 = dg(nums,start,end-1,sum+nums[end],false);
            return Math.max(x1,x2);
        }else {
            // 后手
            int h1 = dg(nums,start+1,end,sum-nums[start],true);
            int h2 = dg(nums,start,end-1,sum-nums[end],true);
            return Math.min(h1,h2);
        }
    }


    public static void main(String[] args) {
        System.out.println(new PredictTheWinner().PredictTheWinner(new int[]{0}));
    }
}
