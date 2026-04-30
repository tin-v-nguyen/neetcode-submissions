class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(candidates);
        List<Integer> curr = new ArrayList<>();
        dfs(candidates, 0, curr, res, target);
        return new ArrayList<>(res);
    }

    private void dfs(int[] candidates, int i, List<Integer> curr, Set<List<Integer>> res, int target) {
    if (target == 0) {
        res.add(new ArrayList<>(curr));
        return;
    }
    if (target < 0) return;

    Set<Integer> seen = new HashSet<>();
    for (int j = i; j < candidates.length; j++) {
        if (seen.contains(candidates[j])) continue;
        seen.add(candidates[j]);

        if (target - candidates[j] < 0) break;

        curr.add(candidates[j]);
        dfs(candidates, j + 1, curr, res, target - candidates[j]);
        curr.remove(curr.size() - 1);
    }
}
}
