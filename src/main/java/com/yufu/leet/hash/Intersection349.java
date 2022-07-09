package com.yufu.leet.hash;

import java.util.HashSet;

/**
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。 我们可以 不考虑输出结果的顺序 。
 */

public class Intersection349 {

  public static void main(String[] args) {

  }

  static class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
      HashSet<Integer> set = new HashSet<>();
      HashSet<Integer> resultSet = new HashSet<>();
      for (Integer i : nums1) {
        set.add(i);
      }

      for (Integer i : nums2) {
        if (set.contains(i)) {
          resultSet.add(i);
        }
      }

      int[] result = new int[resultSet.size()];
      int i = 0;
      for (Integer each : resultSet) {
        result[i] = each;
        i++;
      }

      return result;
    }

  }

}
