class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<>();
        backtrack(nums, 0, target, current, result);
        return result;
    }

    private void backtrack(int[] nums, int i, int target, List<Integer>current, List<List<Integer>> result) {
        if (target < 0 || i >= nums.length) {
            return;
        }
        else if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[i]);
        backtrack(nums, i, target - nums[i], current, result);
        current.remove(current.size() - 1);
        backtrack(nums, i + 1, target, current, result);
    }
}
