class Twitter {
    private int time = 0;

    private static class Tweet{
        int tweetId;
        int time;
        Tweet(int tweetId, int time){
            this.time = time;
            this.tweetId = tweetId;
        }
    }
    private Map<Integer, List<Tweet>> tweets = new HashMap<>();
    private Map<Integer,Set<Integer>> following = new HashMap<>();
    public Twitter(){

    }
    public void postTweet(int userId, int tweetId) {
        time++;
        Tweet t = new Tweet(tweetId,time);
        tweets.computeIfAbsent(userId,k->new ArrayList<>()).add(t);
        
    }
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        Set<Integer> relevantUsers = new HashSet<>();
        relevantUsers.add(userId);
        if(following.containsKey(userId)) relevantUsers.addAll(following.get(userId));
        
        // here I have one doubt like I am using time stamp but where am I sotring
        //it.
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)-> {
            Tweet t1 = tweets.get(a[0]).get(a[1]);
            Tweet t2 = tweets.get(b[0]).get(b[1]);
            return Integer.compare(t2.time,t1.time);
            }
        );
        for(int user:relevantUsers){
            List<Tweet> userTweet = tweets.get(user);
            if(userTweet!=null && !userTweet.isEmpty()){
                int newestIndx= userTweet.size()-1;
                maxHeap.offer(new int[]{user,newestIndx});
            }
        }
        while(!maxHeap.isEmpty() && feed.size()<10){
            int[] candidate = maxHeap.poll();
            int user = candidate[0];
            int indx = candidate[1];
            Tweet tweet = tweets.get(user).get(indx);
            feed.add(tweet.tweetId);
            int nextIndx= indx-1;
            if(nextIndx>=0)maxHeap.offer(new int[]{user,nextIndx});
        }
        return feed;    
    }
    
    public void follow(int followerId, int followeeId) {
        // if(following.containsKey(followerId)) following.get(followerId).add(followeeId);
        following.computeIfAbsent(followerId,k->new HashSet<>()).add(followeeId);
        
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(following.containsKey(followerId))following.get(followerId).remove(followeeId);
        
    }
}
