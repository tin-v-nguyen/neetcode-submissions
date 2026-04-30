class Solution {
public:

    string encode(vector<string>& strs) {
        string encoded;
        for (const auto& s : strs) {
            encoded += to_string(s.length()) + '|' + s;
        }
        return encoded;
    }

    vector<string> decode(string s) {
        vector<string> decoded;
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (s[j] != '|') {
                j++;
            }
            int length = stoi(s.substr(i, j - i));
            i = j + 1;
            j = i + length;
            decoded.push_back(s.substr(i, length));
            i = j;
        }
        return decoded;
    }
};
