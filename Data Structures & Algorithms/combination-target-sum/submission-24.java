class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
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

        for (int i = index; i < nums.length; i++) {
            if (target - nums[i] < 0) return;
            curr.add(nums[i]);
            dfs(nums, i, target - nums[i], curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
