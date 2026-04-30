class Solution {
    public int findDuplicate(int[] nums) {
        int res = 0;
        for (int b = 0; b < 32; b++) {
            int numsFreq = 0;
            int normFreq = 0;
            int bit = 1 << b;
            for (int n : nums) {
                if ((n & bit) != 0) {
                    numsFreq++;
                }
            }
            for (int i = 1; i < nums.length; i++) {
                if ((i & bit) != 0) {
                    normFreq++;
                }
            }
            if (numsFreq > normFreq) {
                res |= bit;
            }

        }
        return res;
    }
}
