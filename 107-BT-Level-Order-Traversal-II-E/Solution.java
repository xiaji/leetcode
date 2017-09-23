// Source: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
// Author: xiaji
// Date: 2017-09-23
// Solution: queue and stack


/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
 * return its bottom-up level order traversal as:
  [[15,7],
  [9,20],
  [3]]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List result = new ArrayList();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Stack<List<Integer>> stack = new Stack<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                level.add(current.val);
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            stack.push(level);
        }
        while(!stack.isEmpty()) result.add(stack.pop());
        return result;
        
    }
}
