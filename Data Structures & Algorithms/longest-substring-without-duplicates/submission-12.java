class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int start = 0;
        Map<Character, Integer> charPos = new HashMap<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (charPos.containsKey(arr[i]) && charPos.get(arr[i]) >= start) {
                start = charPos.get(arr[i]) + 1; 
            }
            int length = i - start + 1;
            maxLength = Math.max(maxLength, length);
            charPos.put(arr[i], i);
        }
        return maxLength;
    }
}
