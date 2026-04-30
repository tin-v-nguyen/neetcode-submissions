class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        std::unordered_map<string, vector<string>> groups;
        for (const auto& s : strs) {
            int sig[26] = {0};
            for (char c : s) {
                sig[c - 'a']++;
            }
            string key = to_string(sig[0]);
            for (int i = 0; i < 26; i++) {
                key += '|' + to_string(sig[i]);
            }
            groups[key].push_back(s);
        }
        vector<vector<string>> res;
        for (const auto& pair : groups) {
            res.push_back(pair.second);

        }
        return res;
    }
};
