class PrefixTree {
    private Node root;

    public PrefixTree() {
         root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                Node n = new Node();
                n.c = c;
                curr.children[c - 'a'] = n;
            }
            curr = curr.children[c - 'a'];
        }
        curr.end = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) return false;
            curr = curr.children[c - 'a'];
        }
        return curr.end;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.children[c - 'a'] == null) return false;
            curr = curr.children[c - 'a'];
        }

        return true;
    }
}

private class Node {
    boolean end;
    char c;
    Node[] children;

    public Node() {
        children = new Node[26];
        end = false;
    }
}
