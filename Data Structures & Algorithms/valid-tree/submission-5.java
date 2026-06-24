class Solution {
    public boolean validTree(int n, int[][] edges) {
        /*
            assumptions:
                * a group of nodes makes a tree when all nodes are connected
                * and there are no cycles/loop
                * a single node is a tree
        */

        List<List<Integer>> adj = new ArrayList<>();
        // init
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // populate adjacency list
        for (int[] edge : edges) {
            int n1 = edge[0];
            int n2 = edge[1];

            // undirected means can go either way
            adj.get(n1).add(n2);
            adj.get(n2).add(n1);
        }
        
        // store visited nodes for loop detection, 
        // at the end will visit all nodes if this is a tree
        Set<Integer> visited = new HashSet<>();

        // when detecting a loop in an undirected graph, need to keep track of prev node
        // to avoid going "backwards" causing false positive loop detection 
        // since there is always an edge going back
        return dfs(adj, 0, -1, visited) && visited.size() == n;
    }

    private boolean dfs(List<List<Integer>> adj, int curr, int prev, Set<Integer> visited) {
        if (visited.contains(curr)) return false;

        visited.add(curr);
        for (int next : adj.get(curr)) {
            if (next == prev) continue;
            if (!dfs(adj, next, curr, visited)) return false;
        }

        return true;
    }
}
