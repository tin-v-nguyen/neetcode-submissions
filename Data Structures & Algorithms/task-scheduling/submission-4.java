class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'A'] += 1;
        }

        PriorityQueue<Integer> active = new PriorityQueue<>((a, b) -> b - a);
        for (int i : count) {
            if (i != 0) active.add(i);
        }

        int cycles = 0;
        Queue<int[]> waiting = new LinkedList<>();
        while (!active.isEmpty() || !waiting.isEmpty()) {
            cycles++;

            // check if we have task that was done, do and add to waiting
            if (!active.isEmpty()) {
                // do task and add to waiting list
                int task = active.poll();
                if (task > 1) waiting.add(new int[]{task - 1, cycles + n});
            }

            // time passes
            

            // check if any waiting tasks can be added back to active now
            while (!waiting.isEmpty() && waiting.peek()[1] <= cycles) {
                active.add(waiting.poll()[0]);
            }
        }
        return cycles;

    }
}
