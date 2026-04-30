class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        if (nums.size() == 0) return vector<int>();
        vector<int> upTo(nums.size());
        upTo[0] = 1;
        for (int i = 1; i < nums.size(); i++) {
            upTo[i] = upTo[i - 1] * nums[i - 1];
        }
        vector<int> downTo(nums.size());
        downTo[nums.size() - 1] = 1;
        for (int i = nums.size() - 2; i >= 0; i--) {
            downTo[i] = downTo[i + 1] * nums[i + 1];
        }
        vector<int> output(nums.size());
        for (int i = 0; i < nums.size(); i++) {
            output[i] = upTo[i] * downTo[i];
        }
        return output;
    }
};
