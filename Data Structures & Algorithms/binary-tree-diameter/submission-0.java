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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode curr, int[] res) {
        // return the max height of the branch starting with curr
        if (curr == null) return 0;
        int right = dfs(curr.right, res);
        int left = dfs(curr.left, res);
        // update max diameter (left + right) of current node
        res[0] = Math.max(res[0], right + left);
        // return the height of tree starting with curr
        return 1 + Math.max(right, left);
    }
}
