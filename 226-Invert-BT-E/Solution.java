// Source: https://leetcode.com/problems/invert-binary-tree/description/
// Author: xiaji
// Date: 2017-09-22
// Solution: divide and conquer


/**
 * Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
 * to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
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
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
