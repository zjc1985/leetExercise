package com.yufu.leet.dp.basic;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 */
public class UniquePathsWithObstacles {

  public static void main(String[] args) {

    int[][] test = new int[3][2];
    System.out.println(test.length);
    System.out.println(test[0].length);

  }

  static class Solution {

    /**
     * 1.定义：dp[i][j] 为到每一个坐标的路径种类
     * <p>
     * 2.递推公式 dp[i][j]=dp[i-1][j]+dp[i][j-1] 一旦该节点为障碍物则该节点为0
     * <p>
     * 3.初始化 dp[i][0]以及dp[0][j]皆为1,一旦遇到障碍物之后皆为0
     * <p>
     * 4. 遍历顺序，一行一行便利
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
      int m = obstacleGrid.length;
      int n = obstacleGrid[0].length;
      int[][] dp = new int[m][n];

      for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
        dp[i][0] = 1;
      }

      for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
        dp[0][j] = 1;
      }

      for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
          if (obstacleGrid[i][j] != 1) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
          }
        }
      }

      return dp[m - 1][n - 1];

    }

  }

}
