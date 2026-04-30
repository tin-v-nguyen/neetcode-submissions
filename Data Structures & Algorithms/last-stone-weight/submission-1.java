class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int stone : stones) {
            minHeap.add(stone * -1);
        }
        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            if (first == second) continue;
            if (second > first) {
                minHeap.add(first - second);
            }
        }
        minHeap.add(0);
        return minHeap.poll() * -1;
    }
}
