package com.lilike.daily;

import java.util.*;

/**
 * 数组反转
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 *
 * @file ArrayIntersect.java
 * @author lyric
 * @date 2020/8/3
 */
public class ArrayIntersect {

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,3}, nums2 = {2,3};

        int[] intersect = new ArrayIntersect().intersect1(nums1, nums2);
        System.out.println(Arrays.toString(intersect));
    }


    /**
     *  把数据量较大的数组放入到hashtable中
     *  key : num value : count
     *
     *  遍历数据量较小的数组
     *
     *  然后去hashtable中获取value
     *
     *  如果获取到了, > 0 则 -1操作,并且存入结果
     *
     *  否则跳过
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        // 默认让nums1是大的数据
        if (nums1.length < nums2.length) {
            return intersect1(nums2,nums1);
        }

        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        // 存入hashtable
        for (int i = 0; i < nums1.length; i++) {
            if (map.keySet().contains(nums1[i])){
                map.put(nums1[i],map.get(nums1[i])+1);
            }else {
                map.put(nums1[i],1);
            }
        }

        int index = 0;
        int[] result = new int[nums1.length];
        // 遍历nums2
        for (int i : nums2) {
            if (map.get(i) != 0 && map.get(i) > 0) {
                result[index++] = i;
                map.put(i,map.get(i)-1);
            }
        }
        return Arrays.copyOf(result, index);
    }











    /**
     *  方法1 : 把数组大的存入到hash表中
     *  方法2 : m * n 时间复杂度, 遍历小数组,然后遍历大数组,如果用过的索引存入到list里面
     *
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> usedIndex = new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        if (nums1.length > nums2.length) {
            findBoth(nums1, nums2, usedIndex, result);
        }else {
            findBoth(nums2, nums1, usedIndex, result);
        }
        int index=  0;
        int[] resultArr = new int[result.size()];
        for (Integer r : result) {
            resultArr[index++] = r;
        }
        return resultArr;
    }

    private void findBoth(int[] nums1, int[] nums2, List<Integer> usedIndex, List<Integer> result) {
        for (int i = 0; i < nums2.length; i++) {
            int a = nums2[i];
            for (int j = 0; j < nums1.length; j++) {
                if (nums1[j] == a && !usedIndex.contains(j)) {
                    result.add(a);
                    usedIndex.add(j);
                    break;
                }
            }
        }
    }

}
