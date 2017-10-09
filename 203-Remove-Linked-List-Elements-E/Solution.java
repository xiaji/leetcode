// Source: https://leetcode.com/problems/remove-linked-list-elements/description/
// Author: xiaji
// Date: 2017-10-09
// Solution: basic operations for Linked List


/**
 * Remove all elements from a linked list of integers that have value val.
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
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
 * 
 *
 * */

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        if (head.next == null && head.val != val) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while (head.next != null) {
            if (head.next.val == val) head.next = head.next.next;
            else head = head.next;
        }
        return dummy.next;
    }
}
