// Source: https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
// Author: xiaji
// Date: 2017-10-07
// Solution:


/**
 * Given a singly linked list where elements are sorted in ascending order
 * convert it to a height balanced BST.
 * */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 */

/** Mistakes:
 *
 *
 */

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
          list.add(head.val);
          head = head.next;
        }
        int lo = 0 , hi = list.size() - 1;
        return this.constructBST(list, lo, hi);
    }

    private TreeNode constructBST(List list, int lo, int hi) {
      if (lo > hi) return null;
      int mid = lo + (hi - lo) / 2;
      TreeNode root = new TreeNode(list.get(mid));
      root.left = constructBST(list, lo, mid - 1);
      root.right = constructBST(list, mid + 1, hi);
      return root;
    }
}
