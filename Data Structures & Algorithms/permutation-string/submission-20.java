class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        int[] sig1 = new int[26];
        for (char c : s1.toCharArray()) {
            sig1[c - 'a']++;
        }
        // need 26 matches
        int matches = 0;
        int[] window = new int[26];

        // init window
        for (int i = 0; i < s1.length(); i++) {
            window[s2.charAt(i) - 'a']++;
        }
        for (int i = 0 ; i < 26; i++) {
            if (window[i] == sig1[i]) matches++;
        }

        int i = s1.length();
        while (i < s2.length()) {
            if (matches == 26) return true;
            // window move
            int charAdd = s2.charAt(i) - 'a';
            int charRem = s2.charAt(i - s1.length()) - 'a';
            // if they are equal the signature didnt change so we can continue
            i++;
            if (charAdd == charRem) continue;
            // check if chars to be added and removed 
            // are currently matching
            boolean addMatched = sig1[charAdd] == window[charAdd];
            boolean remMatched = sig1[charRem] == window[charRem];

            // add and remove
            window[charRem]--;
            window[charAdd]++;
            
            // check matches after moving window
            boolean addMatch = sig1[charAdd] == window[charAdd];
            boolean remMatch = sig1[charRem] == window[charRem];

            // if matched and match are both true or false dont need to do anything
            if (addMatched && !addMatch) matches--;
            else if (!addMatched && addMatch) matches++;
            if (remMatched && !remMatch) matches--;
            else if (!remMatched && remMatch) matches++;
        }
        return matches == 26;
    }
}
