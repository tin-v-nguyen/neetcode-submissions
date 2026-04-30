class Solution {
    public int maxArea(int[] heights) {
        int distance = heights.length - 1;
        int l = 0;
        int r = heights.length - 1;
        int area = 0;
        while (l < r) {
            if (heights[l] < heights[r]) {
                area = Math.max(area, distance * heights[l]);
                l++;
                distance--;
            } else {
                area = Math.max(area, distance * heights[r]);
                r--;
                distance--;
            }
        }
        return area;
        
    }
}
