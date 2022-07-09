package com.yufu.leet.hash;

/*
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/valid-anagram
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashMap;

public class IsAnagram {

  public static void main(String[] args) {

  }

  static class Solution {

    public boolean isAnagram(String s, String t) {
      HashMap<Character, Integer> map = new HashMap<Character, Integer>();

      if (s.toCharArray().length != t.toCharArray().length) {
        return false;
      }

      for (char each : s.toCharArray()) {
        if (map.containsKey(each)) {
          map.put(each, map.get(each) + 1);
        } else {
          map.put(each, 1);
        }
      }

      for (char each : t.toCharArray()) {
        if (map.containsKey(each)) {
          map.put(each, map.get(each) - 1);
        } else {
          return false;
        }
      }

      for (Character each : map.keySet()) {
        if(map.get(each)!=0){
          return false;
        }
      }
      return true;

    }
  }

}
