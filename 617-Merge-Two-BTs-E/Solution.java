// Source: https://leetcode.com/problems/merge-two-binary-trees/discuss/
// Author: xiaji
// Date: 2017-09-25
// Solution: divide & conquer


/**
 * Find the sum of all left leaves in a given binary tree.
 * Example:

    3
   / \
  9  20
    /  \
   15   7

 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
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

class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        //if (t1 == null && t2 == null) return t1;
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        TreeNode root = new TreeNode(t1.val + t2.val);
        TreeNode left = mergeTrees(t1.left, t2.left);
        TreeNode right = mergeTrees(t1.right, t2.right);
        //TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = left;
        root.right = right;
        return root;
    }
}
