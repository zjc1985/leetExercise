package com.yufu.leet.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 */
public class InorderTraversal94 {

  public static void main(String[] args) {

  }

  static class Solution {

    /**
     * 不使用递归实现中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalWithStack(TreeNode root) {
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
          // 中序：左中右，入stack顺序：右中左
          if (node.right != null) {
            stack.push(node.right);
          }

          stack.push(node);
          stack.push(null);//打标记，标记null后的节点需要统一进行处理打印

          if (node.left != null) {
            stack.push(node.left);
          }

        } else {
          //检测到null 标记之后，后一个节点进行处理打印
          result.add(stack.pop().val);
        }

      }

      return result;

    }

    /**
     * 递归解决中序列：
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      inorder(root, result);
      return result;
    }

    /**
     * 中序顺序：左中右
     *
     * @param node
     * @param result
     */
    public void inorder(TreeNode node, List<Integer> result) {
      if (node == null || result == null) {
        return;
      }

      inorder(node.left, result);
      result.add(node.val);
      inorder(node.right, result);
    }
  }

}
