// Source: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/discuss/
// Author: xiaji
// Date: 2017-09-22
// Solution: divide and conquer


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
 *
 */

public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root.val<Math.min(p.val,q.val)) return lowestCommonAncestor(root.right,p,q);
    if(root.val>Math.max(p.val,q.val)) return lowestCommonAncestor(root.left,p,q);
    return root;
  }

}
