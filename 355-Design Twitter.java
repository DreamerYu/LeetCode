class Twitter {
    class user{
        Set<Integer> hasfollow;
        node tweet_head;
        public user(){
            hasfollow = new HashSet<>();
            tweet_head = null;
        }
        
        public void follow(int id){
            hasfollow.add(id);
        }
        
        public void unfollow(int id){
            hasfollow.remove(id);
        }
        
        public void post(int id){
            node t = new node(id);
            t.next=tweet_head;
            tweet_head=t;
        }
    }
    
    private static int timeStamp=0;
    class node{
        int tweetid;
        int time;
        node next;
        public node(int t){
            tweetid = t;
            time = timeStamp++;
            next = null;
        }
        
    }
    
    HashMap<Integer, user> map;
    
    /** Initialize your data structure here. */
    public Twitter() {
        map = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!map.containsKey(userId)){
            user u = new user();
            map.put(userId, u);
        }
        map.get(userId).post(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if(!map.containsKey(userId)){
            return res;
        }
        PriorityQueue<node> queue = new PriorityQueue<node>(map.get(userId).hasfollow.size() + 1, (a, b) -> (b.time - a.time));
        if(map.get(userId).tweet_head != null) queue.offer(map.get(userId).tweet_head);
        for(int followeeid : map.get(userId).hasfollow){
            if(followeeid == userId) continue;
            if(map.get(followeeid).tweet_head != null){
                queue.offer(map.get(followeeid).tweet_head);
            }
        }
        int num = 0;
        user u = map.get(userId);
        node head = u.tweet_head;
        while(!queue.isEmpty() && num < 10){
            node temp = queue.poll();
            num++;
            res.add(temp.tweetid);
            if(temp.next != null){
                queue.offer(temp.next);
            }
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!map.containsKey(followerId)){
            user u = new user();
            map.put(followerId, u);
        }
        if(!map.containsKey(followeeId)){
            user u = new user();
            map.put(followeeId, u);
        }
        map.get(followerId).follow(followeeId);
        
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!map.containsKey(followerId) || !map.containsKey(followeeId)){
            return;
        }
        map.get(followerId).unfollow(followeeId);
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