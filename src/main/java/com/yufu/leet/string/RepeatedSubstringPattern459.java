
package com.yufu.leet.string;

/**
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。 给定的字符串只含有小写英文字母，并且长度不超过10000。
 * <p>
 * 示例 1: 输入: "abab" 输出: True 解释: 可由子字符串 "ab" 重复两次构成。
 * <p>
 * 示例 2: 输入: "aba" 输出: False
 * <p>
 * 示例 3: 输入: "abcabcabcabc" 输出: True 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
public class RepeatedSubstringPattern459 {

  public static void main(String[] args) {

  }

  static class Solution {

    public boolean repeatedSubstringPattern(String s) {
      if (s == null) {
        return false;
      }

      if (s.length() == 1) {
        return true;
      }

      int[] next = getNext(s);

      if (s.length() % (s.length() - next[s.length() - 1]) == 0 && next[s.length() - 1] > 0) {
        return true;
      } else {
        return false;
      }
    }

    public int[] getNext(String s) {
      if (s == null) {
        return null;
      }

      char[] chars = s.toCharArray();
      int[] result = new int[chars.length];

      //j代表前缀末尾
      int j = 0;
      result[0] = 0;

      if (chars.length == 1) {
        return result;
      }

      //i代表后缀末尾
      for (int i = 1; i < chars.length; i++) {
        while (j > 0 && chars[i] != chars[j]) {
          j = result[j - 1];
        }

        if (chars[i] != chars[j]) {
          result[i] = 0;
        } else {
          result[i] = j + 1;
          j++;
        }

      }//for
      return result;

    }
  }

}
