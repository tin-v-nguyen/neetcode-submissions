class Solution {
    public int characterReplacement(String s, int k) {
        // left window
        int l = 0;
        // max length
        int maxLength = 0;
        // max frequency in a single window
        int maxF = 0;
        int[] freq = new int[26];
        for (int r = 0; r < s.length(); r++) {
            int temp = ++freq[s.charAt(r) - 'A'];
            maxF = Math.max(maxF, temp);
            // while window is invalid adjust
            while (r - l + 1 - maxF > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;
    }
}
