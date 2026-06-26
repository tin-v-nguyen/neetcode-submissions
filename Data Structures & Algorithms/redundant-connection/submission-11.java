class Solution {
    List<List<Integer>> adj;
    Set<Integer> visited;
    Set<Integer> cycleMems;
    int cycleStart;

    public int[] findRedundantConnection(int[][] edges) {
        // n1 - n2 - n3 - n4
        // detect cycle
        // keep track of nodes in the cycle
        // figure whcih edge in cycle is last in edges

        // n == edges.length
        // n >= 3
        // edges[i][0] edges[i][1] are valid nodes


        // build adjacency list to rep graph
        adj = new ArrayList<>();
        for (int i = 0; i <= edges.length; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int n1 = e[0]; int n2 = e[1];
            adj.get(n1).add(n2);
            adj.get(n2).add(n1);
        }

        visited = new HashSet<>();
        cycleMems = new HashSet<>();
        cycleStart = -1;
        dfs(1, -1);

        int[] res = new int[2];
        for (int i = edges.length - 1; i >= 0; i--) {
            int n1 = edges[i][0]; int n2 = edges[i][1];
            if (cycleMems.contains(n1) && cycleMems.contains(n2)) {
                res = new int[]{n1, n2};
                break;
            }
        }

        return res;
    }

    private void dfs(int curr, int prev) {
        if (visited.contains(curr)) {
            cycleStart = curr;
            return;
        }

        visited.add(curr);
        for (int next : adj.get(curr)) {
            if (next == prev) continue;
            dfs(next, curr);
            if (cycleStart != -1) {
                cycleMems.add(curr);
                if (cycleStart == curr) {
                    cycleStart = -1;
                }
                return;
            }
        }
    }
}
