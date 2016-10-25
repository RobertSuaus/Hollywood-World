package Controller;

import Model.User;

/**
 *
 * @author Robert
 */
public interface ValidateUserInterface {
    
    public boolean isUserNameAvailable(String userName);
    public User getUserInfo(String userName);
    
    public void addUser(User user);
    public void modifyUser(User user);
}
