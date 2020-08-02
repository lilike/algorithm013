package com.lilike.homework;

/**
 * 删除排序数组的重复项
 *
 * @author lyric
 * @file RemoveDuplicates.java
 * @date 2020/8/2
 */
public class RemoveDuplicates {

    public static void main(String[] args) {

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        RemoveDuplicates r = new RemoveDuplicates();
        int i = r.solution1(nums);

        for (int j = 0; j < i + 1; j++) {
            System.out.println(nums[j]);
        }

    }


    /*
         首先有一个指针是指向最新元素
         然后向后迭代
         因为是排序数组,所以相同的都是放到一起的
         一个变量用来存储最新的值
     */
    public int solution1(int[] nums) {

        if (nums == null || nums.length < 1) {
            return 0;
        }

        int newIndex = 0;

        int newNum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (newNum == nums[i]) {
                continue;
            } else {
                newIndex++;
                nums[newIndex] = nums[i];
                newNum = nums[i];
            }
        }

        return newIndex + 1;
    }

}
