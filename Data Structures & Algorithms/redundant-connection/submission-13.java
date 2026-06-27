class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        // keep track of a "root" node given a node
        // each node starts as its own root
        int[] par = new int[edges.length + 1];
        par = IntStream.range(0, edges.length + 1).toArray();

        // keep track of the size of each "tree"
        // make smaller tree child of larger trees for compression efficiency
        // init to each node is its own component of size 1
        int[] size = IntStream.generate(() -> 1).limit(edges.length + 1).toArray();

        // go through each edge until find a loop
        for (int[] e : edges) {
            int n1 = e[0], n2 = e[1];

            // if n1 and n2 already in same component we this edge creates the loop
            if (!union(par, size, n1, n2)) return new int[]{n1, n2};
        }

        return new int[0];
    }

    // function to find the root of the component a given node is in
    // while updating the parent of the node to the root
    private int find(int[] par, int n) {
        int p = par[n];
        // while we aren't at a root
        while (p != par[p]) {
            // compress path
            par[p] = par[par[p]];
            p = par[p];
        }
        return p;
    }

    // func to union true components and returns false if loop true if success
    private boolean union(int[] par, int[] size, int n1, int n2) {
        int p1 = find(par, n1);
        int p2 = find(par, n2);

        if (p1 == p2) return false;

        // the nodes are separate components
        // connect the smaller tree to the larger tree
        // if we every need to do a find, less path compression
        if (size[p1] <= size[p2]) {
            par[p1] = par[p2];
            size[p2] += size[p1];
        } else {
            par[p2] = par[p1];
            size[p1] += size[p2];
        }
        return true;
    }
}
