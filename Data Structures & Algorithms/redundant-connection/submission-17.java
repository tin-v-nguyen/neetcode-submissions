class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        // n nodes n edges
        // guarunteed exists one edge that can be removed to return tree to connected non cyclical
        // within a cycle, any edge in the cycle can be removed to restore tree
        // nodes in a cycle have at least 2 connections
        // nodes with 1 connection definitely not part of a cycle
        // we can cross out nodes with 1 connection 
        // once they are crossed out we dont count that node as a connection anymore
        // since that connection cannot lead to a cycle
        // after crossing out, we queue nodes that now only have 1 other connection to be crossed out
        // keep eliminating nodes and we will only be left with nodes in the cycle.
        // add nodes that still have connections (in cycle) to set
        // reverse iterate edges until we reach an edge where both vertices are in the cycle
        // return that edge

        List<List<Integer>> adj = new ArrayList<>();
        int[] connections = new int[edges.length + 1];
        for (int i = 0; i < edges.length + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int n1 = e[0], n2 = e[1];
            adj.get(n1).add(n2);
            adj.get(n2).add(n1);
            connections[n1]++;
            connections[n2]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < connections.length; i++) {
            if (connections[i] == 1) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            // remove connetion from graph
            connections[curr]--;
            for (int nei : adj.get(curr)) {
                if (--connections[nei] == 1) {
                    q.offer(nei);
                }
            }
        }

        Set<Integer> cycleSet = new HashSet<>();
        for (int i = 1; i < connections.length; i++) {
            if (connections[i] > 0) {
                cycleSet.add(i);
            }
        }

        for (int i = edges.length - 1; i >= 1; i--) {
            int n1 = edges[i][0], n2 = edges[i][1];
            if (cycleSet.contains(n1) && cycleSet.contains(n2)) {
                return new int[]{n1, n2};
            }
        }

        return new int[0];
    }
}
