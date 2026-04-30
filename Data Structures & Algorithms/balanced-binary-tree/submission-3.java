class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1; // If dfs() returns -1, the tree is unbalanced
    }

    private int dfs(TreeNode curr) {
        if (curr == null) return 0; // Base case: null node has height 0

        int left = dfs(curr.left);
        if (left == -1) return -1; // If left subtree is unbalanced, return -1 immediately

        int right = dfs(curr.right);
        if (right == -1) return -1; // If right subtree is unbalanced, return -1 immediately

        if (Math.abs(left - right) > 1) return -1; // If height difference is more than 1, unbalanced

        return Math.max(left, right) + 1; // Return the height of this subtree
    }
}
