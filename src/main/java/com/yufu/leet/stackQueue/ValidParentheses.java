package com.yufu.leet.stackQueue;

import java.util.Deque;
import java.util.LinkedList;


/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。 注意空字符串可被认为是有效字符串。 示例 1:
 * <p>
 * 输入: "()" 输出: true 示例 2:
 * <p>
 * 输入: "()[]{}" 输出: true 示例 3:
 * <p>
 * 输入: "(]" 输出: false 示例 4:
 * <p>
 * 输入: "([)]" 输出: false 示例 5:
 * <p>
 * 输入: "{[]}" 输出: true
 */
public class ValidParentheses {

  public static void main(String[] args) {
    System.out.println(new Solution().isValid("()"));// true
    System.out.println(new Solution().isValid("([)]"));// false
    System.out.println(new Solution().isValid("{[]}"));// true
  }

  static class Solution {

    public boolean isValid(String s) {
      Deque<Character> stack = new LinkedList<Character>();
      for (int i = 0; i < s.length(); i++) {
        Character cur = s.charAt(i);

        if (cur == ')') {
          if (stack.peek() == null || stack.peek() != '(') {
            return false;
          } else {
            stack.pop();
          }
        } else if (cur == '}') {
          if (stack.peek() == null || stack.peek() != '{') {
            return false;
          } else {
            stack.pop();
          }
        } else if (cur == ']') {
          if (stack.peek() == null || stack.peek() != '[') {
            return false;
          } else {
            stack.pop();
          }
        } else {
          stack.push(cur);
        }
      }//for
      if (stack.size() == 0) {
        return true;
      } else {
        return false;
      }
    }

  }

}
