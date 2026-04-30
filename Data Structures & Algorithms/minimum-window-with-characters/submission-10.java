class Solution {
    public String minWindow(String s, String t) {
        if (t.length() == 0) return "";
        Map<Character, Integer> tSig = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            tSig.put(c, tSig.getOrDefault(c, 0) + 1);
        }
        int l = 0;
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int need = tSig.size();
        int have = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (!tSig.containsKey(c)) continue;
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (tSig.get(c) == window.get(c)) have++;
            
            while (have == need) {
                if ((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);
                if (tSig.containsKey(leftChar)) {
                    window.put(leftChar, window.getOrDefault(leftChar, 0) - 1);
                    if (window.get(leftChar) < tSig.get(leftChar)) {
                        have--;
                    }
                }
                l++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
