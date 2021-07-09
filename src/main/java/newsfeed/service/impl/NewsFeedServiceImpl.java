package newsfeed.service.impl;

import newsfeed.cache.NewsFeedCache;
import newsfeed.models.FeedItem;
import newsfeed.service.NewsFeedService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ravi.bhatt
 * @version NewsFeedImplServiceImpl: NewsFeedServiceImpl.java, v 1.0 19/06/21 10:38 am ravi.bhatt Exp $$
 */
public class NewsFeedServiceImpl implements NewsFeedService {
    public void createPost(String postId, String uName, String content) {
        AtomicInteger cPostId = NewsFeedCache.getCurrentPostId();
        int id = cPostId.addAndGet(1);
        String createdTime = LocalDateTime.now().toString();
        FeedItem feedItem = new FeedItem(id+"",uName,content,createdTime);
        NewsFeedCache.addFeedItem(feedItem);
    }

    public void replyToPost(String postId, String uName, String content) {
        String createdTime = LocalDateTime.now().toString();
        FeedItem replyFeedItem = new FeedItem(postId,uName,content,createdTime);
        NewsFeedCache.getFeedItem(postId).addComment(replyFeedItem);
    }

    public void upVote(String postId) {
        FeedItem feedItem = NewsFeedCache.getFeedItem(postId);
        feedItem.setNoOfUpVotes(feedItem.getNoOfUpVotes()+1);
    }

    public void downVote(String postId) {
        FeedItem feedItem = NewsFeedCache.getFeedItem(postId);
        feedItem.setNoOfDownVotes(feedItem.getNoOfDownVotes()+1);
    }

    public void showNewsFeed(String uName) {
        Collection<FeedItem> feedItemList = NewsFeedCache.getFeedItemMap().values();
        feedItemList.stream().filter(feedItem -> feedItem.getUserName().equals(uName)).
                forEach(feedItem -> {
                    System.out.println(feedItem);
                    feedItem.getComments().forEach(comment -> System.out.println(comment));
                });
    }
}
