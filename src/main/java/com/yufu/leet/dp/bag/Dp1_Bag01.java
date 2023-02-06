package com.yufu.leet.dp.bag;

public class Dp1_Bag01 {

  public static void main(String[] args) {
    int[] weight = {1, 3, 4};
    int[] value = {15, 20, 30};
    int cap = 4;

    new Solution().bag01(weight, value, cap);

    System.out.println("======");

    new Solution().bag01Solution2(weight, value, cap);

  }

  static class Solution {

    /**
     * 1. 定义dp数组：dp[i][j] 代表在背包容量为j-1的情况下, i个物品放进背包的最大价值
     * <p></>
     * <p>
     * 2. 定义递推公式：dp[i][j]= Max { dp[i-1][j], dp[i-1][j-w[i]]+v[i] }
     * <p></>
     * <p>
     * 3. 初始化: dp[i][0]=0,
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
      int[][] dp = new int[weight.length][cap + 1];

      for (int i = 0; i < weight.length; i++) {
        dp[i][0] = 0;
      }

      for (int j = weight[0]; j < cap + 1; j++) {
        dp[0][j] = value[0];
      }

      for (int i = 1; i < weight.length; i++) {
        for (int j = 1; j < cap + 1; j++) {
          if (j - weight[i] < 0) {
            dp[i][j] = dp[i - 1][j];
          } else {
            dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
          }
        }
      }

      //打印dp数组
      for (int i = 0; i < weight.length; i++) {
        for (int j = 0; j < cap + 1; j++) {
          System.out.print(dp[i][j] + " ");
        }
        System.out.print("\n");
      }


    }

    /**
     * dp[i][j] 定义为选取前i个物品，放到容量为j的背包中的最大价值。 其中  0 =< i < length+1, 0=<j<cap+1
     * <p></>
     * 求 dp[length][cap]
     * <p>
     * dp[i][j]=dp[i-1][j]  此时  j< weight[i-1]
     * <p></>
     * dp[i][j]=Max{ dp[i-1][j],   dp[i-1][j-weight[i-1]]+value[i-1]   }
     * <p></>
     * <p>
     * 初始化：当i=0时即不选物品背包价值必定为0
     *
     * @param weight
     * @param value
     * @param cap
     */
    public void bag01Solution2(int[] weight, int[] value, int cap) {
      int[][] dp = new int[weight.length + 1][cap + 1];

      for (int j = 0; j < cap + 1; j++) {
        dp[0][j] = 0;
      }

      for (int i = 1; i < weight.length + 1; i++) {
        for (int j = 0; j < cap + 1; j++) {
          if (j - weight[i - 1] < 0) {
            dp[i][j] = dp[i - 1][j];
          } else {
            dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
          }
        }
      }

      //打印dp数组
      for (int i = 0; i < weight.length + 1; i++) {
        for (int j = 0; j < cap + 1; j++) {
          System.out.print(dp[i][j] + " ");
        }
        System.out.print("\n");
      }


    }
  }

}
