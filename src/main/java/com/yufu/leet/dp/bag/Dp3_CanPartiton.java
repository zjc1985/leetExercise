package com.yufu.leet.dp.bag;

import java.util.Arrays;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 注意: 每个数组中的元素不会超过 100 数组的大小不会超过 200
 * <p>
 * 示例 1: 输入: [1, 5, 11, 5] 输出: true 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * <p>
 * 示例 2: 输入: [1, 2, 3, 5] 输出: false 解释: 数组不能分割成两个元素和相等的子集.
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200 1 <= nums[i] <= 100
 */
public class Dp3_CanPartiton {

  public static void main(String[] args) {
    int[] nums = {1, 5, 11, 5};
    int[] nums2 = {1, 2, 3, 6};

    //new Solution().canPartition(nums);

    new Solution().canPartition2(nums);
    System.out.println("====");
    new Solution().canPartition3(nums);

  }

  static class Solution {

    /**
     * 问题转为从nums中选择数，放到容量为sum/2的背包中，其最大值是否为sum/2
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
      int sum = 0;
      for (int i = 0; i < nums.length; i++) {
        sum = sum + nums[i];
      }

      if (sum % 2 == 1) {
        return false;
      }

      int cap = sum / 2;

      int[] dp = new int[cap + 1];

      for (int i = 0; i < nums.length; i++) {
        for (int j = cap; j >= 0; j--) {
          if (j - nums[i] >= 0) {
            dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
          }
        }

        System.out.println(Arrays.toString(dp));
      }

      return dp[cap] == cap;
    }

    /**
     * 问题转为从nums中选择若干元素，是否可以使其和为sum/2
     * <p>
     * dp[i][j] 表示从 nums的[0,i]下标范围中选取若干元素，是否存在方案使得这若干元素的正整数和为j 0 <= i < n, 0<=j<target+1 求
     * dp[n-1][target]
     * <p>
     * dp[i][0]=true 0<=i<n  表示不选去任何正整数，使得和为0 方案存在 dp[0][nums[0]]=true
     * <p>
     * dp[i][j]= dp[i-1][j]                  j < nums[i]
     * <p></>
     * dp[i][j]= dp[i-1][j]  || dp[i-1][j-nums[i]] j>=nums[i]
     *
     * @param nums
     * @return
     */
    public boolean canPartition2(int[] nums) {
      int sum = 0;
      for (int i = 0; i < nums.length; i++) {
        sum = sum + nums[i];
      }

      if (sum % 2 == 1) {
        return false;
      }

      int target = sum / 2;

      boolean[][] dp = new boolean[nums.length][target + 1];

      for (int i = 0; i < nums.length; i++) {
        dp[i][0] = true;
      }

      for (int j = 1; j <= target; j++) {
        if (j == nums[0]) {
          dp[0][j] = true;
        } else {
          dp[0][j] = false;
        }
      }

      for (int i = 1; i < nums.length; i++) {
        for (int j = 1; j <= target; j++) {
          if (j < nums[i]) {
            dp[i][j] = dp[i - 1][j];
          } else {
            dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
          }
        }
      }

      for (int i = 0; i < nums.length; i++) {
        System.out.println(Arrays.toString(dp[i]));
      }

      return dp[nums.length - 1][target];
    }

    /**
     * 问题转为从nums中选择若干元素，是否可以使其和为target = sum/2
     * <p>
     * dp[i][j] 表示从 nums的前i个元素中选取若干，是否存在方案使得这若干元素的正整数和为j
     * <p></>
     * 0 <= i < lenght+1, 0<=j<target+1 求 dp[length][target]
     * <p>
     * dp[i][0]=true 0<=i<n  表示不选去任何正整数，使得和为0 方案存在
     * <p></>
     * dp[0][0]=true
     * <p></>
     * dp[0][j] = false j > 1
     *
     *
     * <p>
     * dp[i][j]= dp[i-1][j]                  j < nums[i-1]
     * <p></>
     * dp[i][j]= dp[i-1][j]  || dp[i-1][j-nums[i-1]] j>=nums[i-1]
     *
     * @param nums
     * @return
     */
    public boolean canPartition3(int[] nums) {
      int sum = 0;
      for (int i = 0; i < nums.length; i++) {
        sum = sum + nums[i];
      }

      if (sum % 2 == 1) {
        return false;
      }

      int target = sum / 2;

      boolean[][] dp = new boolean[nums.length + 1][target + 1];

      dp[0][0] = true;
      for (int j = 1; j < target + 1; j++) {
        dp[0][j] = false;
      }

      for (int i = 1; i < nums.length + 1; i++) {
        for (int j = 0; j <= target; j++) {
          if (j < nums[i - 1]) {
            dp[i][j] = dp[i - 1][j];
          } else {
            dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
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
