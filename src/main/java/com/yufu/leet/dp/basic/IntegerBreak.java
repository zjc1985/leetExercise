package com.yufu.leet.dp.basic;

import java.util.Arrays;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2 输出: 1 解释: 2 = 1 + 1, 1 × 1 = 1。 示例 2:
 * <p>
 * 输入: 10 输出: 36 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 说明: 你可以假设 n 不小于 2 且不大于 58。
 */
public class IntegerBreak {

  public static void main(String[] args) {
    new Solution().integerBreak(10);
  }

  static class Solution {

    /**
     * 1. 定义dp[i]为i的最大乘积
     * <p></>
     * 2. 递推公式: dp[i] = max { dp[i-j]*j, (i-j)*j }   0<j<i
     * <p></>
     * 3. 初始化: dp[2]=1, dp[3]=2
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
      int[] dp = new int[n + 1];

      dp[2] = 1;

      for (int i = 3; i < n + 1; i++) {
        for (int j = 1; j < i; j++) {
          dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, (i - j) * j));
        }
      }

      System.out.println(Arrays.toString(dp));

      return dp[n];
    }

  }

}
