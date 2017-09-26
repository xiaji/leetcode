// Source: https://leetcode.com/problems/binary-search-tree-iterator/description/
// Author: xiaji
// Date: 2017-09-26
// Solution: use stack to iterate inorder of BST, because inorder of BST is non-decrement


/**
 * implement an iterator over a binary search tree (BST). 
 * Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
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
 * use ArrayList to store the result, when use remove method, which needs an index variable;
 * instead reverse the result, just use Queue to pop the first element(the next smallest element)
 */

public class BSTIterator {
    // private TreeNode current;
    Stack<TreeNode> stack;
    Queue<Integer> result;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        result = new LinkedList<Integer>();
        if (root == null) {
        stack.push(root);
        while (!stack.isEmpty()) {
          while (root.left != null) {
            stack.push(root.left);
            root = root.left;
          }
          TreeNode current = stack.pop();
          result.add(current.val);
          if (current.right != null) {
            root = current.right;
            stack.push(root);
          }
        }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !result.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        return result.remove();
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

