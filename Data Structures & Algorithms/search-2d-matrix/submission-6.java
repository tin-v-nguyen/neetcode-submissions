class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] nums = new int[matrix.length * matrix[0].length];
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                nums[index++] = matrix[i][j];
            }
        }
        return binarySearch(0, nums.length - 1, nums, target);
    }

    private boolean binarySearch(int l, int r, int[] nums, int target) {
        if (l > r) return false;
        int index = l + (r - l) / 2;
        if (nums[index] == target) return true;
        else if (nums[index] < target) return binarySearch(index + 1, r, nums, target);
        else {
            return binarySearch(l, index - 1, nums, target);
        }
    }
}
