package com.lilike.homework;

/**
 * @Author llk
 * @Date 2020/10/22 17:14
 * @Version 1.0
 */
public class FindMin {

    /**
     * 找到螺旋数组里面的最小值
     * [3,4,5,1,2]
     * <p>
     * 首先需要判断这是不是一个旋转的数组
     * <p>
     * 判断的方法就是
     * nums[n] < nums[0]
     * <p>
     * 如果是旋转数组才会进行下面的操作
     * <p>
     * 然后进行二分搜索
     * <p>
     * 最小值的特点就是:
     * 1.  最小值 < 最小值所有右边边的元素
     * 2. 最小值右边的所有元素 > 最小值
     * 3. 否则
     * a. 如果当前值 < 左边的元素.说明最小值在左边
     * b. 如果当前值 > 右边的元素,说明最小值在右边
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0, right = nums.length - 1;

        if (nums[left] < nums[right]) {
            return nums[left];
        }

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            if (nums[mid] < nums[0]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }


        }

        return -1;
    }

    public int findMinII(int[] nums) {

        if (nums.length == 1) return nums[0];

        int left = 0, right = nums.length - 1;

        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] < nums[right]) {
                right = middle;
            }else if (nums[middle] > nums[right]) {
                left = middle + 1;
            }
        }
        return nums[left];
    }


    public static void main(String[] args) {

        int[] nums = {2, 3, 4, 5, 1};
        System.out.println(new FindMin().findMinII(nums));


    }


}
