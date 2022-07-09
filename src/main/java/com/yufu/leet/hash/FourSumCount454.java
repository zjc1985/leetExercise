package com.yufu.leet.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 * <p>
 * 0 <= i, j, k, l < n nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/4sum-ii 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class FourSumCount454 {

  public static void main(String[] args) {

  }

  static class Solution {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
      Map<Integer, Integer> map = new HashMap<>();

      for (int i = 0; i < nums1.length; i++) {
        for (int j = 0; j < nums2.length; j++) {
          int sum = nums1[i] + nums2[j];

          if (map.containsKey(sum)) {
            map.put(sum, map.get(sum) + 1);
          } else {
            map.put(sum, 1);
          }
        }
      }

      int result = 0;

      for (int i = 0; i < nums3.length; i++) {
        for (int j = 0; j < nums4.length; j++) {
          int wanted = 0 - (nums3[i] + nums4[j]);
          if (map.containsKey(wanted)) {
            result = result + map.get(wanted);
          }
        }
      }

      return result;
    }
  }

}
