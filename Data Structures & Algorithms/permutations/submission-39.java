class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, res);
        return res;
    }

    private void backtrack(int[] nums, int axis, List<List<Integer>> res) {
        if (axis == nums.length) {
            List<Integer> perm = new ArrayList<>();
            for (int n : nums) perm.add(n);
            res.add(perm);
            return;
        }

        for (int i = axis; i < nums.length; i++) {
            swap(nums, axis, i);
            backtrack(nums, axis + 1, res);
            swap(nums, axis, i);
        }



    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
