class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] numsOfFreq = new List[nums.length + 1];
        Map<Integer, Integer> countOfNums = new HashMap<>();
        for (int i = 0; i < numsOfFreq.length; i++) {
            numsOfFreq[i] = new ArrayList<>();
        }
        for(int n : nums) {
            countOfNums.put(n, countOfNums.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : countOfNums.entrySet()) {
            numsOfFreq[entry.getValue()].add(entry.getKey());
        }
        int[] ans = new int[k];
        int index = 0;
        for (int i = numsOfFreq.length - 1; i > 0 && index < k; i--) {
            for (int n : numsOfFreq[i]) {
                ans[index] = n;
                index++;
                if (index == k) { return ans; }
            }
        }
        return ans;

    }
}
