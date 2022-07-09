package com.yufu.leet.tree;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class SymmetricTree101 {

  public static void main(String[] args) {

  }

  static class Solution {

    public boolean isSymmetric(TreeNode root) {
      return compareSymmetric(root.left, root.right);
    }

    public boolean compareSymmetric(TreeNode left, TreeNode right) {
      if (left == null && right == null) {
        return true;
      }

      if (left == null && right != null) {
        return false;
      }

      if (left != null && right == null) {
        return false;
      }

      if (left.val != right.val) {
        return false;
      }

      return compareSymmetric(left.left, right.right) && compareSymmetric(left.right, right.left);
    }

  }

}
