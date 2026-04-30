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
    int good = 0;
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        dfs(root, root.val);
        return good;
    }

    private void dfs(TreeNode curr, int greatest) {
        if (curr == null) return;
        int max = Math.max(curr.val, greatest);
        if (curr.val == max) {
            good += 1;
        }
        dfs(curr.right, max);
        dfs(curr.left, max);
    }
}
