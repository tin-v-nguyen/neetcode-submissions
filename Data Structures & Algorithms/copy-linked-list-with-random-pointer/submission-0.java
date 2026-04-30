/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        // first pass create nodes and map them
        Node curr = head;
        while(curr != null) {
            Node clone = new Node(curr.val);
            map.put(curr, clone);
            curr = curr.next;
        }

        // second pass assign next and random
        curr = head;
        while (curr != null) {
            Node clone = map.get(curr);
            clone.next = map.get(curr.next);
            clone.random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }
    
}
