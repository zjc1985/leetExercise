package com.yufu.leet.dp.basic;

import java.util.Arrays;

/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 */
public class NumTrees {

  public static void main(String[] args) {
    new Solution().numTrees(10);

  }

  static class Solution {

    /**
     * 1. 定义dp数组: dp[i]定义为n个节点的搜索数的数量
     * <p></>
     * <p>
     * 2. 递推公式：dp[i]=dp[i] + dp[j]*dp[i-1-j]  0<=j<i
     *
     * <p></>
     * <p>
     * <p>
     * 3. 初始化: dp[0]=0, dp[1]=1
     *
     * <p></>
     * <p>
     * <p>
     * 4. 确定遍历顺序：从前往后
     *
     * <p></>
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
      int[] dp = new int[n + 1];
      dp[0] = 1;
      dp[1] = 1;

      for (int i = 2; i < n + 1; i++) {
        for (int j = 0; j < i; j++) {
          dp[i] = dp[i] + dp[j] * dp[i - 1 - j];
        }
      }

      System.out.println(Arrays.toString(dp));

      return dp[n];
    }
  }

}
