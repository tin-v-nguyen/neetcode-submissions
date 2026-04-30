class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> locations = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (locations.containsKey(diff)) {
                return new int[] { locations.get(diff), i };
            }

            locations.put(nums[i], i);
        }
        return new int[0];
    }
}
