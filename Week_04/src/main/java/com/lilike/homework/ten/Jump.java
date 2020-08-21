package com.lilike.homework.ten;

/**
 * @Author llk
 * @Date 2020/8/19 15:10
 * @Version 1.0
 */
public class Jump {

    public int jump(int[] nums) {

        int step = 0;
        int end = 0; // 一次可以跳到的最远边界,最开始不动就是0
        int maxPosition = 0; // 当前位置可以跳到的最远位置
        // 最后一个不要计算了
        for (int i = 0; i < nums.length-1; i++) {
            maxPosition = Math.max(maxPosition,nums[i] + i);
            // 如果到达了边界,那么就更新边界,表示已经跳完一步了
            if (i == end) {
                end = maxPosition;
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {



    }

}
