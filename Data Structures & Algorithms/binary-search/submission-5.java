class Solution {
    public int search(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        while (left <= right) {
            int index = left + (right - left) / 2;
            if (nums[index] == target) {
                return index;
            } else if (nums[index] > target) {
                right = index - 1;
            } else if (nums[index] < target) {
                left = index + 1;
            } 
        }
        return -1;
    }
}
