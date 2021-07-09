package newsfeed.service;

/**
 * @author ravi.bhatt
 * @version UserService: UserService.java, v 1.0 19/06/21 10:32 am ravi.bhatt Exp $$
 *
 * This service is user to serve the signup , login and follow activities
 */
public interface UserService {

    /**
     * Sign Up functionality for a user
     * @param uName
     */
    void signUp(String uName);


    /**
     * Login functionality for a user
     * @param uName
     */
    void login(String uName);


    /**
     * A user can follow another user ,
     * @param uName
     * @param followUserName
     */
    void follow(String uName , String followUserName);
}
