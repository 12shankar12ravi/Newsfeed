package newsfeed.cache;

import newsfeed.models.FeedItem;
import newsfeed.models.User;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ravi.bhatt
 * @version NewsFeedCache: NewsFeedCache.java, v 1.0 19/06/21 10:49 am ravi.bhatt Exp $$
 */
public class NewsFeedCache {
    /**
     *  {Key = feedId (001 , ....00n)} and {value = FeedItem object}
     */
    private static ConcurrentNavigableMap<String, FeedItem> feedItemMap  = new ConcurrentSkipListMap<String, FeedItem>();

    /**
     * List of all the users saved in this list
     */
    private static ConcurrentMap<String,User> userMap = new ConcurrentHashMap<String, User>();

    private static User currentUser ;

    private static AtomicInteger currentPostId = new AtomicInteger(0);

    public static AtomicInteger getCurrentPostId(){
        return currentPostId;
    }

    public static void addFeedItem(FeedItem feedItem){
        feedItemMap.put(feedItem.getFeedItemId(),feedItem);
    }

    public static void setCurrentUser(User user){
        currentUser = user;
    }

    public static void addUser(User user){
        currentUser = user;
        userMap.put(user.getUserName(),user);
    }

    public static User getUser(String userName){
        return userMap.get(userName);
    }

    public static FeedItem getFeedItem(String feedId){
        return feedItemMap.get(feedId);
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static ConcurrentNavigableMap<String, FeedItem> getFeedItemMap() {
        return feedItemMap;
    }
}
