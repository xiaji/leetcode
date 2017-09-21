// Source: https://leetcode.com/problems/binary-tree-inorder-traversal/description/
// Author: xiaji
// Date: 2017-09-21
// Solution:


/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * For example:
 * Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
 * return [1,3,2].
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
    private Stack<TreeNode> stack = new Stack<>();
    
    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      if (root == null) return result;
      this.addLeft(root);
      // if (stack.empty()) stack.push(root);
      while(!stack.empty()) {
        TreeNode current = stack.pop();
        result.add(current.val);
        if (current.right != null) this.addLeft(current.right);
      }
      return result;
    }

    private void addLeft(TreeNode node) {
      while (node.left != null) {
        stack.push(node);
        node = node.left;
      }
      stack.push(node);
    }
}
