package com.yufu.leet.tree;

/**
 * 翻转一棵二叉树。
 */
public class InvertTree226 {

  public static void main(String[] args) {

  }

  static class Solution {

    public TreeNode invertTree(TreeNode root) {

      if (root == null) {
        return null;
      }

      TreeNode tmp = root.left;
      root.left = root.right;
      root.right = tmp;

      invertTree(root.left);
      invertTree(root.right);

      return root;
    }
  }

}
