package com.yufu.leet.dp.bag;

import java.util.Arrays;

public class DP2_Bag01Opt {

  public static void main(String[] args) {
    int[] weight = {1, 3, 4};
    int[] value = {15, 20, 30};
    int cap = 4;

    new Solution().bag01(weight, value, cap);

  }

  static class Solution {

    /**
     * 1. 定义dp数组：dp[j] 代表在背包容量为j-1的情况下, 能放进背包的最大价值
     * <p></>
     * <p>
     * 2. 定义递推公式：dp[j]= Max { dp[j], dp[j-w[i]]+v[i] }
     * <p></>
     * <p>
     * 3. 初始化: 全部初始化为0,
     * <p></>
     * <p>
     * 4. 定义遍历顺序
     *
     * @param weight 物品重量
     * @param value  物品价值
     * @param cap    背包容量
     * @return
     */
    public void bag01(int[] weight, int[] value, int cap) {
      int[] dp = new int[cap + 1];

      for (int i = 0; i < weight.length; i++) {
        for (int j = cap; j >= 0; j--) {
          if (j - weight[i] >= 0) {
            dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
          }

        }

        System.out.println(Arrays.toString(dp));

      }

    }
  }

}
