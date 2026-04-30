class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        // Frequency array for s1
        int[] signature1 = new int[26];
        for (char c : s1.toCharArray()) {
            signature1[c - 'a']++;
        }

        // Initialize the first window in s2
        int[] window = new int[26];
        int i = 0;

        // Populate the initial window
        for (; i < s1.length(); i++) {
            window[s2.charAt(i) - 'a']++;
        }

        // Sliding window over s2
        for (i = 0; i <= s2.length() - s1.length(); i++) {
            // Check if current window matches signature1
            if (Arrays.equals(window, signature1)) return true;

            // Slide the window:
            // Remove the leftmost character and add the next character
            if (i + s1.length() < s2.length()) {
                window[s2.charAt(i) - 'a']--;                  // remove character going out
                window[s2.charAt(i + s1.length()) - 'a']++;    // add character coming in
            }
        }

        return false;
    }
}
