class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int ans = r;
        while (l <= r) {
            int speed = l + (r - l) / 2;
            int time = 0;
            for (int p : piles) {
                time += Math.ceil((double) p / speed);
            }
            if (time <= h) {
                ans = speed;
                r = speed - 1;
            } else {
                l = speed + 1;
            }
        }
        return ans;
    }
}
