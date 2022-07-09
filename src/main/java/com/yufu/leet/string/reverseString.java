package com.yufu.leet.string;


/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/reverse-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class reverseString {


  public static void main(String[] args) {

    char[] s = {'h', 'e', 'l', 'l', 'o'};
    new Solution().reverseString(s);
    for (char e : s) {
      System.out.println(e);
    }

  }


  static class Solution {

    public void reverseString(char[] s) {
      if (s == null || s.length == 0) {
        return;
      }

      int left = 0;
      int right = s.length - 1;
      while (left < right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;

        left++;
        right--;

      }
    }
  }

}
