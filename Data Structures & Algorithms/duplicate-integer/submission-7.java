class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> appeared = new HashSet<Integer>();
        for (int n : nums) {
            if (appeared.contains(n)) return true;
            appeared.add(n);
        }
        return false;
    }
}