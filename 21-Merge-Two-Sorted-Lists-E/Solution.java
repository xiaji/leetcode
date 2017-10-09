// Source: https://leetcode.com/problems/merge-two-sorted-lists/description/
// Author: xiaji
// Date: 2017-10-09
// Solution: basic operations for Linked List


/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3. 
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
 * l1 = l1.next; l2 = l2.next; outside the if condition;
 * so result is wrong;
 * */

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                node.next = l2;
                l2 = l2.next;
            } else {
                node.next = l1;
                l1 = l1.next;
            }
            //l1 = l1.next;
            //l2 = l2.next;
            node = node.next;
        }
        if (l1 != null) node.next = l1;
        if (l2 != null) node.next = l2;
        return dummy.next;
    }
}
