// Source: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
// Author: xiaji
// Date: 2017-09-22
// Solution: data structure queue for BFS


/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
 * return its zigzag level order traversal as:
 * [[3],[20,9],[15,7]]
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
 * there are three ways to implement DFS
 * 2 queues
 * 1 queue + dummy node
 * 1 queue
 * follow Qs: can we not use stack to implement it?
 */

class Solution {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    int j = 0;
    while (!queue.isEmpty()) {
      List<Integer> level = new ArrayList<Integer>();
      Stack<Integer> temp = new Stack<Integer>();
      int size = queue.size();
      j++;
      for (int i = 0; i < size; i++) {
        TreeNode head = queue.poll();
        // level.add(head.val);
        if (j % 2 == 0) temp.push(head.val);
        else level.add(head.val);
        if (head.left != null) queue.offer(head.left);
        if (head.right != null) queue.offer(head.right);
      }
      if (j % 2 == 0) {
        while (!temp.isEmpty()) level.add(temp.pop());
      }
      result.add(level);
    }
    return result;
  }
}
