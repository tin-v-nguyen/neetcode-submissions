class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return Arrays.asList(new ArrayList<>());
        }

        List<List<Integer>> perms = permute(Arrays.copyOfRange(nums, 1, nums.length));
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < perms.size(); i++) {
            for (int p = 0; p <= perms.get(i).size(); p++) {
                List<Integer> copy = new ArrayList<>(perms.get(i));
                copy.add(p, nums[0]);
                res.add(copy);
            }
        }
        return res;
    }
}
