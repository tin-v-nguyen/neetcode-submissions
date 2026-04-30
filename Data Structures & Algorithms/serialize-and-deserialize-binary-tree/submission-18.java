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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        if (null == root) return "N";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) res.append("N,");
            else {
                res.append(curr.val).append(",");
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] code = data.split(",");
        if ("N".equals(code[0])) return null;
        TreeNode root = new TreeNode(Integer.parseInt(code[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (null == curr) continue;
            curr.left = code[i].equals("N") ? null : new TreeNode(Integer.parseInt(code[i]));
            q.add(curr.left);
            i++;
            curr.right = code[i].equals("N") ? null : new TreeNode(Integer.parseInt(code[i]));
            q.add(curr.right);
            i++;
        }

        return root;
    }
}
