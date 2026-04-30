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
    public boolean isValidBST(TreeNode root) {
        long upper = Long.MAX_VALUE;
        long lower = Long.MIN_VALUE;
        return valid(root, upper, lower);
    }

    public boolean valid(TreeNode curr, long upper, long lower) {
        if (curr == null) return true;
        // validate curr
        if (curr.val <= lower || curr.val >= upper) return false;

        return valid(curr.left, curr.val, lower) && valid(curr.right, upper, curr.val);
        // validate curr.left with new upper of curr.val
        // validate curr.right with new lower of curr.val
    }
}
