package Design.LeetCode;

import java.util.*;

public class _355DesignTwitter {

    private int timeStamp = 0;
    private HashMap<Integer, User> userMap;

    class Tweet {
        public int id;
        public int time;
        public Tweet next;

        public Tweet(int id) {
            this.id = id;
            time = timeStamp++;
            next = null;
        }
    }

    class User {
        public int id;
        public HashSet<Integer> followed;
        public Tweet tweetHead;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id);
            tweetHead = null;
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unFollow(int id) {
            followed.remove(id);
        }

        public void post(int id) {
            Tweet tweet = new Tweet(id);
            tweet.next = tweetHead;
            tweetHead = tweet;
        }
    }



    public _355DesignTwitter() {
        userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User user = new User(userId);
            userMap.put(userId, user);
        }
        userMap.get(userId).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();
        if (!userMap.containsKey(userId)) return res;

        HashSet<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>(users.size(), (a, b) -> (b.time - a.time));
        for (int user : users) {
            Tweet tweet = userMap.get(user).tweetHead;
            if (tweet != null) {
                pq.offer(tweet);
            }
        }
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            Tweet tweet = pq.poll();
            res.add(tweet.id);
            count++;
            if (tweet.next != null) {
                pq.offer(tweet.next);
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User user = new User(followerId);
            userMap.put(followerId, user);
        }
        if (!userMap.containsKey(followeeId)) {
            User user = new User(followeeId);
            userMap.put(followeeId, user);
        }
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followerId == followeeId) {
            return;
        }
        userMap.get(followerId).unFollow(followeeId);
    }
}
