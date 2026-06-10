class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        // create a trie based on our words
        TrieNode root = generateTrie(words);
        // dfs using the trie and the board, keeping track of the current
        // word and visited squares on the board
        Set<String> res = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, res, root, visited);
            }
        }
        
        // return the res
        return new ArrayList<>(res);
    }

    private void dfs(char[][] board, int i, int j, Set<String> res, TrieNode curr, boolean[][] visited) {
        // if i or j is out of bounds return
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        
        // if curr node is null or visited return
        if (curr == null || visited[i][j]) return;

        // if curr node has no paths matching current square return
        if (curr.children[board[i][j] - 'a'] == null) return;

        curr = curr.children[board[i][j] - 'a'];

        // if curr is word add to res
        if (curr.isWord) res.add(curr.word);

        // mark visited and explore all possible paths
        visited[i][j] = true;
        dfs(board, i + 1, j, res, curr, visited);
        dfs(board, i - 1, j, res, curr, visited);
        dfs(board, i, j + 1, res, curr, visited);
        dfs(board, i, j - 1, res, curr, visited);
        visited[i][j] = false;
    }

    private TrieNode generateTrie(String[] words) {
        TrieNode root = new TrieNode("");
        
        for (String word : words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode(curr.word + c);
                }
                curr = curr.children[c - 'a'];
            }
            curr.isWord = true;
        }

        return root;
    }
}

class TrieNode {
    boolean isWord;
    String word;
    TrieNode[] children;

    public TrieNode(String word) {
        this.isWord = false;
        this.children = new TrieNode[26];
        this.word = word;
    }
}
