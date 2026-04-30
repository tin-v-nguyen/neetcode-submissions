class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        for (String w : wordDict) {
            dict.add(w);
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for (int l = s.length() - 1; l >= 0; l--) {
            for (int i = l + 1; i < s.length() + 1; i++) {
                String curr = s.substring(l, i);
                if (dict.contains(curr)) {
                    dp[l] = dp[l + curr.length()];
                }
                if (dp[l]) {
                    break;
                }
            }
        }
        return dp[0];
    }
}
