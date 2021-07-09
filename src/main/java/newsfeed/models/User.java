package newsfeed.models;

import newsfeed.enums.UserSignUpStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ravi.bhatt
 * @version User: User.java, v 1.0 19/06/21 10:19 am ravi.bhatt Exp $$
 */
public class User {
    private String userName;
    private List<UserFollow> userFollowList;
    /**
     * @see UserSignUpStatus enum for storing the user signed up status
     */
    private UserSignUpStatus userStatus;

    public User(String userName, UserSignUpStatus userStatus) {
        this.userName = userName;
        this.userStatus = userStatus;
        userFollowList = new ArrayList<UserFollow>();
    }

    public String getUserName() {
        return userName;
    }

    public List<UserFollow> getUserFollowList() {
        return userFollowList;
    }

    public UserSignUpStatus getUserStatus() {
        return userStatus;
    }
}
