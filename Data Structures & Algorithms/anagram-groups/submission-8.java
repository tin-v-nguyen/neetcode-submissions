class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagrams = new HashMap<>();
        for (String s : strs) {
            int[] counter = new int[26];
            for(char c : s.toCharArray()) {
                counter[c - 'a']++;
            }
            String key = Arrays.toString(counter);
            if (!anagrams.containsKey(key)) {
                anagrams.put(key, new ArrayList<>());
            }
            anagrams.get(key).add(s);
        }
        return new ArrayList<>(anagrams.values());
    }
}
