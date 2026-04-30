/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        int index = 1;
        while (index < k) {
            pq.poll();
            index++;
        }
        return pq.peek();
    }
    private void dfs(TreeNode curr) {
        if (curr == null) return;
        pq.add(curr.val);
        dfs(curr.right);
        dfs(curr.left);
    }
}
