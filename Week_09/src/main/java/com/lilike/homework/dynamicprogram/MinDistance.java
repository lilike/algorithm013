package com.lilike.homework.dynamicprogram;

/**
 * 最小编辑距离
 * https://leetcode-cn.com/problems/edit-distance/
 *
 * @Author llk
 * @Date 2020/9/24 16:34
 * @Version 1.0
 */
public class MinDistance {

    /**
     * 最小编辑距离可以是 插入 删除 替换
     * <p>
     * dp[i][j]
     * 两个维度, i 表示的是 A 单词的索引 从 0--i A[0:i]  j 表示 的 B单词 B[0:j]
     * dp[i][j] 表示的就是  A[0:i] 和 B[0:j] 的最小的编辑距离
     * <p>
     * 1. 第一种情况: 两个字母都是以X结尾
     * A:  ....X
     * B:  ....X
     * <p>
     * 由于最后单词结尾相同,所以把最后两个单词同时删掉
     * if ( A.chat[i] == B.chat[j])
     * dp[i][j] = dp[i-1][j-1]
     * <p>
     * 2. 第二种情况: 两个单词结尾不相同
     * A : .....X
     * B : .....Y
     * <p>
     * dp[i][j] = Math.min (
     * dp[i-1][j] --> 表示把A的结尾X删掉,新串与B的最小编辑距离
     * dp[i][j-1] --> 表示把B的结尾Y删掉,新串与A的最小编辑距离
     * dp[i-1][j-1] --> 表示 X替换成 Y 或是把 Y 替换成 X
     * ) + 1
     * <p>
     * 一般我们不会新增,即使两个字符串长度不同,我们也可以删掉长的,所以这个是覆盖了所有的情况了
     * BaseCase:
     * dp[0][0] = 0;
     * dp[1][0] = 1;
     * dp[2][0] = 2;
     * ....
     * dp[A.length][0] = A.length;
     * <p>
     * 反之亦然
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {

        int a = word1.length();
        int b = word2.length();

        int[][] dp = new int[a + 1][b + 1];
        dp[0][0] = 0; // 空串和空串的最小编辑距离是0
        for (int i = 1; i < a + 1; i++) {
            dp[i][0] = i;
        }

        for (int j = 1; j < b + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < a + 1; i++) {
            for (int j = 1; j < b + 1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(
                            dp[i - 1][j], dp[i][j - 1]
                    ),dp[i-1][j-1])+1;
                }
            }
        }
        return dp[a][b];
    }

    public static void main(String[] args) {

    }

}
