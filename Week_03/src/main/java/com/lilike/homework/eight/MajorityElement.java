package com.lilike.homework.eight;

/**
 * https://leetcode-cn.com/problems/majority-element/
 * 多数元素
 *
 * @Author llk
 * @Date 2020/8/14 16:19
 * @Version 1.0
 */
public class MajorityElement {


    /**
     * 分治法来进行求解
     *      1. 首先如果一个数是多数,也就是数量超过了 nums.length/2
     *      2. 那么把这个nums 数组劈成两半 l 和 m
     *      3. 一定就会得到 l 和 m 的多数 一定有最终结果 否则就不满足1了, (l+m)/2
     *      4. 那么如果 l的多数 = m 的多数 ,就直接返回
     *      5. 如果递归数组最后只剩下一个元素,直接返回就是多数
     *      6. 如果左边不等于右边,就需要去整个数组里面查询统计次数多的了
     *
     *
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        return majorityElement(nums,0,nums.length-1);
    }
    public int majorityElement(int[] nums,int left,int right) {

        if (left == right) return nums[left];

        // 进行拆分
        int middleIndex = (right - left)/2 + left;

        int leftN = majorityElement(nums,left,middleIndex);
        int rightN = majorityElement(nums,middleIndex+1,right);

        if (leftN == rightN) {
            return leftN;
        }
        return findBigNum(nums,leftN,rightN,left,right);
    }

    private int findBigNum(int[] nums, int leftN, int rightN, int left, int right) {
        int count = 0;
        int aount = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == leftN) {
                count++;
            }else if (nums[i] == rightN) {
                aount++;
            }
        }
        return count > aount ? leftN : rightN;
    }


    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
