class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // keep a queue of points ordered by their distance
        // {distance, x, y}
        // default is min heap
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1[0], p2[0]));
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int dist = x * x + y * y;
            minHeap.add(new int[]{dist, x, y});
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] point = minHeap.poll();
            res[i] = new int[]{point[1], point[2]};
        }
        return res;

    }
}

class DistanceComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] p1, int[] p2) {
        return p1[0] - p2[0];
    }
}
