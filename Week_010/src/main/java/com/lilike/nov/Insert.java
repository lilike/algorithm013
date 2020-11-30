package com.lilike.nov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 插入区间
 * https://leetcode-cn.com/problems/insert-interval/
 *
 * @Author llk
 * @Date 2020/11/4 8:52
 * @Version 1.0
 */
public class Insert {

    /**
     * [[1,3],[6,7],[8,9],[12,15]]    [4,10]
     * 算法思路:
     * 原来的区间列表已经排序好了,新插入1个
     * 首先:
     * 使用一个指针指向 intervals的开头
     * 然后比较 intervals 的元素 和 newInterval里面的值
     * 也就是两个区间进行比较
     * [a,b]  [c,d]
     * <p>
     * 如果 b < c 那么 [a,b] 就在 [c,d] 的左侧
     * <p>
     * 如果不满足了呢?
     * <p>
     * 也就是 b >= c 了
     * 那么就合并为一个新的区间 [a,d]
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval };
        List<int[]> ans = new ArrayList<>();

        int i = 0;
        int l = intervals.length;
        while (i < l) {
            if (intervals[i][1] < newInterval[0]) {
                ans.add(intervals[i]);
                i++;
            } else {
                break;
            }
        }

        while (i < l && intervals[i][0] <= newInterval[1]) {
            newInterval = new int[]{ Math.min(intervals[i][0],newInterval[0]),Math.max(intervals[i][1],newInterval[1])};
            i++;
        }

        ans.add(newInterval);
        while (i < l) {
            ans.add(intervals[i++]);
        }

        return ans.toArray(new int[ans.size()][2]);


    }

    public static void main(String[] args) {

        int[][] intervals = new int[][]{{1,5}};
        int[] newInterval = new int[]{2,3};

        int[][] insert = new Insert().insert(intervals, newInterval);

        for (int[] ints : insert) {
            System.out.println(Arrays.toString(ints));
        }

    }


}
