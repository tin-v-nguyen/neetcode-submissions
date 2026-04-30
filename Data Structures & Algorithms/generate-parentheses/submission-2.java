class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> combos = new ArrayList<>();
        backtrack(combos, "", 0, 0, n);
        return combos;
    }

    private void backtrack(
        List<String> combos, 
        String curr,
        int open,
        int closed,
        int n
        ) {
            if (open == n && closed == n) {
                combos.add(curr);
                return;
            }
            if (open < n) {
                backtrack(combos, curr + "(", open + 1, closed, n);
            }
            if (closed < open) {
                backtrack(combos, curr + ")", open, closed + 1, n);
            }
            return;
    }
}
