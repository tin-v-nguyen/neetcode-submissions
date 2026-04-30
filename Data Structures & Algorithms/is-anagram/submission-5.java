class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sCounts = new int[26];

        for (char c : s.toCharArray()) {
            sCounts[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            sCounts[c - 'a']--;
        }

        for (int n : sCounts) {
            if (n != 0) return false;
        }
        return true;
    }
}
