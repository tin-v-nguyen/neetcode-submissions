class Solution {
    public int minCostConnectPoints(int[][] points) {
        int[][] cost = new int[points.length][points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                int xi = points[i][0];
                int xj = points[j][0];
                int yi = points[i][1];
                int yj = points[j][1];
                cost[i][j] = Math.abs(xi - xj) + Math.abs(yi - yj);
            }
        }

        int res = 0;
        Set<Integer> visited = new HashSet<>();
        // {distance, pointId}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, 0});
        while (visited.size() < points.length) {
            int[] curr = pq.poll();
            int dist = curr[0];
            int i = curr[1];
            if (visited.contains(i)) continue;
            res += dist;
            visited.add(i);
            for (int j = 0; j < points.length; j++) {
                if (visited.contains(j)) continue;
                int neiCost = cost[i][j];
                pq.add(new int[]{neiCost, j});
            }
        }
        return res;
    }
}
