package com.yufu.leet.string;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
 * 如果不存在，则返回  -1 。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class strStr {

  public static void main(String[] args) {
//    String pat = "aba";
//    int[] next = new Solution().getNext(pat);
//    System.out.println(Arrays.toString(next));

    System.out.println(new Solution().strStr("mississippi", "issip"));
    
  }

  static class Solution {

    /**
     * 使用KMP 算法进行求解
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {

      if (needle == null || haystack == null || needle.length() == 0 || haystack.length() == 0
          || needle.length() > haystack.length()) {
        return -1;
      }

      char[] haystacks = haystack.toCharArray();
      char[] needles = needle.toCharArray();

      int[] next = getNext(needle);

      int j = 0;

      for (int i = 0; i < haystack.length(); i++) {
        if (haystacks[i] == needles[j]) {
          if (j == needles.length - 1) {
            return i + 1 - needles.length;
          } else {
            j++;
          }

        } else {
          if (j == 0) {
            continue;
          } else {
            i--;
            j = next[j - 1];
          }
        }//if
      }//for

      return -1;

    }

    /**
     * kmp计算并且获取next数组
     *
     * @param pattern 需匹配的字符串
     * @return next数组
     */
    public int[] getNext(String pattern) {
      if (pattern == null) {
        return null;
      }

      char[] chars = pattern.toCharArray();

      int[] next = new int[chars.length];

      //j: 前缀的末尾
      int j = 0;
      next[j] = 0;

      //i: 后缀的末尾
      for (int i = 1; i < next.length; i++) {

        /**
         * 当chars[i]!=chars[j]时
         * 将j回退至next[j-1],直到j=0
         */
        while (j > 0 && chars[i] != chars[j]) {
          j = next[j - 1];
        }

        if (chars[i] != chars[j]) {
          /**
           * 如果j回退至0仍然 chars[i]!=chars[j]
           * 则说明没有公共前后缀子串
           */
          next[i] = 0;
        } else {
          j++;
          next[i] = j;
        }
      }

      return next;
    }
  }

}
