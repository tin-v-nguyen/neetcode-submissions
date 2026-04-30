class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(nums, 0, curr, 0, res, target);
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> curr, int total, List<List<Integer>> res, int target) {
        if (total == target) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (total > target || i >= nums.length) return;
        curr.add(nums[i]);
        dfs(nums, i, curr, total + nums[i], res, target);
        curr.remove(curr.size() - 1);
        dfs(nums, i + 1, curr, total, res, target);
    }
}
