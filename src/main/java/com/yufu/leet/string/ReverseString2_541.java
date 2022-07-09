package com.yufu.leet.string;

/**
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * <p>
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 * 示例:
 * <p>
 * 输入: s = "abcdefg", k = 2 输出: "bacdfeg"
 */
public class ReverseString2_541 {

  public static void main(String[] args) {
    System.out.println(new Solution().reverseStr("abcdefg", 2));
    System.out.println(new Solution().reverseStr("abcd", 2));

  }

  static class Solution {

    public String reverseStr(String s, int k) {
      char[] chars = s.toCharArray();

      int i = 0;
      while (i < chars.length) {
        int j = i + 2 * k;
        if (j < chars.length) {
          reverseString(chars, i, i + k - 1);
        } else {
          if (i + k > chars.length) {
            reverseString(chars, i, chars.length - 1);
          } else {
            reverseString(chars, i, i + k - 1);
          }

        }

        i = i + 2 * k;

      }
      return new String(chars);
    }

    public void reverseString(char[] s, int start, int end) {
      if (s == null || s.length == 0) {
        return;
      }

      int left = start;
      int right = end;
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
