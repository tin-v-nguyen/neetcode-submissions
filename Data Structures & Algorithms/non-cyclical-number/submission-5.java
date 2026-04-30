class Solution {
    public boolean isHappy(int n) {
        int slow = n; int fast = sumOfSquares(n);
        int power = 1, lam = 1;
        while (slow != fast) {
            if (power == lam) {
                slow = fast;
                power *= 2;
                lam = 0;
            }
            lam++;
            fast = sumOfSquares(fast);
        }

        return fast == 1;

    }

    private int sumOfSquares(int n) {
        int res = 0;
        while (n != 0) {
            int digit = n % 10;
            res += digit * digit;
            n /= 10;
        }
        return res;
    }
}
