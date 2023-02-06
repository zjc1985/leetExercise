package com.yufu.leet.dp.bag;


/**
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * <p>
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 * <p>
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3 输出：4
 */
public class Dp6_FindMaxForm {

  public static void main(String[] args) {
    String[] strs = {"10", "0001", "111001", "1", "0"};

    int m = 5, n = 3;

    System.out.println(new Solution().findMaxForm(strs, m, n));

  }

  static class Solution {

    /**
     * dp[i][j][k] 定义为从str选前i个若干元素，使其最多有j个0以及k个1的字符串数量。 其中 0 <= i <strs.lenght+1, 0 <= j < m+1, 0 <=
     * k < n+1 求 dp[strs.lenght][m][n]
     * <p></>
     * <p>
     * dp[i][j][k] = dp[i-1][j][k]  其中 j-zeros[i-1]<0 或者 k- ones[i-1]<0
     * <p></>
     * dp[i][j][k] = Max(dp[i-1][j][k], dp[i-1][j-zeros[i-1]][k-ones[i-1]]+1 ) 其中 j-zeros[i-1]>=0 且
     * k-ones[i-1]>=0
     *
     * <p></>
     * dp[0][j][k]=0
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
      int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

      for (int j = 0; j < m + 1; j++) {
        for (int k = 0; k < n + 1; k++) {
          dp[0][j][k] = 0;
        }
      }

      for (int i = 1; i < strs.length + 1; i++) {
        for (int j = 0; j < m + 1; j++) {
          for (int k = 0; k < n + 1; k++) {
            int zeroNum = getZeros(strs, i - 1);
            int oneNum = getOnes(strs, i - 1);

            if (j - zeroNum >= 0 && k - oneNum >= 0) {
              dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeroNum][k - oneNum] + 1);
            } else {
              dp[i][j][k] = dp[i - 1][j][k];
            }
          }
        }
      }

      return dp[strs.length][m][n];
    }

    public int getOnes(String[] strs, int i) {
      String s = strs[i];
      int r = 0;

      for (char c : s.toCharArray()) {
        if (c == '1') {
          r++;
        }
      }

      return r;
    }

    public int getZeros(String[] strs, int i) {
      String s = strs[i];
      int r = 0;

      for (char c : s.toCharArray()) {
        if (c == '0') {
          r++;
        }
      }

      return r;
    }


  }

}
