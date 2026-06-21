class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> preMap = new HashMap<>();
        // create preMap
        for (int[] req : prerequisites) {
            int course = req[0];
            int prereq = req[1];
            preMap.computeIfAbsent(course, k -> new HashSet<>());
            preMap.get(course).add(prereq);
        }

        boolean res = true;
        // do dfs to ensure the course is completable
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, preMap, new HashSet<>())) return false;
        }

        return true;
    }

    private boolean dfs(int course, Map<Integer, Set<Integer>> preMap, Set<Integer> visited) {
        // check if we are in a loop
        if (visited.contains(course)) {
            return false;
        }

        // no prereqs return true
        if (!preMap.containsKey(course)) {
            return true;
        }

        visited.add(course);
        for (int c : preMap.get(course)) {
            if (!dfs(c, preMap, visited)) return false;
        }

        // all prereqs are completable mark true by removing prereq from preMap
        preMap.remove(course);
        visited.remove(course);
        return true;

    }
}
