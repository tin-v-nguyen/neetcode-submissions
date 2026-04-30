class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        // rep largest in window monotonic decreasing 
        Deque<Integer> q = new LinkedList<>();
        int l = 0;
        int r = 0;
        // while the window is valid
        while (r < nums.length) {
            // kick out all values in window less than nums[r]
            // first element will always be largest in window
            while (!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.removeLast();
            }
            // add r
            q.add(r);

            // if first element is outside the window, remove it
            if (q.peek() < l) {
                q.poll();
            }

            // once window expands to k length
            if (r >= k - 1) {
                // add largest to res for that window
            // increment left
                res[l] = nums[q.peek()];
                l++;
            }
            

            // increment right
            r++;
        }
        return res;
        
    }
}
