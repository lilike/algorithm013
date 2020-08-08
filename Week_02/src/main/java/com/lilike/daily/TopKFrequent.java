package com.lilike.daily;

import java.util.*;

/**
 *  https://leetcode-cn.com/problems/top-k-frequent-elements/comments/
 *  前K个高频元素
 *
 *
 * @Author llk
 * @Date 2020/8/6 11:23
 * @Version 1.0
 */
public class TopKFrequent {

    public static void main(String[] args) {

        int[] nums = {4,1,-1,2,-1,2,3};
        System.out.println(Arrays.toString(topKFrequent(nums,2)));


    }

    /*
      思路1 : 时间复杂度O(n) 直接遍历一遍,计数,维护一个对象,两个属性  num 和 count
      首先是存入hashMap计数
      存入count的大根堆里面,获取的时候就是O(nlogn)的时间复杂度
     */
    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();
        // 1. 计数存入hash表
        for (int num : nums) {
            if (map.get(num) == null) {
                map.put(num,0);
            }
            map.put(num,map.get(num)+1);
        }
        // 存入count大根堆里面
        PriorityQueue<Map<String,Integer>> heap = new PriorityQueue<>((o1, o2) -> -o1.get("count")+o2.get("count"));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Map<String,Integer> temp = new HashMap<>();
            temp.put("num",entry.getKey());
            temp.put("count",entry.getValue());
            heap.add(temp);
        }

        // 取前面k个
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll().get("num");
        }

        return result;
    }


}

