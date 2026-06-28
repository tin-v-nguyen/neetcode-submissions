class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n + 1];
        cache[0] = 1;
        return dfs(cache, n);
    }

    private int dfs(int[] cache, int n) {
        if (n < 0) return 0;
        if (cache[n] != 0) return cache[n];
        cache[n] = dfs(cache, n - 1) + dfs(cache, n - 2);
        return cache[n];
    }
}
