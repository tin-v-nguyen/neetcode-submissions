class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        // a given combo either contains a given number or not
        dfs(nums, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int index, int target, List<Integer> curr, List<List<Integer>> res) {
        if (index >= nums.length || target < 0) return;
        
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        // search with nums[index] included
        curr.add(nums[index]);
        dfs(nums, index, target - nums[index], curr, res);
        curr.remove(curr.size() - 1);

        // search with nums[index] excluded
        dfs(nums, index + 1, target, curr, res);
    }
}
