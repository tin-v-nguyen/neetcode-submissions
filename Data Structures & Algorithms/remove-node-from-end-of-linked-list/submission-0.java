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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode counter = head;
        int count = 0;
        while (counter != null) {
            count++;
            counter = counter.next;
        }
        // remove is now the index of the node to remove
        int remove = count - n;
        if (remove == 0) return head.next;
        counter = head;
        ListNode prev = null;
        while (remove > 0) {
            prev = counter;
            counter = counter.next;
            remove--;
        }
        prev.next = counter.next;
        return head;
    }
}
