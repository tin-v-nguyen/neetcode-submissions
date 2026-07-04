class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int max = 1;
        int min = 1;

        for (int n : nums) {

            int tmp = max;
            max = Math.max(n, Math.max(tmp * n, min * n));
            min = Math.min(n, Math.min(tmp * n, min * n));

            res = Math.max(res, max);
        }
        return res;
    }
}
