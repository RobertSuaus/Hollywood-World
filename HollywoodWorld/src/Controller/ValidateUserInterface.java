package Controller;

import Model.User;

/**
 *
 * @author Robert
 */
public interface ValidateUserInterface {
    
    public boolean isUserNameAvailable(String userName);
    public User getUserInfo(String userName);
    
    public String addUser(User user);
    public String modifyUser(User user);
}
