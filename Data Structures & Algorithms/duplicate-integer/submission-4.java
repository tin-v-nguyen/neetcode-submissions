class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> prev = new HashSet<>();
        for (int n : nums) {
            if (prev.contains(n)) { return true; }
            prev.add(n);
        }
        return false;
    }
}
