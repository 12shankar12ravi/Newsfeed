package newsfeed.models;

/**
 * @author ravi.bhatt
 * @version UserFollow: UserFollow.java, v 1.0 19/06/21 10:21 am ravi.bhatt Exp $$
 */
public class UserFollow {
    private String userName;
    private String followedUserName;

    public UserFollow(String userName, String followedUserName) {
        this.userName = userName;
        this.followedUserName = followedUserName;
    }

    public String getUserName() {
        return userName;
    }

    public String getFollowedUserName() {
        return followedUserName;
    }
}
