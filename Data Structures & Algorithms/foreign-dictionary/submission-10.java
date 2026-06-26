class Solution {
    Map<Character, Set<Character>> adj;
    Map<Character, Boolean> visited;
    StringBuilder sb;
    public String foreignDictionary(String[] words) {
        adj = new HashMap<>();
        // if char c not in -> we have not visited in any path
        // if char c -> true we visited in current path
        // set to false once done with path, false means not already in current path
        visited = new HashMap<>();
        sb = new StringBuilder();

        for (String w : words) {
            for (char c : w.toCharArray()) {
                adj.computeIfAbsent(c, k -> new HashSet<>());
            }
        }

        // calculate adj
        // loop through each consec pair
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            // check if passes prefix rule
            if (w1.length() > w2.length() && w1.substring(0, w2.length()).equals(w2)) {
                return "";
            }
            // find the first differing letter and create edge
            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                char less = w1.charAt(j), more = w2.charAt(j);
                if (less != more) {
                    adj.computeIfAbsent(less, k -> new HashSet<>()).add(more);
                    break;
                }
            }
        }
        
        // traverse graph from each letter
        for (char c : adj.keySet()) {
            // return blank if loop detected (indicated by return value of dfs)
            if (dfs(c)) return "";
        }

        return sb.reverse().toString();
        
    }

    // returns if loop
    public boolean dfs(char ch) {
        // check if already visited
        // return value of visited (will be true(loop) if in current path false if not)
        if (visited.containsKey(ch)) {
            return visited.get(ch);
        }

        // mark visited, and indicate its in curr path
        visited.put(ch, true);

        // keep traversing through all adjacent chars
        // if loop return true
        for (char c : adj.computeIfAbsent(ch, k -> new HashSet<>())) {
            if (dfs(c)) return true;
        }

        // done trav all greater nodes
        // remove from path
        // append to result
        visited.put(ch, false);
        sb.append(ch);
        return false;
    }
}
