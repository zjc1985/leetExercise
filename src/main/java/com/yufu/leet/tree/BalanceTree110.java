package com.yufu.leet.tree;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */
public class BalanceTree110 {

  public static void main(String[] args) {

  }

  static class Solution {

    public boolean isBalanced(TreeNode root) {
      return getDepth(root) == -1 ? false : true;
    }


    public int getDepth(TreeNode node) {
      if (node == null) {
        return 0;
      }

      int left = getDepth(node.left);

      if (left == -1) {
        return -1;
      }

      int right = getDepth(node.right);

      if (right == -1) {
        return -1;
      }

      if (Math.abs(left - right) > 1) {
        return -1;
      } else {
        return 1 + Math.max(left, right);
      }
    }

  }

}
