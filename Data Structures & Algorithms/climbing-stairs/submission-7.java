class Solution {
    public int climbStairs(int n) {
        // ways to reach the current step
        // ways to reach curr step
        int curr = 1;
        // ways to reach prev step
        int prev = 1;

        for (int i = 0; i < n - 1; i++) {
            int temp = curr;
            curr = curr + prev;
            prev = temp;
        }

        return curr;
    }
}
