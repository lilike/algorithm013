package com.lilike.nov;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 * 根据身高重建队列
 *
 * @Author llk
 * @Date 2020/11/16 9:04
 * @Version 1.0
 */
public class ReconstructQueue {

    /**
     * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]] => [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
     * <p>
     * 首先按照身高进行从小到大排序
     * <p>
     * [[4,4],[5,0],[5,1],[6,1],[7,0],[7,1]]
     * <p>
     * 创建一个队列
     * <p>
     * [[],[],[],[],[],[]]
     * <p>
     * 放入之前需要预留的坑就是当前的people[1] + 1
     * <p>
     * 然后遵循有坑就放的原则就可以了
     * <p>
     * <p>
     * [[5,0],[7,0],[5,1],[4,4],[6,1],[7,1]]
     */
    public int[][] reconstructQueue(int[][] people) {

        // sort
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }else {
                return o2[1] - o1[1];
            }
        });

        // create a int[][]

        int[][] res = new int[people.length][];

        for (int i = 0; i < people.length; i++) {
            int space = people[i][1] + 1;
            for (int j = 0; j < people.length; j++) {
                if (res[j] == null) {
                    space--;
                    if (space == 0) {
                        res[j] = people[i];
                        break;
                    }
                }
            }

        }

        return res;
    }

    public static void main(String[] args) {

        int[][] ints = new ReconstructQueue().reconstructQueue(new int[][]{
                {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}}
        );

        for (int i = 0; i < ints.length; i++) {
            System.out.print(Arrays.toString(ints[i]));
        }

    }

}
