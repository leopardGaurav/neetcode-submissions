

class Twitter {
    private static int timeStamp = 0;

    // Tweet node forming a singly linked list per user
    private class Tweet {
        int id;
        int time;
        Tweet next;

        Tweet(int id) {
            this.id = id;
            this.time = timeStamp++;
            this.next = null;
        }
    }

    // Maps userId -> set of followeeIds
    private Map<Integer, Set<Integer>> followMap;
    // Maps userId -> head of Tweet linked list
    private Map<Integer, Tweet> tweetMap;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    // O(1) Time
    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(tweetId);
        newTweet.next = tweetMap.get(userId);
        tweetMap.put(userId, newTweet);
    }

    // O(F log F + 10 log F) Time where F is number of followees
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        
        // PriorityQueue to pick the most recent tweet among followees
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);

        // Ensure user follows themselves to include own tweets
        Set<Integer> followees = followMap.getOrDefault(userId, new HashSet<>());
        followees.add(userId);

        // Add the head tweet of each followee to the heap
        for (int followeeId : followees) {
            Tweet tweetHead = tweetMap.get(followeeId);
            if (tweetHead != null) {
                maxHeap.offer(tweetHead);
            }
        }

        // Retrieve up to 10 most recent tweets
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            Tweet current = maxHeap.poll();
            result.add(current.id);
            count++;

            // Push next older tweet of the same user if available
            if (current.next != null) {
                maxHeap.offer(current.next);
            }
        }

        return result;
    }

    // O(1) Time
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    // O(1) Time
    public void unfollow(int followerId, int followeeId) {
        // User cannot unfollow themselves
        if (followerId == followeeId) return;

        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}