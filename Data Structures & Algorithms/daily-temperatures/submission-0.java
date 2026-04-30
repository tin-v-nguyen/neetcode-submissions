class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // stack of temperatures
        Stack<int[]> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int today = temperatures[i];
            while (!stack.isEmpty() && today > stack.peek()[0]) {
                int[] found = stack.pop();
                result[found[1]] = i - found[1];
            }

            stack.push(new int[]{today, i});
        }
        return result;
    }
}
