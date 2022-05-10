class Twitter {
    class Tweet {
        int userId;
        int tweetId;
        
        Tweet(int userId, int tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;
        }
    }
    // Better subsitute to list
    Map<Integer, List<Integer>> userFollowers;
    List<Tweet> tweets;

    public Twitter() {
        userFollowers = new HashMap<>();
        tweets = new ArrayList<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        // O(n)
        if(!userFollowers.containsKey(userId)) {
            // List<Integer> firstFollower = new ArrayList<>();
            // firstFollower.add(followerId);
            // userFollowers.put(followerId, firstFollower);
            initialiseUser(userId);
        }
        Tweet tweet = new Tweet(userId, tweetId);
        tweets.add(tweet);
        return;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        // O(mn)
        List<Integer> followers = userFollowers.get(userId);
        // System.out.println("followers size " + userFollowers.size());
        List<Integer> feedTweets = new ArrayList<>();
        int ptr = tweets.size() - 1;
        Tweet t;
        while(ptr > -1 && feedTweets.size() < 10) {
            t = tweets.get(ptr);
            if(followers.contains(t.userId)) {
                feedTweets.add(t.tweetId);
            }
            ptr--;
        }
        return feedTweets;
    }
    
    public void follow(int followerId, int followeeId) {
        // O(n)
        if(!userFollowers.containsKey(followerId)) {
            // List<Integer> firstFollower = new ArrayList<>();
            // firstFollower.add(followerId);
            // userFollowers.put(followerId, firstFollower);
            initialiseUser(followerId);
        }
        List<Integer> currentFollowers = userFollowers.get(followerId);
        if(!currentFollowers.contains(followeeId)) {
            currentFollowers.add(followeeId);
            userFollowers.put(followerId, currentFollowers);
        }
        return;
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        // O(n)
        if(!userFollowers.containsKey(followerId)) {
            return;
        }
        List<Integer> currentFollowers = userFollowers.get(followerId);
        if(currentFollowers.contains(followeeId)) {
            int followerIdxToRemove = currentFollowers.indexOf(followeeId);
            currentFollowers.remove(followerIdxToRemove);
            userFollowers.put(followerId, currentFollowers);
        }
        return;
        
    }
    
    private void initialiseUser(int userId) {
        List<Integer> firstFollower = new ArrayList<>();
        firstFollower.add(userId);
        userFollowers.put(userId, firstFollower);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */


/*

followers
userId -> followers
Integer -> List<Integer>

Tweet -> userId, tweetId
(1, 101)
(2, 102)
(3, 103)

List<Tweet> ls

postTweet() {
    tweet = new Tweet(userId, tweetId)
    ls.add(tweet);
}

getNewsFeed(userId) -->
 followers = followers.get(userId)
 int cnt = 0;
 tweetsArray = [];
 int ptr = ls.size() - 1;
 
 while(tweetsArray.size() < 10 && ptr > -1) {
    t = ls.get(ptr);
    if(followers.contains(t.userId)) {
        tweetsArray.add(t)
    }
 }
 return tweetsArray;
*/