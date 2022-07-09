package com.yufu.leet.tree;

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例： 给定二叉树 [3,9,20,null,null,15,7]，
 */
public class MaxDepth104 {

  public static void main(String[] args) {

  }

  static class Solution {

    public int maxDepth(TreeNode root) {
      return getDepth(root);
    }

    public int getDepth(TreeNode node) {
      if (node == null) {
        return 0;
      }
      int leftDepth = getDepth(node.left);
      int rightDepth = getDepth(node.right);

      return 1 + Math.max(leftDepth, rightDepth);
    }
  }

}
