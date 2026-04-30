class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> curr = new ArrayList<>();
        dfs(candidates, 0, curr, res, target);
        return res;
    }

    private void dfs(int[] candidates, int i, List<Integer> curr, List<List<Integer>> res, int target) {
    if (target == 0) {
        res.add(new ArrayList<>(curr));
        return;
    }
    
    for (int j = i; j < candidates.length; j++) {
        if (j > i && candidates[j] == candidates[j - 1]) continue;
        if (target - candidates[j] < 0) break;

        curr.add(candidates[j]);
        dfs(candidates, j + 1, curr, res, target - candidates[j]);
        curr.remove(curr.size() - 1);
    }
}
}
