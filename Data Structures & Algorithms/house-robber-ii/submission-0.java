class Solution {
    public int rob(int[] nums) {
        // two different rows, 
        // one for the solutions when no 1st house
        // one for with 1st house
        int[][] memo = new int[2][nums.length];

        if (nums.length == 1) return nums[0];

        return Math.max(
            dfs(memo[0], nums, 0, nums.length - 2),
            dfs(memo[1], nums, 1, nums.length - 1)
        );

    }

    private int dfs(int[] memo, int[] nums, int i, int end) {
        if (i > end) return 0;
        if (memo[i] != 0) return memo[i];
        return memo[i] = Math.max(nums[i] + dfs(memo, nums, i + 2, end), dfs(memo, nums, i + 1, end));
    }
}
