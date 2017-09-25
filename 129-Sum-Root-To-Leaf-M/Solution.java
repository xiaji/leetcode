// Source: https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
// Author: xiaji
// Date: 2017-09-25
// Solution: divide and conquer


/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,

    1
   / \
  2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
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
 * easy follow the approach of simillar topics, need to think out of the box
 * just use the basic solution to BT, divide and conquer
 */

class Solution {
    public int sumNumbers(TreeNode root) {
      List<String> result = this.pathString(root);
      int sum = 0;
      for (String temp : result) {
        sum += Integer.parseInt(temp);
      }
      int findSum = this.findSum(root, 0) ;
      return sum;
    }

    private List<String> pathString(TreeNode root) {
      List<String> result = new ArrayList<>();
      if (root == null) return result;
      List<String> left = pathString(root.left);
      List<String> right = pathString(root.right);
      for (String s : left) result.add(root.val + "," + s);
      for (String s : right) result.add(root.val + "," + s);
      if (result.size() == 0) result.add(root.val);
      return result;
    }

    private int findSum(TreeNode root, int prev) {
      if (root == null) return 0;
      int sum = root.val + prev * 10;
      if (root.right == null && root.left == null) return sum;
      return findSum(root.left, sum) + findSum(root.right, sum);
    }

    // unneccessary: Integer.parseInt(03) = 3
    /*private int calString(String s) {
      String[] temp = s.split(",");
      int sum = 0;
      int len = temp.length;
      for (int i = 0; i < len; i++) {
        sum += Integer.parseInt(temp[i]) * Math.pow(10, len - i - 1);
      }
      return sum;
    }*/
}
