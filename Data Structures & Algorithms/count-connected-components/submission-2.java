class Solution {
    public int countComponents(int n, int[][] edges) {
        // create adj list to keep track of where we can go given a node
        // loop through edges and add to data
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        // create set so we know which nodes are already part of a component
        // if we wanted to be able to know what nodes are in a given component 
        // wed need to maintain a map but not part of problem
        Set<Integer> visited = new HashSet<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            // we are in an existing component
            if (visited.contains(i)) continue;

            // new component
            count++;

            // use bfs to mark all connected nodes visited
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while (!q.isEmpty()) {
                int curr = q.poll();
                visited.add(curr);
                for (int neigh : adj.get(curr)) {
                    if (visited.contains(neigh)) continue;
                    q.add(neigh);
                }
            }
        }

        return count;
    }
}
