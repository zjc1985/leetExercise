package com.yufu.leet.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 输入：root = [1,2,3,null,5] 输出：["1->2->5","1->3"]
 */
public class BinaryTreePaths257 {

  public static void main(String[] args) {
    TreeNode node5 = new TreeNode(5);
    TreeNode node3 = new TreeNode(3);
    TreeNode node2 = new TreeNode(2, null, node5);
    TreeNode node1 = new TreeNode(1, node2, node3);

    List<String> result = new Solution().binaryTreePaths(node1);

    for (String each : result
    ) {
      System.out.println(each);
    }

  }

  static class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
      List<String> result = new ArrayList<>();

      if (root == null) {
        return result;
      }

      if (root.left == null && root.right == null) {
        result.add(String.valueOf(root.val));
        return result;
      }

      List<String> rLeft = binaryTreePaths(root.left);
      List<String> rRight = binaryTreePaths(root.right);

      for (String each : rLeft) {
        result.add(String.valueOf(root.val) + "->" + each);
      }

      for (String each : rRight) {
        result.add(String.valueOf(root.val) + "->" + each);
      }

      return result;
    }

  }


}
