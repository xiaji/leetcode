// Source: https://leetcode.com/problems/validate-binary-search-tree/description/
// Author: xiaji
// Date: 2017-09-22
// Solution: traverse, divide and conquer


/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
    2
   / \
  1   3
 * Binary tree [2,1,3], return true.
 * Example 2:
    1
   / \
  2   3
 * Binary tree [1,2,3], return false. 
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
 * inordr of BST is non-decrement result;
 *
 */

public class Solution {
  private int lastVal = Integer.MIN_VALUE;
  private boolean firstNode = true;
  public boolean isValidBST(TreeNode root) {
  }

  public boolean inorderBST(TreeNode root) {
    if (root == null) return true;
    if (!inorderBST(root.left)) return false;
    if (!firstNode && lastVal >= root.val) return false;
    firstNode = false;
    lastVal = root.val;
    if (!inorderBST(root.right)) return false;
    return true;
  }
}
