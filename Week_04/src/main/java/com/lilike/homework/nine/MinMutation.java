package com.lilike.homework.nine;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/
 *  最小基因变化
 * @Author llk
 * @Date 2020/8/17 16:21
 * @Version 1.0
 */
public class MinMutation {

    private Integer minStep = Integer.MAX_VALUE;

    private Set<String> visited = new HashSet<>();
    /**
     * 我把这道题可以看成是左括号,右括号问题
     * 每个字符 只能是 A C G T
     * 那么我每次替换这个字符串里面一个字符为ACGT,并且校验是否存在于合法基因库里面,如果存在,就继续,不存在 backTrack
     *
     *
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation1(String start, String end, String[] bank) {
        Set<String> bankSet = Arrays.stream(bank).collect(Collectors.toSet());
        char[] jySet = new char[]{'A','C','G','T'};
        khDfs(start,end,jySet,bankSet,0);
        return minStep == Integer.MAX_VALUE ? -1 : minStep;
    }

    private void khDfs(String start, String end, char[] jySet, Set<String> bankSet, int count) {

        // terminator
        if (start.equals(end)) {
            minStep = Math.min(count,minStep);
        }

        char[] startChar = start.toCharArray();

        for (int i = 0; i < startChar.length; i++) {
            char oldChar = startChar[i];

            for (char c : jySet) {
                if (c == oldChar) continue;
                startChar[i] = c;
                String newString = new String(startChar);
                if (bankSet.contains(newString) && !visited.contains(newString)) {
                    visited.add(newString);
                    khDfs(newString,end,jySet,bankSet,count+1);
                    visited.remove(newString);
                }
            }
            startChar[i] = oldChar;
        }
    }


    /**
         * 采用DFS 深度优先遍历 和回溯的方式来进行
         *  bank 里面有很多的基因库  我们遍历这个基因库
         *      然后找到基因库里面与当前start相差字符数为1的,然后深入下去,继续寻找,直到start == end ,那么就输出level
         *  出来之后,移除掉已经用过的基因库中的基因
         *  每次得到的结果与之前得到的结果进行比较
         *  如果比原来的结果小,那么就重新赋值
         *
         * @param start
         * @param end
         * @param bank
         * @return
         */
    public int minMutation(String start, String end, String[] bank) {

        if (start.equals(end)) return 0;
        dfs(start,end,bank,new HashSet<>(),0);
        return minStep == Integer.MAX_VALUE ? -1 : minStep;
    }

    /**
     *
     * @param start 开始的基因
     * @param end 结束的基因
     * @param bank 基因库
     * @param stepSet 访问过的基因
     * @param step 一共多少步
     */
    private void dfs(String start, String end, String[] bank, HashSet<Object> stepSet, int step) {
        System.out.print(start + "-->");
        if (start.equals(end)) {
            System.out.println(end);
            minStep = minStep > step ? step : minStep;
        }

        for (int i = 0; i < bank.length; i++) {
            String jy = bank[i];
            int diff = 0;
            for (int j = 0; j < jy.length(); j++) {
                if (start.charAt(j) != jy.charAt(j)) {
                    diff++;
                    if (diff > 1) break;
                }
            }

            if (diff == 1 && !stepSet.contains(jy)) {
                stepSet.add(jy);
                dfs(jy,end,bank,stepSet,step+1);
                stepSet.remove(jy);
            }

        }


    }

    public static void main(String[] args) {

        MinMutation minMutation = new MinMutation();
//        minMutation.minMutation1("hit","cog",new String[]{"hot","dot","dog","lot","log","cog"});
        minMutation.minMutation1("AAAAACCC","AACCCCCC",new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"});
        System.out.println(minMutation.minStep);


    }


}
