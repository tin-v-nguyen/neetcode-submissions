class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 1) {
            List<Integer> ans = new ArrayList<>();
            ans.add(nums[0]);
            return Arrays.asList(ans);
        }

        List<List<Integer>> perms = permute(Arrays.copyOfRange(nums, 1, nums.length));
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> p : perms) {
            for (int i = 0; i <= p.size(); i++) {
                List<Integer> perm = new ArrayList<>(p);
                perm.add(i, nums[0]);
                res.add(perm);
            }
        }

        return res;
    }
}
