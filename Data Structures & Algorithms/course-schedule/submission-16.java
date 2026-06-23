class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // create a map of courses and courses that depend on it
        // we can use BFS and "complete" courses until we no longer can make progress
        // keep track of progress and determine if we can complete all courses (count == numCourses)

        // we can also use DFS and start at every course, go down the path and make sure
        // that each course that a given course depends on, is completable
        // if there is a loop somewhere that means this set of courses can't be completed
        // we reduce extra work by memoizing when we know a certain course is completable
        // this is for the case that two different courses have the same dependency

        // each approach requires a different "orientation"
        // in approach 1 we are following the direction one would take the courses "whats next"
        // and seeing if we can reach the finish line
        // in approach 2 we are following the dependencies of a given course and determining if the
        // dependencies themselves are completable
        // if there are any uncompletable courses the entire set is impossible

        // this is how we know what courses are next for a given course
        List<List<Integer>> next = new ArrayList<>();
        // init 
        for (int i = 0; i < numCourses; i++) {
            next.add(new ArrayList<>());
        }

        // this is how we know how many prereqs are left for a given course
        int[] prereqs = new int[numCourses];

        // go through prerequisites and update our data
        for (int[] pr : prerequisites) {
            prereqs[pr[0]]++;
            next.get(pr[1]).add(pr[0]);
        }

        // init a queue of courses that we can start with (0 prereqs)
        Queue<Integer> completable = new LinkedList<>();
        for (int i = 0; i < prereqs.length; i++) {
            if (prereqs[i] == 0) completable.add(i);
        }

        // bfs 
        int finished = 0;
        // while we have courses that are completable
        while (!completable.isEmpty()) {
            // complete them and increment our finished count and decrement 
            //the prereqs count for its neighbors
            int curr = completable.poll();
            finished++;
            for (int c : next.get(curr)) {
                // if c is now completable add it to the queue
                if (--prereqs[c] == 0) completable.add(c);
            }
        }

        // return whether our finished count matches the number of courses
        return finished == numCourses;
    }
}
