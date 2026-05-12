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
        User u = getUser(userId);
        List<Tweet> feed = new ArrayList<>(u.feed);
        for (User followee : u.following) {
            feed.addAll(followee.feed);
        }
        feed.sort((a, b) -> Integer.compare(b.time, a.time));
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < Math.min(10, feed.size()); i++) {
            res.add(feed.get(i).id);
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
