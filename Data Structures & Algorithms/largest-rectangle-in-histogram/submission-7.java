class Solution {
    public int largestRectangleArea(int[] heights) {
        // store (height, index)
        Stack<int[]> left = new Stack<>(); 
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while(!left.isEmpty() && heights[i] < left.peek()[0]) {
                int[] pop = left.pop();
                max = Math.max(pop[0] * (i - pop[1]), max);
                start = pop[1];
            }
            left.push(new int[]{heights[i], start});
        }
        for (int[] pair : left) {
            max = Math.max(max, pair[0] * (heights.length - pair[1]));
        }
        return max;
    }
}
