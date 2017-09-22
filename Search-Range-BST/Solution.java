// Source: https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
// Author: xiaji
// Date: 2017-09-22
// Solution:


/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from 
 * the root node down to the nearest leaf node. 
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
 * helper: why don't root.val > k2 || root.val < k1
 * how about k1 < root.val < k2, it would cost another if-else condition
 * and this if-else conditions make sure it conveges to root = null
 */


public class Solution {
  private ArrayList<Integer> result;

  public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
    result = new ArrayList<Integer>();
    this.helper(root, k1, k2);
    return result;
  }

  private void helper(TreeNode root, int k1, int k2) {
    if (root == null) return;
    if (root.val > k1) helper(root.left, k1, k2);
    if (root.val >= k1 && root.val <= k2) result.add(root.val);
    if (root.val < k2) helper(root.right, k1, k2);
  }
}
