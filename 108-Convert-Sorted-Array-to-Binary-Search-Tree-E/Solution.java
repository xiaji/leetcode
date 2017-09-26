// Source: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
// Author: xiaji
// Date: 2017-09-21
// Solution:


/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int start = 0, end = nums.length - 1;
        return toBST(nums, start, end);
    }
    
    private TreeNode toBST(int[] nums, int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toBST(nums, lo, mid - 1);
        root.right = toBST(nums, mid + 1, hi);
        return root;
    }
}
