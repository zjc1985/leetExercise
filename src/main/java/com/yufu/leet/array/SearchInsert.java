package com.yufu.leet.array;

public class SearchInsert {


  public static void main(String[] args) {
    int i = 1 / 2;
    System.out.println(1 / 2);

    int[] nums = {1, 3, 5, 6, 9};
    System.out.println(new Solution().SearchInsert(nums, 5));
    System.out.println(new Solution().SearchInsert(nums, 2));
    System.out.println(new Solution().SearchInsert(nums, 7));
    System.out.println(new Solution().SearchInsert(nums, 0));

  }

  static class Solution {

    public int SearchInsert(int[] nums, int target) {
      return twoSearch(nums, target, 0, nums.length - 1);
    }

    public int twoSearch(int[] nums, int target, int i, int j) {
      if (j - i == 1) {
        if (target <= nums[i]) {
          return i;
        } else if (target > nums[i] && target <= nums[j]) {
          return j;
        } else if (target > nums[j]) {
          return j + 1;
        }
      }

      int mid = (j + i) / 2;

      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        return twoSearch(nums, target, mid, j);
      } else {
        return twoSearch(nums, target, i, mid);
      }
    }


  }

  static class Solution2 {

    public int SearchInsert(int[] nums, int target) {
      int l = 0;
      int r = nums.length - 1;
      while (l <= r) {
        int mid = (l + r) / 2;
        if (nums[mid] < target) {
          l = mid + 1;
        } else if (nums[mid] > target) {
          r = mid - 1;
        } else {
          return mid;
        }

      }
      return -1;
    }

  }

}
