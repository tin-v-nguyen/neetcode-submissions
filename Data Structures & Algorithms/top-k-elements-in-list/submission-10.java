class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // O(n)
        Map<Integer, Integer> numFreq = new HashMap<>();
        for (int num : nums) {
            numFreq.put(num, numFreq.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] freqs = new List[nums.length + 1];
        for (int i = 0; i < freqs.length; i++) {
            freqs[i] = new ArrayList<>();
        }
        
        for (Map.Entry<Integer, Integer> entry : numFreq.entrySet()) {
            freqs[entry.getValue()].add(entry.getKey()); 
        }
        int[] res = new int[k];
        int index = 0;
        for (int i = freqs.length - 1; i > 0 && index < k; i--) {
            for (int n : freqs[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
