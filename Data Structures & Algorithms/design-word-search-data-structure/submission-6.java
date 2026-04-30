public class TrieNode {
    TrieNode[] children;
    boolean isWord;

    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }


}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (null == curr.children[c - 'a']) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int i, TrieNode curr) {
        if (curr == null) return false;

        if (i == word.length()) return curr.isWord;
        
        if (word.charAt(i) == '.') {
            boolean found = false;
            for (int j = 0; j < 26; j++) {
                if (dfs(word, i + 1, curr.children[j])) return true;
            }
            return false;
        }

        return dfs(word, i + 1, curr.children[word.charAt(i) - 'a']);
    }
}
