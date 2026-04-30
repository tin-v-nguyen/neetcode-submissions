class Solution {
    public int maxSubArray(int[] nums) {
        // keep prefix sum
        int prefixSum = 0;
        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            if (prefixSum < 0) {
                prefixSum = 0;
            }
            prefixSum += n;
            max = Math.max(max, prefixSum);
        }
        return max;
    }
}
