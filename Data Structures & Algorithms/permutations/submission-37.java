class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int mask, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if ((mask & (1 << i)) == 0) {
                List<Integer> next = new ArrayList<>(curr);
                next.add(nums[i]);
                backtrack(nums, mask | (1 << i), next, res);
                next.remove(next.size() - 1);
            }
        }

    }
}
