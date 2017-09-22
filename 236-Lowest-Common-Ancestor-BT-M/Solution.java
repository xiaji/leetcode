// Source: https://leetcode.com/problems/binary-tree-paths/description/
// Author: xiaji
// Date: 2017-09-22
// Solution: tradition method and divide and conquer


/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined
 * between two nodes v and w as the lowest node in T that has both v and w as descendants
 * (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3.
 * Another example is LCA of nodes 5 and 4 is 5,
 * since a node can be a descendant of itself according to the LCA definition.
 * */

/** Mistakes:
 * Traditional Method(parent node): the result is from node to root, so we should start from the last one inside loop
 *
 */

public class Solution {
  private ArrayList<TreeNode> getPath2Root(TreeNode root) {
    ArrayList<TreeNode> result = new ArrayList<>();
    while (root != null) {
      result.add(node);
      node = node.parent;
    }
    return result;
  }

  public TreeNode lowestCommonAncestor(TreeNode A, TreeNode B) {
    ArrayList<TreeNode> listA = this.getPath2Root(A);
    ArrayList<TreeNode> listB = this.getPath2Root(B);
    // Mistake: we must use two pointers, if only one , the return value is always get(0);
    // but in some case, listA still has elements left, we need to remeber that index instead of 0;
    // and the start index is not right for the longer list!!!
    // int length = Math.min(listA.size(), listB.size());
    for (int i = listA.size() - 1, j = listB.size() - 1; i >= 0 && j >= 0; i--, j--) {
      if(listA.get(i) != listB.get(j)) return listA.get(i).parent;
    }
    return listA.get(i+1);
  }

  private TreeNode getAncestor(TreeNode root, TreeNode A, TreeNode B) {
    // Mistake: root == A and root == B condition !!!
    // trick: just think about the basic case: when root is the root,
    // what's its relationship with A and B
    if (root == null || root == A || root == B) return root;

    TreeNode left = getAncestor(root.left, A, B);
    TreeNode right = getAncestor(root.right, A, B);

    // one node in the left, another in the right
    if (left != null && right != null) return root;
    // node A and node B in the left subtree
    if (left != null) return left;
    // node A and node B in the right subtree
    if (right != null) return right;
    
    return null;
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
    if (root == null || A == null || B == null) return null;
    return this.getAncestor(root, A, B);
  }

}
