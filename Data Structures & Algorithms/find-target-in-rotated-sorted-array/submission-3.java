class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) return m;
            // find if left or right part is ordered,
            // check if target is between ordered low and high
            // if not go to the other side
            // right side ordered and target between
            if (nums[m] <= nums[r]) {
                if (target >= nums[m] && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
                continue;
            } else {
                if (target <= nums[m] && target >= nums[l]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
                continue;
            }
        }
        return -1;
    }
}
