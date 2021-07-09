package newsfeed.app;

import newsfeed.cache.NewsFeedCache;
import newsfeed.service.NewsFeedService;
import newsfeed.service.impl.NewsFeedServiceImpl;
import newsfeed.service.impl.UserServiceImpl;

import java.util.Scanner;

/**
 * @author ravi.bhatt
 * @version NewsFeedApp: NewsFeedApp.java, v 1.0 19/06/21 10:09 am ravi.bhatt Exp $$
 */
public class NewsFeedApp {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        NewsFeedService newsFeedService = new NewsFeedServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();
        while(scn.hasNext()){
            String input = scn.nextLine();
            String[] inputParams = input.split("~");
            switch (inputParams[0]){
                case "signup":
                    userService.signUp(inputParams[1]);
                    break;
                case "login":
                    userService.login(inputParams[1]);
                    break;
                case "post":
                    newsFeedService.createPost("", NewsFeedCache.getCurrentUser().getUserName(),inputParams[1]);
                    break;
                case "follow":
                    userService.follow(NewsFeedCache.getCurrentUser().getUserName(),inputParams[1]);
                    break;
                case "upvote":
                    newsFeedService.upVote(inputParams[1]);
                    break;
                case "downvote":
                    newsFeedService.downVote(inputParams[1]);
                    break;
                case "shownewsfeed":
                    newsFeedService.showNewsFeed(NewsFeedCache.getCurrentUser().getUserName());
                    break;
                case "reply":
                    newsFeedService.replyToPost(inputParams[1],NewsFeedCache.getCurrentUser().getUserName(),inputParams[2]);
                    break;
            }

            // Ravi created a post with id 2.
            // Rakesh reshared this Post 5
            // post id should be available in the rakesh list of posts.
            // Neha reshared post id 4 (post id 2)
            // Ravi should be able to see post id 2 is shared two times.



        }
    }
}
