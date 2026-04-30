class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        std::unordered_map<int, int> numIndex;
        for (int i = 0; i < nums.size(); i++) {
            int diff = target - nums[i];
            if (numIndex.find(diff) != numIndex.end()) {
                return {numIndex[diff], i};
            }
            numIndex.insert({nums[i], i});
        }
        return {};
    }
};
