class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), res);
        return new ArrayList<>(res);
    }

    private void backtrack(int[] nums, int i, List<Integer> subset, Set<List<Integer>> res) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        backtrack(nums, i + 1, subset, res);
        subset.remove(subset.size() - 1);
        backtrack(nums, i + 1, subset, res);
    }
}
