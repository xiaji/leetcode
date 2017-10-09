// Source: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
// Author: xiaji
// Date: 2017-10-09
// Solution: basic operations for Linked List


/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * Mistakes:
 * head.next = head.next.next.next
 * [1, 1, 1], result is [1], wrong answer
 * */

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                //head.next = head.next.next.next;
                int val = head.next.val;
                while (head.next != null && head.next.val == val) head.next = head.next.next;
            } else head = head.next;
        }
        return dummy.next;
    }
}
