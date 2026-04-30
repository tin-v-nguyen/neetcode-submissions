class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pairs = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> times = new Stack<>();
        for (int[] pair : pairs) {
            times.push((double) (target - pair[0]) / pair[1]);
            if (times.size() >= 2 && times.get(times.size() - 2) >= times.peek()) {
                times.pop();
            } 
        }
        return times.size();
    }
}
