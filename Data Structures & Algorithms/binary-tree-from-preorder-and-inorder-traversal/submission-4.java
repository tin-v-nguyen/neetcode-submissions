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
    int pInd = 0;
    int iInd = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, Integer.MAX_VALUE);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int limit) {
        // already built all nodes
        if (pInd >= preorder.length) return null;

        // build all nodes left of limit node
        if (inorder[iInd] == limit) {
            iInd++;
            return null;
        }
        TreeNode curr = new TreeNode(preorder[pInd++]);
        // build left tree up to curr node in inorder
        curr.left = dfs(preorder, inorder, curr.val);
        // build right tree up to curr nodes parent node in order
        curr.right = dfs(preorder, inorder, limit);
        return curr;
    }
}
