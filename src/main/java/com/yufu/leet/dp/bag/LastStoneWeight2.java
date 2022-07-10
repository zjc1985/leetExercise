package com.yufu.leet.dp.bag;


import java.util.Arrays;

/**
 * 有一堆石头，每块石头的重量都是正整数。
 * <p>
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎； 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头最小的可能重量。如果没有石头剩下，就返回 0。
 * <p>
 * 示例： 输入：[2,7,4,1,8,1] 输出：1 解释： 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]， 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]， 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 * <p>
 * 提示：
 * <p>
 * 1 <= stones.length <= 30 1 <= stones[i] <= 1000 #
 */
public class LastStoneWeight2 {


  public static void main(String[] args) {

    int[] stones = {2, 7, 4, 1, 8, 1};
    int value = new Solution().lastStoneWeightII(stones);
    System.out.println(value);
  }

  static class Solution {

    /**
     * 问题转化为分成两堆石头，差最小。差最小两堆石头重量都要接近于sum/2
     * <p>
     * 问题转化为将石头放进容量为sum/2的背包中，求其最大重量max。 解为 (sum-max)-max
     *
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
      int sum = 0;
      for (int i = 0; i < stones.length; i++) {
        sum = sum + stones[i];
      }
      int cap = sum / 2;

      int[] dp = new int[cap + 1];

      for (int i = 0; i < stones.length; i++) {
        for (int j = cap; j >= stones[i]; j--) {
          dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
        }
        System.out.println(Arrays.toString(dp));
      }

      return sum - 2 * dp[cap];
    }

  }

}
