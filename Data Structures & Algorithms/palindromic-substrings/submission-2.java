class Solution {
    public int countSubstrings(String s) {
        // boolean array pal[i][j] where i is the length of the palindrome and j is the starting index
        boolean[][] pal = new boolean[s.length() + 1][s.length()];

        int count = 0;

        // for each length of palindrome, its a palindrome if the palidrome 2 shorter is true
        // and the tail end chars are the same
        // we can consider 0 length and 1 length palindromes to all be true
        // store the count as we go
        for (int i = 0; i < s.length(); i++) {
            pal[0][i] = true;
            pal[1][i] = true;
            count++;
        }

        for (int i = 2; i < s.length() + 1; i++) {
            for (int j = 0; j < s.length() - i + 1; j++) {
                if (pal[i - 2][j + 1]
                && s.charAt(j) == s.charAt(j + i - 1)
                ) {
                    pal[i][j] = true;
                    count++;
                }
            }
        }

        // return the count
        return count;
    }
}
