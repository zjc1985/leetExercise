package com.yufu.leet.dp.basic;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。 也就是： F(0) = 0，F(1) = 1 F(n)
 * = F(n - 1) + F(n - 2)， 其中 n > 1 给你n ，请计算 F(n) 。
 */
public class fib {

  public static void main(String[] args) {
    System.out.println("Hello");
  }

  static class Solution {

    public int fib(int n) {
      if (n <= 1) {
        return n;
      }
      /**
       * 1.确定dp数组以及下标的含义
       * dp[i]的定义为：第i个数的斐波那契数值是dp[i]
       */
      int[] dp = new int[n + 1];

      /**
       * 3.dp数组初始化
       */
      dp[0] = 0;
      dp[1] = 1;

      for (int index = 2; index <= n; index++) {

        /**
         * 2.确定递推公式
         */

        /**
         * 4.确定遍历顺序
         * 从递归公式dp[i] = dp[i - 1] + dp[i - 2];
         * 中可以看出，dp[i]是依赖 dp[i - 1] 和 dp[i - 2]，那么遍历的顺序一定是从前到后遍历的
         */
        dp[index] = dp[index - 1] + dp[index - 2];
      }

      return dp[n];
    }

  }

}
