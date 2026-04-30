class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) return 0;
        int l = 0;
        int leftMax = height[l];
        int r = height.length - 1;
        int rightMax = height[r];
        int res = 0;

        while (l < r) {
            int left = height[l];
            int right = height[r];
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }
        return res;
    }
}
