class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (int n : nums) {
            List<List<Integer>> newRes = new ArrayList<>();
            for (List<Integer> p : res) {
                for (int i = 0; i <= p.size(); i++) {
                    List<Integer> newP = new ArrayList<>(p);
                    newP.add(i, n);
                    newRes.add(newP);
                }
            }
            res = newRes;
        }
        return res;
    }
}
