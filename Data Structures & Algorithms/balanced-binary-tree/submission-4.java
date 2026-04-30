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
    public boolean isBalanced(TreeNode root) {
        boolean[] balance = new boolean[1];
        balance[0] = true;
        dfs(root, balance);
        return balance[0];
        
    }

    private int dfs(TreeNode curr, boolean[] balance) {
        if (curr == null) return 0;
        int right = dfs(curr.right, balance);
        int left = dfs(curr.left, balance);
        if (Math.abs(left - right) > 1) {
            balance[0] = false;
        }
        return Math.max(right, left) + 1;
    }
}
