class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        int curr = n;
        while (!visited.contains(curr)) {
            visited.add(curr);
            curr = sumOfSquares(curr);
            if (curr == 1) return true;
        }

        return false;
    }

    private int sumOfSquares(int n) {
        int res = 0;
        while (n > 0) {
            int digit = n % 10;
            res += digit * digit;
            n /= 10;
        }
        return res;
    }
}
