package com.yufu.leet.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ， 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意： 答案中不可以包含重复的三元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 */
public class ThreeSum15 {

  public static void main(String[] args) {

  }

  static class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

      /**
       * 特判，对于数组长度 nn，如果数组为 nullnull 或者数组长度小于 33，返回 [][]。
       * 对数组进行排序。
       *
       * 遍历排序后数组：
       *    若 nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 00，直接返回结果。
       *    对于重复元素：跳过，避免出现重复解
       *    令左指针 L=i+1L=i+1，右指针 R=n-1R=n−1，当 L<RL<R 时，执行循环：
       *    当 nums[i]+nums[L]+nums[R]==0nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,RL,R 移到下一位置，寻找新的解
       *    若和大于 00，说明 nums[R]nums[R] 太大，RR 左移
       *    若和小于 00，说明 nums[L]nums[L] 太小，LL 右移
       *
       * 作者：wu_yan_zu
       * 链接：https://leetcode.cn/problems/3sum/solution/pai-xu-shuang-zhi-zhen-zhu-xing-jie-shi-python3-by/
       * 来源：力扣（LeetCode）
       * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
       */

      List<List<Integer>> result = new ArrayList<>();

      if (nums == null || nums.length < 3) {
        return result;
      }

      //由于最终解不能重复，所以需要对数组进行排序。
      Arrays.sort(nums);

      for (int i = 0; i < nums.length; i++) {
        if (nums[i] > 0) {
          break;
        }

        //为了避免解重复，需要避免轮训一样的 nums[i]
        if (i > 0 && nums[i] == nums[i - 1]) {
          continue;
        }

        //初始化左右指针
        int left = i + 1;
        int right = nums.length - 1;

        while (left < right) {
          if (nums[i] + nums[left] + nums[right] == 0) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            list.add(nums[left]);
            list.add(nums[right]);
            result.add(list);

            //为了避免重复解需要跳过多个right相同的情况
            int rstep = 1;
            while (left < right - rstep && nums[right] == nums[right - rstep]) {
              rstep++;
            }
            right = right - rstep;

            //为了避免重复解，需要跳过多个left相同的情况
            int step = 1;
            while (left + step < right && nums[left] == nums[left] + step) {
              step++;
            }
            left = left + step;

          } else if (nums[i] + nums[left] + nums[right] > 0) {

            right = right - 1;

          } else {

            left = left + 1;
          }
        }
      }
      return result;
    }
  }

}
