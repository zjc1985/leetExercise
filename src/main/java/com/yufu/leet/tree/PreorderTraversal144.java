package com.yufu.leet.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。中序遍历。后续遍历
 */
public class PreorderTraversal144 {

  public static void main(String[] args) {
    TreeNode node3 = new TreeNode(3);
    TreeNode node2 = new TreeNode(2, node3, null);
    TreeNode node1 = new TreeNode(1, null, node2);

    List<Integer> result = new Solution().preorderTraversalWithStack(node1);

    System.out.println(Arrays.asList(result));

  }

  static class Solution {


    /**
     * 不使用递归实现前序遍历 前序遍历顺序：中左右
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalWithStack(TreeNode root) {
      Deque<TreeNode> stack = new LinkedList<>();
      List<Integer> result = new ArrayList<>();

      if (root == null) {
        return result;
      }

      stack.push(root);

      while (!stack.isEmpty()) {
        TreeNode node = stack.pop();

        if (node != null) {
          // 树的当前节点进行统一入stack
          // 前序：中左右，入stack顺序：右左中
          if (node.right != null) {
            stack.push(node.right);
          }
          if (node.left != null) {
            stack.push(node.left);
          }
          stack.push(node);
          stack.push(null);//打标记，标记null后的节点需要统一进行处理打印

        } else {
          //检测到null 标记之后，后一个节点进行处理打印
          result.add(stack.pop().val);
        }

      }

      return result;

    }

    /**
     * 使用递归实现前序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
      if (root == null) {
        return null;
      }

      List<Integer> results = new ArrayList<>();
      preOrder(root, results);
      return results;
    }

    public void preOrder(TreeNode node, List<Integer> result) {
      if (node == null || result == null) {
        return;
      }
      result.add(node.val);
      System.out.println(node.val);
      preOrder(node.left, result);
      preOrder(node.right, result);
    }
  }

}
