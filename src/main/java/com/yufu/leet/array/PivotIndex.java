package com.yufu.leet.array;

public class PivotIndex {


  public static void main(String[] args) {

    int[] t1 = {1, 7, 3, 6, 5, 6};

    System.out.println(new Solution().pivotIndex(t1));

  }

  static class Solution {

    public int pivotIndex(int[] nums) {
      for (int i = 0; i < nums.length; i++) {
        int leftSum = sumLeft(i, nums);
        int rightSum = sumRight(i, nums);
        //System.out.println(leftSum + " " + rightSum);
        if (leftSum == rightSum) {
          return i;
        }
      }
      return -1;
    }

    public int sumLeft(int i, int[] nums) {
      int result = 0;
      for (int k = 0; k < i; k++) {
        result = result + nums[k];
      }
      return result;
    }

    public int sumRight(int i, int[] nums) {
      int result = 0;
      for (int k = i + 1; k < nums.length; k++) {
        result = result + nums[k];
      }
      return result;
    }

  }

}
