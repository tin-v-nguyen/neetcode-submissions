class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> charactersInS = new HashMap<>();
        HashMap<Character, Integer> charactersInT = new HashMap<>();
        // count the characters in S
        for (char c = 'a'; c <= 'z'; c++) {
            charactersInS.put(c, 0);
            charactersInT.put(c, 0);
        }

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            int currentCount = charactersInS.get(current);
            charactersInS.put(current, currentCount + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char current = t.charAt(i);
            int currentCount = charactersInT.get(current);
            charactersInT.put(current, currentCount + 1);
        }

        for (char c = 'a'; c <= 'z'; c++) {
            if (!charactersInS.get(c).equals(charactersInT.get(c))) return false;
        }

        return true;

    }
}
