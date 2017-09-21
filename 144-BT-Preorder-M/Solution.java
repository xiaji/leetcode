// Source: https://leetcode.com/problems/binary-tree-preorder-traversal/description/
// Author: xiaji
// Date: 2017-09-21
// Solution:


/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
 * return [1,2,3].
 * Note: Recursive solution is trivial, could you do it iteratively?
 * */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/** Mistakes:
 *
 *
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      if (root == null) return result;
      Stack<TreeNode> inorderStack = new Stack<>();
      // List<Integer> result = new ArrayList<>();
      if (inorderStack.empty()) inorderStack.push(root);
      while(!inorderStack.empty()) {
        TreeNode current = inorderStack.pop();
        result.add(current.val);
        if (current.right != null) inorderStack.push(current.right);
        if (current.left != null) inorderStack.push(current.left);
      }
      return result;
    }
}
