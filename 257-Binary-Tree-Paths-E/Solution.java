// Source: https://leetcode.com/problems/binary-tree-paths/description/
// Author: xiaji
// Date: 2017-09-24
// Solution: divide and conquer


/**
 * Given a binary tree, return all root-to-leaf paths.
 * For example, given the following binary tree:
      1
    /   \
    2   3
    \
    5
 * All root-to-leaf paths are: ["1->2->5", "1->3"]
 * */

/** Mistakes:
 *  when the root is a leaf, method addNode argument List s, the boundary condition is not s == null
 *  also s.size() == 0; it's simillar to array s, s == null || s.length == 0
 *  Input:[1,2,3,null,5] Output:
["1->2->5","1->2->5","1->2","1->3","1->3"]
Expected:
["1->2->5","1->3"]
 */


class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
      List<String> path = new ArrayList();
      if (root == null) return path;
      List<String> left =  binaryTreePaths(root.left);
      List<String> right =  binaryTreePaths(root.right);
      path.addAll(this.addNodes(left, root));
      path.addAll(this.addNodes(right, root));
      if (path.size() == 0) path.add(root.val + "");
      return path;

    }

    private List<String> addNodes(List<String> s, TreeNode node) {
      List<String> path = new ArrayList();
      // Mistake!! when a node is a leaf, it will repeat add node.val into path list;
      /*if (s == null || s.size() == 0) {
        path.add(node.val + "");
        return path;
      }*/
      /*
       * for (String temp : s) {
       *  path.add(root.val + "->" + temp);
       * }
       */
      for (int i = s.size() - 1; i >= 0; i--) {
        String temp = root.val + "->" + s.get(i);
        path.add(temp);
      }
      return path;
    }
}
