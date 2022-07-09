package com.yufu.leet.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class LevelOrder102 {

  public static void main(String[] args) {
    TreeNode node15 = new TreeNode(15);
    TreeNode node7 = new TreeNode(7);
    TreeNode node20 = new TreeNode(20, node15, node7);
    TreeNode node9 = new TreeNode(9);
    TreeNode node3 = new TreeNode(3, node9, node20);

    List<List<Integer>> result = new Solution().levelOrder(node3);

    System.out.println(result);

  }

  static class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> result = new ArrayList<>();
      if (root == null) {
        return result;
      }

      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);

      while (!queue.isEmpty()) {
        int n = queue.size();
        List<Integer> levelResult = new ArrayList<>();

        for (int i = 0; i < n; i++) {

          TreeNode node = queue.poll();
          levelResult.add(node.val);
          if (node.left != null) {
            queue.add(node.left);
          }
          if (node.right != null) {
            queue.add(node.right);
          }
        }//for

        if (levelResult != null) {
          result.add(levelResult);
        }

      }//while
      return result;

    }
  }

}
