package com.yufu.leet.hash;


import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * <p>
 * 如果可以，返回 true ；否则返回 false 。
 * <p>
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/ransom-note 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanConstruct383 {

  public static void main(String[] args) {

  }

  static class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
      Map<Character, Integer> map = new HashMap<>();

      for (Character c : magazine.toCharArray()) {
        if (map.containsKey(c)) {
          map.put(c, map.get(c) + 1);
        } else {
          map.put(c, 1);
        }
      }

      for (Character c : ransomNote.toCharArray()) {
        if (map.containsKey(c)) {
          int availabe = map.get(c);
          if (availabe > 0) {
            map.put(c, availabe - 1);
          } else {
            return false;
          }

        } else {
          return false;
        }
      }

      return true;
    }
  }

}
