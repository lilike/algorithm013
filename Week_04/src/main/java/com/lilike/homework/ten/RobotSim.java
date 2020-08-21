package com.lilike.homework.ten;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/walking-robot-simulation/
 * 模拟行走机器人
 *
 * @Author llk
 * @Date 2020/8/19 14:07
 * @Version 1.0
 */
public class RobotSim {

    /**
     * 欧式距离平方就是 x^2 + y^2
     * <p>
     * 注意:
     * 1. 控制机器人一步一步的走,如果遇到障碍物就停下来,所以需要一个for loop
     *
     * @param commands
     * @param obstacles
     * @return
     */
    public int robotSim(int[] commands, int[][] obstacles) {

        // 分别保存 北 东 南 西 走一步的坐标变化
        // 索引值 0 1 2 3 分别代表 北 东 南 西
        int[][] zb = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int ans = 0;

        int direction = 0; // 初始化方向
        int x = 0; // 初始化x方向坐标
        int y = 0; // 初始化y方向坐标

        // 把障碍物存入到hashSet,目的就是方便精确搜索
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        // 遍历指令
        for (int command : commands) {
            int next_x = 0;
            int next_y = 0; // 临时变量 用来保存y 方便回退, 同理 next_x
            if (command > 0) {
                // 朝着当前的方向前进
                for (int i = 0; i < command; i++) {

                    next_x = x + zb[direction][0];
                    next_y = y + zb[direction][1];

                    // 遇到障碍物了,不要继续前进了
                    if (obstacleSet.contains(next_x + "," + next_y)) {
                        break;
                    }

                    // 临时变量转正,欧式距离转正
                    x = next_x;
                    y = next_y;
                    ans = Math.max(ans, x * x + y * y);
                }

            } else {
                direction = command == -1 ? (direction + 1) % 4 : (direction + 3) % 4;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        RobotSim robotSim = new RobotSim();
        int i = robotSim.robotSim(new int[]{4,-1,4,-2,4}, new int[][]{{2,4}});
        System.out.println(i);

    }
}
