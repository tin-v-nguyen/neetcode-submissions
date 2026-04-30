class Solution {
    public int trap(int[] height) {
        if (height.length <= 2) return 0;
        int[] maxOnLeft = new int[height.length];
        int[] maxOnRight = new int[height.length];
        int[] minLR = new int[height.length];
        maxOnLeft[0] = 0;
        maxOnRight[height.length - 1] = 0;
        int trapped = 0;
        for (int i = 1; i < height.length; i++) {
            maxOnLeft[i] = Math.max(maxOnLeft[i - 1], height[i - 1]); 
        }
        for (int i = height.length - 2; i >= 0; i--) {
            maxOnRight[i] = Math.max(maxOnRight[i + 1], height[i + 1]); 
        }
        for (int i = 0; i < height.length; i++) {
            int trap = Math.min(maxOnLeft[i], maxOnRight[i]) - height[i];
            if (trap <= 0) continue;
            trapped += trap; 
        }
        return trapped;

    }
}
