class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> curr = new ArrayList<>();
        dfs(nums, 0, curr, 0, res, target);
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> curr, int total, List<List<Integer>> res, int target) {
        if (total == target) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int j = i; j < nums.length; j++) {
            if (total + nums[j] > target) return;

            curr.add(nums[j]);
            dfs(nums, j, curr, total + nums[j], res, target);
            curr.remove(curr.size() - 1);
        }
    }
}
