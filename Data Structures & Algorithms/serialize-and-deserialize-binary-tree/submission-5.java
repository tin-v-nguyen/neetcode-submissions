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

    private StringBuilder encoded = new StringBuilder();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfsSerialize(root);
        return encoded.toString();
    }

    private void dfsSerialize(TreeNode node) {
        if (null == node) {
            encoded.append("|");
            encoded.append("^");
            return;
        }
        encoded.append("|");
        encoded.append(String.valueOf(node.val));
        dfsSerialize(node.left);
        dfsSerialize(node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tree = data.split("\\|");
        int[] i = {1};
        return dfsDecode(tree, i);
    }

    private TreeNode dfsDecode(String[] tree, int[] i) {
        if ("^".equals(tree[i[0]])) {
            i[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(tree[i[0]]));
        i[0]++;
        node.left = dfsDecode(tree, i);
        node.right = dfsDecode(tree, i);
        return node;
    }
}
