// Source: https://leetcode.com/problems/balanced-binary-tree/description/
// Author: xiaji
// Date: 2017-09-21
// Solution: divide and conquer


/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
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
 * Interview: shoud explain what's the meaning of Depth, and return value;
 * Optimization: Depth should return ResultType class contains Depth and isBalance
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
      return Depth(root) != -1;
    }

    private int Depth(TreeNode node) {
      if (node == null) return 0;
      int right = Depth(node.right);
      int left = Depth(node.left);
      if (left == -1 || right == -1 || Math.abs(right - left) > 1)
        return -1;
      return Math.max(right, left) + 1;
    }
}
