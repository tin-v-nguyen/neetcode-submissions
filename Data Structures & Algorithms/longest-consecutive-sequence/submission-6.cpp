class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        using namespace std;
        unordered_set<int> set;
        for (int n : nums) {
            set.insert(n);
        }
        int longest = 0;
        for (int n : nums) {
            if (set.count(n - 1)) continue;
            int curr = n;
            int length = 1;
            while (set.count(curr + 1)) {
                length++;
                curr++;
            }
            longest = max(longest, length);
        }
        return longest;
    }
};
