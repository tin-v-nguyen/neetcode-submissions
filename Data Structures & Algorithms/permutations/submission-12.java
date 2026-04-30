class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        List<Integer> remaining = new ArrayList<>();
        for (int n : nums) {
            remaining.add(n);
        }
        backtrack(current, remaining, result);
        return result;
    }
    private void backtrack(List<Integer> current, List<Integer> remaining, List<List<Integer>> result) {
        if (remaining.size() <= 0) {
            result.add(current);
            return;
        }
        for (int i = 0; i < remaining.size(); i++) {
            ArrayList<Integer> curr = new ArrayList<>(current);
            ArrayList<Integer> rem = new ArrayList<>(remaining);
            curr.add(remaining.get(i));
            rem.remove(remaining.get(i));
            backtrack(curr, rem, result);
        }
    }

}
