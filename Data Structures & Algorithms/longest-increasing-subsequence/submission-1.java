class Solution {
    public int lengthOfLIS(int[] nums) {
        // use a dfs where we explore possible paths (subsequeneces) and return the longest option
        // use a 2d array of the curr index and prev index so we only calculate the 
        // longest subsequence from a given pair once.
        // add one to the prev dimension to account for the initial -1 index
        // reference by an offset of +1 (1, 0) means curr = 0 prev = -1
        int[][] memo = new int[nums.length + 1][nums.length + 1];
        return dfs(0, -1, nums, memo);
    }

    // dfs with current index and last included number
    private int dfs(int curr, int last, int[] nums, int[][] memo) {
        if (curr >= nums.length) return 0;
        if (memo[curr + 1][last + 1] != 0) return memo[curr + 1][last + 1];

        int skip = dfs(curr + 1, last, nums, memo);

        int take = 0;
        if (last == -1 || nums[last] < nums[curr]) {
            take = 1 + dfs(curr + 1, curr, nums, memo);
        }
        memo[curr + 1][last + 1] = Math.max(skip, take);
        return memo[curr + 1][last + 1];
    }
}
