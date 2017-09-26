// Source: https://leetcode.com/problems/binary-search-tree-iterator/description/
// Author: xiaji
// Date: 2017-09-25
// Solution: recursion(my method) / divide & conquer


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
    public int sumOfLeftLeaves(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        this.findLeftLeaves(root, result);
        if (root != null && root.left == null && root.right == null) return 0;
        int sum = 0;
        for (int i : result) sum += i;
        return sum;
    }
    
    public void findLeftLeaves(TreeNode node, List<Integer> result) {
        // List<Integer> result = new ArrayList<>();
        if (node == null) return;
        if (node.left == null && node.right == null) {
            result.add(node.val);
            return;
        }
        findLeftLeaves(node.left, result);
        findLeftLeaves(node.right, result);
        if (node.right != null && node.right.left == null && node.right.right == null) result.remove(result.size() - 1);
    }

    // elegent solution from nine chapter
    public int sumOfLeftLeaves9(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int sum = 0;
        if(root.left != null)
        {
            TreeNode left = root.left;
            if(left.left == null && left.right == null) {
                sum += left.val;
            }
            else {
                sum += sumOfLeftLeaves(left);
            }
        }
        if(root.right != null)
        {
            TreeNode right = root.right;
            sum += sumOfLeftLeaves(right);
        }
        return sum;
    }
}
