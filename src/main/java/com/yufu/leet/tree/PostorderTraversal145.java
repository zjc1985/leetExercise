package com.yufu.leet.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 树的后序遍历
 */
public class PostorderTraversal145 {

  public static void main(String[] args) {

  }

  static class Solution {

    /**
     * 树的后序遍历：左右中 统一标准写法
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      Deque<TreeNode> stack = new LinkedList<>();

      if (root == null) {
        return result;
      }

      stack.push(root);

      while (!stack.isEmpty()) {
        if (stack.peek() != null) {
          TreeNode node = stack.pop();
          stack.push(node);
          stack.push(null);
          if (node.right != null) {
            stack.push(node.right);
          }
          if (node.left != null) {
            stack.push(node.left);
          }
        } else {
          stack.pop();
          TreeNode node = stack.pop();
          result.add(node.val);
        }

      }//while
      return result;

    }
  }

}
