class Solution {
    public int trap(int[] height) {
        int[] leftHighest = new int[height.length];
        int[] rightHighest = new int[height.length];

        int max = 0;
        for (int i = 1; i < height.length; i++) {
            max = Math.max(height[i - 1], max);
            leftHighest[i] = max;
        }

        max = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            max = Math.max(height[i + 1], max);
            rightHighest[i] = max;
        }

        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int limit = Math.min(rightHighest[i], leftHighest[i]);
            if (height[i] < limit) {
                res += limit - height[i];
            } 
        }
        return res;
    }
}
