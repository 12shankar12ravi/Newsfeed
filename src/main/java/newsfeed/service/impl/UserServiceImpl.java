package newsfeed.service.impl;

import newsfeed.cache.NewsFeedCache;
import newsfeed.enums.UserSignUpStatus;
import newsfeed.models.User;
import newsfeed.models.UserFollow;
import newsfeed.service.UserService;

/**
 * @author ravi.bhatt
 * @version UserServiceImpl: UserServiceImpl.java, v 1.0 19/06/21 10:48 am ravi.bhatt Exp $$
 */
public class UserServiceImpl implements UserService {
    public void signUp(String uName) {
        User user = new User(uName, UserSignUpStatus.SIGNED_UP);
        NewsFeedCache.addUser(user);
    }

    public void login(String uName) {
        User user = NewsFeedCache.getUser(uName);
        if(user == null){
            System.out.println("User is not signed up yet");
        }else{
            NewsFeedCache.setCurrentUser(user);
            System.out.println(user.getUserName() + " has logged in!");
        }
    }

    public void follow(String uName, String followUserName) {
        User user = NewsFeedCache.getUser(uName);
        User followUser = NewsFeedCache.getUser(followUserName);
        if(user == null){
            System.out.println("User has not signed up yet : "+uName);
            return;
        }
        if(followUser == null){
            System.out.println("User to be followed has not signed up yet : "+followUserName);
            return;
        }

        user.getUserFollowList().add(new UserFollow(uName,followUserName));
    }
}
