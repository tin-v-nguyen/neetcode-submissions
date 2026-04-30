class Solution {
    public int[][] merge(int[][] intervals) {
        // map of a point to number of intervals starting at that point (+)
        // or ending at that point (-)
        TreeMap<Integer, Integer> map = new TreeMap<>((a, b) -> Integer.compare(a, b));
        for (int[] interval : intervals) {
            map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
            map.put(interval[1], map.getOrDefault(interval[1], 0) - 1);
        }

        List<int[]> result = new ArrayList<>();
        int active = 0;
        int[] current = new int[2];
        for (int point : map.keySet()) {
            if (active == 0) current[0] = point;
            active += map.get(point);
            if (active == 0) {
                current[1] = point;
                result.add(new int[]{current[0], current[1]});
            }
            
        }

        return result.toArray(new int[result.size()][]);
    }
}
