class Twitter {
    Map<Integer, User> userBase;
    int time;
    public Twitter() {
        time = 0;
        userBase = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        User u = getUser(userId);
        Tweet t = new Tweet(time, tweetId);
        time++;
        u.feed.add(t);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<FeedEntry> maxHeap = new PriorityQueue<>(
            (a, b) -> 
            Integer.compare(b.time, a.time)
        );
        User u = userBase.get(userId);
        if (u.feed.size() > 0) maxHeap.add(new FeedEntry(u));

        // get followees
        Set<User> followees = u.following;

        if (followees.size() > 10) {
            PriorityQueue<FeedEntry> feedCandidates = new PriorityQueue<>(
                (a, b) ->
                Integer.compare(a.time, b.time)
            );
            for (User followee: followees) {
                if (followee.feed.size() <= 0) continue;
                feedCandidates.offer(new FeedEntry(followee));

                if (feedCandidates.size() > 10) {
                    feedCandidates.poll();
                }
            }
        } else {
            // 10 or less followees
            for (User followee : followees) {
                if (followee.feed.size() > 0) {
                    FeedEntry fe = new FeedEntry(followee);
                    maxHeap.add(fe);
                }
            }
        }

        // get 10 most recent tweets
        while (res.size() < 10 && !maxHeap.isEmpty()) {
            FeedEntry next = maxHeap.poll();
            res.add(next.tweet.id);
            if (next.next() == null) continue;
            maxHeap.add(next);
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        User follower = getUser(followerId);
        User followee = getUser(followeeId);

        follower.following.add(followee);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        User follower = getUser(followerId);
        User followee = getUser(followeeId);

        follower.following.remove(followee);
    }

    private User getUser(int userId) {
        User u = userBase.computeIfAbsent(
            userId, 
            k ->  new User()
        );
        return u;
    }
}

class FeedEntry {
    int time;
    User user;
    Tweet tweet;
    int index;

    public FeedEntry(User user) {
        this.user = user;
        this.index = user.feed.size() - 1;
        this.tweet = user.feed.get(index);
        this.time = tweet.time;
    }

    public FeedEntry next() {
        if (index == 0) return null;
        this.index--;
        this.tweet = user.feed.get(index);
        this.time = tweet.time;
        return this;
    }
}

class User {
    HashSet<User> following;
    List<Tweet> feed;

    public User() {
        following = new HashSet<>();
        feed = new ArrayList<>();
    }
}

class Tweet {
    int time;
    int id;

    public Tweet(int time, int id) {
        this.time = time;
        this.id = id;
    }
}
