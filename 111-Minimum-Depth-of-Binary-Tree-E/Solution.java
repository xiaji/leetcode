// Source: https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
// Author: xiaji
// Date: 2017-09-22
// Solution: divide and conquer


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
 *   3
 * /
 * 1
 * when the subtree is empty, you can not just return min 0, the path can go along another way;
 * add Line 36 to handle this case
 */

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (Math.min(left, right) == 0) return Math.max(left, right) + 1;
        return Math.min(left, right) + 1;
    }
}

