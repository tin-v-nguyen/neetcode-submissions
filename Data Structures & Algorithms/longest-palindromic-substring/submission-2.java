class Solution {
    public String longestPalindrome(String s) {
        int resS = 0;
        int resL = 0;
        for (int i = 0; i < s.length(); i++) {
            // odd
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > resL) {
                    resS = l;
                    resL = r - l + 1;
                }
                r++;
                l--;
            }

            // even
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > resL) {
                    resS = l;
                    resL = r - l + 1;
                }
                r++;
                l--;
            }
        }

        return s.substring(resS, resS + resL);
    }
}
