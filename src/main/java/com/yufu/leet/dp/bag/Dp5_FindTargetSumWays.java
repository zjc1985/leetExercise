package com.yufu.leet.dp.bag;


import java.util.Arrays;

/**
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * <p>
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * <p>
 * 示例：
 * <p>
 * 输入：nums: [1, 1, 1, 1, 1], S: 3 输出：5
 */
public class Dp5_FindTargetSumWays {

  public static void main(String[] args) {
    int[] nums = {1, 1, 1, 1, 1};
    int S = 3;
    System.out.println(new Solution().findTargetSumWays(nums, S));
  }

  static class Solution {


    /**
     * 定义left为正数和，定义right为负数和 left-right= S left-(sum-left)=S left=(S+sum)/2
     * <p>
     * 问题转为从nums中选取若干个数，使其和为 left 的数量。
     * <p>
     * dp[i][j] 表示从nums 的前i个下标中选取若干个数，使其和为j的数量 0<=i< nums.lenght+1  0<=j< left+1;
     * <p>
     * 问题转化为 求 dp[nums.lenght][left]
     * <p>
     * dp[i][j] = dp[i-1][j]                       j < nums[i-1]
     * <p></>
     * dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]]  j>=nums[i-1]
     * <p></>
     * <p>
     * dp[0][0]=1,
     * <p></>
     * dp[0][j]=0 j>0
     *
     * @param nums
     * @param s
     * @return
     */
    public int findTargetSumWays(int[] nums, int s) {
      int sum = 0;
      for (int i = 0; i < nums.length; i++) {
        sum = sum + nums[i];
      }

      if ((sum - s) % 2 != 0 || (sum - s) < 0) {
        return 0;
      }

      int target = (sum - s) / 2;

      int[][] dp = new int[nums.length + 1][target + 1];

      dp[0][0] = 1;
      for (int j = 1; j < target + 1; j++) {
        dp[0][j] = 0;
      }

      for (int i = 1; i < nums.length + 1; i++) {
        for (int j = 0; j <= target; j++) {
          if (j < nums[i - 1]) {
            dp[i][j] = dp[i - 1][j];
          } else {
            dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
          }
        }
      }

      for (int i = 0; i < nums.length + 1; i++) {
        System.out.println(Arrays.toString(dp[i]));
      }

      return dp[nums.length][target];
    }

  }

}
