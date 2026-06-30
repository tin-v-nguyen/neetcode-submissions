class Solution {
    public String longestPalindrome(String s) {
        // is this string a palindrome can be answered by
        // is the inner string a plaindrome and the outer characters matching
        // solve each length of palindrome first
        // use previous calculation to calculate next length
        int start = 0;
        int length = 1;

        // palindrome[i][j] represents whether string of length i starting at j is palindrome
        boolean[][] palindrome = new boolean[s.length() + 1][s.length()];

        for (int j = 0; j < s.length(); j++) {
            palindrome[0][j] = true;
            palindrome[1][j] = true;
        }
        // for each length of palindrome substring(j, j + i)
        for (int i = 2; i < s.length() + 1; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (j + i - 1 < s.length() 
                && s.charAt(j) == s.charAt(j + i - 1)
                && palindrome[i - 2][j + 1]
                ) {
                    palindrome[i][j] = true;
                    start = j;
                    length = i;
                }
            }
        }

        return s.substring(start, start + length);
    }
}
