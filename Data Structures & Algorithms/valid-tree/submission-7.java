class Solution {
    public boolean validTree(int n, int[][] edges) {
        /*
                     0
                    /|\
                   1 2 3
                  
                 4

                     0
                    / 
                   1-2-3
                  / \_/
                 4

            // cant have loops
            // all nodes are connected
            // number of edges = n - 1

            // traverse nodes
            // keep a adjacency list tells us where we can go given a node
            - loop through all edges
            - give an edge (n1, n2) we need to update both node's adj list to 
                have the other node

            - as we traverse we keep track of what nodes we have been to already
            - if we end up at a visited node then that means we are in a loop
            - for each node we use the adj list to explore all of its neighbors
            - NOTE: since an edge is two-way, we need to avoid going backwards by keeping
                track of the prev node and skipping that traversal
            
            - at the end our visited should equal our number of nodes
            - and no loops means we have a tree
        */

        if (n - 1 != edges.length) return false;

        // create adj list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        // init adj list
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        // all nodes need to be connected so just pick one and traverse
        Set<Integer> visited = new HashSet<>();
        return dfs(0, -1, adj, visited) && visited.size() == n;

    }

    private boolean dfs(int node, int prev, List<List<Integer>> adj, Set<Integer> visited) {
        if (visited.contains(node)) return false;

        visited.add(node);
        for (int next : adj.get(node)) {
            if (next == prev) continue;
            if (!dfs(next, node, adj, visited)) return false;
        }

        return true;

    }
}
