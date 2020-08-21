package com.lilike.homework.ten;

/**
 * https://leetcode-cn.com/problems/jump-game/
 * 跳跃游戏
 *
 * @Author llk
 * @Date 2020/8/19 14:29
 * @Version 1.0
 */
public class CanJump {

    private boolean flag = false;


    /**
     * 实时更新最远可以到达的距离,遍历到倒数第二个的时候,如果最远距离是 >= nums.length的时候,就可以了
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {

        /*  [0,2,3]  */
        // 最远可以跑动的距离,实时更新
        int ans = 0;

        for (int i = 0; i < nums.length-1; i++) {
            // 当前能跑到的最远距离
            if (i <= ans) {
                ans = Math.max(ans,nums[i]+i);
            }
            // 如果过程中出现了呢
            if (ans > nums.length - 1) return true;
        }

        return ans >= nums.length-1;
    }



        /**
         * 采用深度优先的搜索方式
         * @param nums
         * @return
         */
    public boolean canJump(int[] nums) {

        dfs(nums,0);
        return flag;
    }

    private void dfs(int[] nums, int nextIndex) {

        if (nextIndex > nums.length-1) return;
        if (nextIndex == nums.length-1) flag = true;

        int num = nums[nextIndex];

        for (int i = 1; i <= num; i++) {
            dfs(nums,nextIndex + i);
        }

    }




    public static void main(String[] args) {
        System.out.println(new CanJump().canJump2(new int[]{2,3,1,1,4}));
    }

}
