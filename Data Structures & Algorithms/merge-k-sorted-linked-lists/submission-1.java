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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(0);
        ListNode curr = res;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode l : lists) {
            if (l != null) pq.add(l);
        }
        while (!pq.isEmpty()) {
            ListNode pop = pq.poll();
            curr.next = pop;
            curr = curr.next;
            if (pop.next != null) pq.add(pop.next);
        }
        return res.next;
    }
}
