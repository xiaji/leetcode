// Source: https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
// Author: xiaji
// Date: 2017-09-23
// Solution: queue


/**
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * Example 1:
 * Input:
    3
   / \
  9  20
    /  \
   15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. 
 * Hence return [3, 14.5, 11].
 * Note:
 * The range of node's value is in the range of 32-bit signed integer.
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
    public List<Double> averageOfLevels(TreeNode root) {
        List result = new ArrayList();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            double average = 0.0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                average += current.val;
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            result.add(average /= size);
        }
        return result;
    }
}
