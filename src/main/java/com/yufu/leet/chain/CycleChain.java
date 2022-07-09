package com.yufu.leet.chain;

import java.util.HashMap;

public class CycleChain {

  public static void main(String[] args) {

  }

  static class Solution {

    public ListNode detectCycle(ListNode head) {
      HashMap<ListNode, Integer> map = new HashMap<ListNode, Integer>();

      ListNode curr = head;
      while (curr != null) {
        if (map.containsKey(curr)) {
          return curr;
        } else {
          map.put(curr, curr.val);
        }
        curr = curr.next;
      }

      return null;
    }
  }

}
