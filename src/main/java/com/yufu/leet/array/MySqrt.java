package com.yufu.leet.array;

/**
 * 给你一个非负整数 x ，计算并返回 x的 算术平方根 。 由于返回类型是整数，结果只保留整数部分 ，小数部分将被舍去 。 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5)
 * 或者 x ** 0.5 。 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MySqrt {

  public static void main(String[] args) {
    System.out.println(new Solution().mySqrt(13));
    System.out.println(new Solution().mySqrt(4));
    System.out.println(new Solution().mySqrt(3));
    System.out.println(new Solution().mySqrt(2));
    System.out.println(new Solution().mySqrt(1));
    System.out.println(new Solution().mySqrt(0));

  }

  static class Solution {

    public int mySqrt(int x) {
      //此题仍然使用二分法来尝试解决。

      int l = 0;
      int r = x - 1;

      if (x == 0) {
        return 0;
      }

      while (l <= r) {
        int mid = (l + r) / 2;

        if (mid == 0) {
          return 1;
        }

        if (x / mid < mid) {//这里需要注意
          r = mid - 1;
        } else if (x / mid > mid) {
          l = mid + 1;
        }else{
          return mid;
        }
      }

      //由于题目要求是去除小数，所以当r<l时，意味着找到了
      return l-1;
    }

  }


}
