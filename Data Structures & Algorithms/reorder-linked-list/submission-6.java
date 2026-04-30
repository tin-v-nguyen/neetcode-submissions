/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        // find the middle
        ListNode end = head.next;
        ListNode middle = head;
        while (end != null && end.next != null) {
            end = end.next.next;
            middle = middle.next;
        }

        // reverse the middle to the end prev is the reversed head
        
        ListNode curr = middle.next;
        ListNode prev = middle.next = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // start with head and and merge with reversed second half
        ListNode second = prev;
        ListNode first = head;
        while (second != null) {
            ListNode p1 = first.next;
            ListNode p2 = second.next;
            first.next = second;
            second.next = p1;
            first = p1;
            second = p2;
        }
    }
}
