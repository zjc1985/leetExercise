package com.yufu.leet.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」 定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。 如果这个过程 结果为 1，那么这个数就是快乐数。 如果
 * n 是 快乐数 就返回 true ；不是，则返回 false 。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/happy-number 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsHappy202 {

  public static void main(String[] args) {
    System.out.println(new Solution().isHappy(19));
    System.out.println(new Solution().isHappy(2));
  }

  static class Solution {

    public boolean isHappy(int n) {
      if (n == 1) {
        return true;
      }

      Set<Integer> set = new HashSet<>();
      while (true) {
        int sum = sum(n);
        if (sum == 1) {
          return true;
        } else {
          if (set.contains(sum)) {
            return false;
          } else {
            set.add(sum);
          }
        }
        n = sum;
      }
    }

    public int sum(int n) {
      int result = 0;
      while (n > 0) {
        int tmp = n % 10;
        result = result + tmp * tmp;
        n = n / 10;
      }
      return result;
    }


  }

}
