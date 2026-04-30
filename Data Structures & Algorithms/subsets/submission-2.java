class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        dfs(nums, 0, current, result);
        return result;
    }
    private void dfs(int[] nums, int i, List<Integer> current, 
        List<List<Integer>> result) {
            if (i >= nums.length) {
                result.add(new ArrayList<>(current));
                return;
            }
            current.add(nums[i]);
            dfs(nums, i + 1, current, result);
            current.remove(current.size() - 1);
            dfs(nums, i + 1, current, result);
        }
}
