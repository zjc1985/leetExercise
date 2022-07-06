package com.yufu.leet.dp.basic;

/**
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 * <p>
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * <p>
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 * <p>
 * 示例 1：
 * <p>
 * 输入：cost = [10, 15, 20] 输出：15 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。  示例 2：
 * <p>
 * 输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1] 输出：6 解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3]
 * ，一共花费 6 。
 */
public class minCostClimbingStairs {

  public static void main(String[] args) {

  }

  static class Solution {

    public int minCostClimbingStairs(int[] cost) {
      if (cost == null || cost.length == 0) {
        return 0;
      }

      if (cost.length == 1) {
        return cost[0];
      }

      /**
       * 1. 确认dp[i]函数代表走到i阶阶所需要的花费
       */
      int[] dp = new int[cost.length];

      /**
       * 3. dp数组初始化
       */
      dp[0] = cost[0];
      dp[1] = cost[1];

      for (int i = 2; i < cost.length; i++) {
        /**
         * 2.确定状态转移方程，递推工时
         */

        /**
         * 4.确定遍历顺序
         * 从递归公式
         * 中可以看出，dp[i]是依赖 dp[i - 1] 和 dp[i - 2]，那么遍历的顺序一定是从前到后遍历的
         */
        dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
      }

      return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

  }

}
