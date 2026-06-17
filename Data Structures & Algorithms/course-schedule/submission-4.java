class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Course> courseMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            courseMap.put(i, new Course(i));
        }

        for (int[] pr : prerequisites) {
            Course c = courseMap.get(pr[0]);
            Course req = courseMap.get(pr[1]);
            c.preReqs.add(req);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(courseMap.get(i), new HashSet<>())) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(Course c, Set<Course> visited) {
        
        // check that we aren't looping
        if (visited.contains(c)){
            c.completable = false;
            return false;
        }
        // already calculated this course's completability
        if (c.completable != null) return c.completable;
        if (c.preReqs.size() == 0) {
            c.completable = true;
            return true;
        }

        visited.add(c);
        boolean res = true;
        for (Course req : c.preReqs) {
            res &= dfs(req, visited);
            if (!res) break;
        }
        visited.remove(c);
        c.completable = res;
        return res;
    }
}

class Course {
    int courseId;
    Set<Course> preReqs;
    Boolean completable;
    public Course(int courseId) {
        this.preReqs = new HashSet<>();
        this.completable = null;
    }
}
