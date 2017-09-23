// Source: https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
// Author: xiaji
// Date: 2017-09-22
// Solution: divide and conquer


/**
 * Given a binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some starting node to
 * any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the root.
 * For example:
 * Given the below binary tree,

       1
      / \
     2   3
 * Return 6.
 * */

/** Mistakes:
 * maxPath at least contains one node, in other hand single path contains no nodes.
 *
 */

class Solution {
  private class ResultType {
    int singlePath, maxPath;
    ResultType(int singlePath, int maxPath) {
      this.singlePath = singlePath;
      this.maxPath = maxPath;
    }
  }

  private ResultType helper(TreeNode node) {
    if (node == null) return new ResultType(0, Integer.MIN_VALUE);
    // divide
    ResultType left = helper(node.left);
    ResultType right = helper(node.right);
    // conquer
    // Mistake 1:
    // this step, node.val should add in the first step;
    // it can avoid using negative value of node to cal the maxPath
    // if add node.val in line 43, when single and node.val are both negative,
    // we would rather throw away instead of using it.
    int single = Math.max(left.singlePath, right.singlePath) + node.val;
    single = Math.max(single, 0);

    int maxPath = Math.max(left.maxPath, right.maxPath);
    maxPath = Math.max(maxPath, left.singlePath + right.singlePath + node.val);
    return new ResultType(single, maxPath);
  }

  public int maxPathSum(TreeNode root) {
    if (root == null) return Integer.MIN_VALUE;
    ResultType result = this.helper(root); 
    return result.maxPath;
  }
}

