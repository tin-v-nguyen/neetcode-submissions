class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.length() != t.length()) return false;
        int sig[26] = {0};
        for (int i = 0; i < s.length(); i++) {
            sig[s[i] - 'a']++;
            sig[t[i] - 'a']--;
        }
        for (int val : sig) {
            if (val != 0) return false;
        }
        return true;
    }
};
