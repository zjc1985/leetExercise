package com.yufu.leet.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c],
 * nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d < n a、b、c 和 d 互不相同 nums[a] + nums[b] + nums[c] + nums[d] == target 你可以按 任意顺序 返回答案
 * 。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/4sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class FourSum18 {

  public static void main(String[] args) {

  }

  static class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
      List<List<Integer>> result = new ArrayList<>();

      Arrays.sort(nums);

      if (nums == null || nums.length < 4) {
        return result;
      }

      for (int i = 0; i < nums.length; i++) {

        if (i > 0) {
          if (nums[i] == nums[i - 1]) {
            continue;
          }
        }

        for (int j = i + 1; j < nums.length; j++) {

          if (j - 1 > i) {
            if (nums[j] == nums[j - 1]) {
              continue;
            }
          }

          int left = j + 1;
          int right = nums.length - 1;

          while (left < right) {
            if (nums[i] + nums[j] + nums[left] + nums[right] == target) {
              List<Integer> list = new ArrayList<>();
              list.add(nums[i]);
              list.add(nums[j]);
              list.add(nums[left]);
              list.add(nums[right]);
              result.add(list);

              int rstep = 1;
              while (left < right - rstep && nums[right] == nums[right - rstep]) {
                rstep++;
              }
              right = right - rstep;

              int step = 1;
              while (left + step < right && nums[left] == nums[left] + step) {
                step++;
              }
              left = left + step;


            } else if (nums[i] + nums[j] + nums[left] + nums[right] > target) {
              right = right - 1;
            } else {
              left = left + 1;
            }
          }
        }
      }

      return result;
    }
  }

}
