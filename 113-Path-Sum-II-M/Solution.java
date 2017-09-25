// Source: https://leetcode.com/problems/path-sum-ii/description/
// Author: xiaji
// Date: 2017-09-25
// Solution: divide and conquer / recursion


/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
 * return [
   [5,4,11,2],
   [5,8,4,5]
   ]
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
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List result = new ArrayList();
        List<Integer> path = new ArrayList<>();
        findPath(result, path, root, sum);
        return result;
    }
    
    public void findPath(List<List<Integer>> result, List<Integer> path, TreeNode node, int sum) {
        if (node == null) return;
        sum -= node.val;
        if (node.right == null && node.left == null) {
            if (sum == 0) {
                path.add(node.val);
                result.add(new ArrayList<Integer>(path));
                // we need to reconstruct our path, the node is a leaf, we should remove it from path,
                // go to another direction(left/right), and add their leaf
                path.remove(path.size() - 1);
            }
            return;
        }
        path.add(node.val);
        findPath(result, path, node.left, sum);
        findPath(result, path, node.right, sum);
        // traceback the last node and go another direction.
        path.remove(path.size() - 1);
    }
}
