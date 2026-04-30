class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(0, nums.length - 1, nums, target);
    }

    private int binarySearch(int l, int r, int[] nums, int target) {
        if (l > r) return -1;
        int index = l + (r - l) / 2;
        if (nums[index] == target) return index;
        else if (nums[index] < target) {
            return binarySearch(index + 1, r, nums, target);
        } else {
            return binarySearch(l, index - 1, nums, target);
        }
    }
}
