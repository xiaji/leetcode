// Source: https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
// Author: xiaji
// Date: 2017-10-09
// Solution: basic operations for Linked List


/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/** Mistakes:
 * when use node.val, must check node != null; miss while condition code.next != null
 * it can not garauntee node.next.val exists
 * */

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = head;
        while(node != null && node.next != null) {
            if (node.val == node.next.val) node.next = node.next.next;
            else node = node.next;
        }
        return head;
    }
}
