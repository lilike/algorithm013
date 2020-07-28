package com.lilike.homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {

        TwoSum twoSum = new TwoSum();




    }

    /**
     * 一遍过hash
     *
     * 后面的数会找到前面和它匹配的
     * @param nums
     * @param target
     * @return
     */
    public int[] solution2(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int comp = target - nums[i];
            if (map.keySet().contains(comp)) {
                return new int[]{map.get(comp),i};
            }else {
                map.put(nums[i],i);
            }
        }

        return null;


    }





    /**
     *  y = target - x
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] solution1(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.keySet().contains(target - nums[i])) {
                Integer j = map.get(target - nums[i]);
                if (i < j ) return new int[]{i,j};
                if (i > j ) return new int[]{j,i};


            }
        }

      return null;
    }


}
