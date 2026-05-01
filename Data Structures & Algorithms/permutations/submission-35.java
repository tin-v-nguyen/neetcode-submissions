class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, boolean[] picked, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!picked[i]) {
                List<Integer> next = new ArrayList<>(curr);
                next.add(nums[i]);
                picked[i] = true;
                backtrack(nums, picked, next, res);
                next.remove(next.size() - 1);
                picked[i] = false;
            }
        }

    }
}
