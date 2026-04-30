class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        std::unordered_map<int, int> freqs;
        vector<vector<int>> buckets(nums.size() + 1);
        for (int n : nums) {
            freqs[n]++;
        }
        for (const auto& pair : freqs) {
            buckets[pair.second].push_back(pair.first);
        }
        vector<int> result(k);
        int index = 0;
        for (int i = buckets.size() - 1; i >= 0; i--) {
            for (int n : buckets[i]) {
                result[index] = n;
                index++;
                if (index == k) return result;
            }
        }
        return result;
    }
};
