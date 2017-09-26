// Source: https://leetcode.com/problems/symmetric-tree/description/
// Author: xiaji
// Date: 2017-09-26
// Solution: divide & conquer / recursion(preorder of leftsubtree == preorder(root->right->left) of rightsubtree equal)


/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
      1
     / \
    2   2
  / \ / \
 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3

 * Note:
 * Bonus points if you could solve it both recursively and iteratively. * */

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
 * Analysis this problem, it's not only one variable enough. 
 * It compares two subtree, not right subtree and left subtree both are symmetric,
 * then it's symmetric
 */

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }
    
    private boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isMirror(p.left, q.right) && isMirror(p.right, q.left);
    } 
}
