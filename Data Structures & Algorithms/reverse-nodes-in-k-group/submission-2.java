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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode(0, head);
        ListNode groupLeft = res;
        ListNode groupEnd = null;
        while ((groupEnd = getKth(groupLeft, k)) != null) {
            ListNode groupStart = groupLeft.next;
            ListNode groupRight = groupEnd.next;
            ListNode reversedHead = reverseK(groupLeft.next, k);
            groupLeft.next = reversedHead;
            groupStart.next = groupRight;
            groupLeft = groupStart;
        }
        return res.next;
    }

    private ListNode reverseK(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        while (k > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        return prev;
    }

    private ListNode getKth(ListNode node, int k) {
        ListNode res = node;
        for (int i = 0; i < k; i++) {
            if (res == null) return null;
            res = res.next;
        }
        return res;
    }
    
}
