package Controller;

import Model.User;

/**
 *
 * @author Robert
 */
public interface ValidateLoginInterface {
    
    public boolean authenticateUser(User user);
    public void initiateSession(User user);
}
