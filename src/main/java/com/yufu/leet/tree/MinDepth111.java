package com.yufu.leet.tree;

/**
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class MinDepth111 {

  public static void main(String[] args) {

  }

  public static int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = minDepth(root.left);
    int right = minDepth(root.right);

    if (root.left == null && root.right != null) {
      return 1 + right;
    }

    if (root.left != null && root.right == null) {
      return 1 + left;
    }

    return 1 + Math.min(left, right);
  }

}
