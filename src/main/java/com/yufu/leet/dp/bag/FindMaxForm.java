package com.yufu.leet.dp.bag;


/**
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 *
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 * 示例 1：
 *
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3 输出：4
 */
public class FindMaxForm {

  public static void main(String[] args) {

  }

  static class Solution{

    /**
     *
     * dp[i][j][k] 定义为str的[0,i]下标中选若干元素，使其最多有j个0以及k个1的数量。
     * 其中 0<=i<strs.lenght, 0 <= j < m+1, 0 <= k < n+1
     * 求 dp[strs.lenght-1][m][n]
     * <p></>
     *
     * dp[i][j][k] = dp[i-1][j][k]  其中 j-zeros[i]<0 或者 k- ones[i]<0
     * <p></>
     * dp[i][j][k] = Max(dp[i-1][j][k], dp[i-1][j-zeros[i]][k-ones[i]]+1 ) 其中 j-zeros[i]>=0 且 k-ones[i]>=0
     *
     * <p></>
     *
     *
     *
     *
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {

      return 0;
    }
  }

}
