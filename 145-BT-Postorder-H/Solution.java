// Source: https://leetcode.com/problems/binary-tree-postorder-traversal/description/
// Author: xiaji
// Date: 2017-09-21
// Solution: Two stacks; postorder traversal is just reverse of preorder traversal 
// (travel from right to left)

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
 * return [3,2,1].
 * */

/** Mistakes:
 * type of postorder should be Stack<Integer>, not Stack<TreeNode>
 * becasue it will store the result of List
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  // private Stack<TreeNode> stack = new Stack<>();

  public List<Integer> postorderTraversal(TreeNode root) {
    Stack<TreeNode> preorder = new Stack<>();
    Stack<Integer> postorder = new Stack<>();
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;
    if (preorder.isEmpty()) preorder.push(root);
    while (!preorder.isEmpty()) {
      TreeNode current = preorder.pop();
      postorder.push(current.val);
      if (current.left != null) preorder.push(current.left);
      if (current.right != null) preorder.push(current.right);
    }
    while (!postorder.isEmpty()) {
      result.add(postorder.pop());
    }
    return result;
  }
}
