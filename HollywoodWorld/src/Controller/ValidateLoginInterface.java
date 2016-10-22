package Controller;

import Model.User;

/**
 *
 * @author Robert
 */
public interface ValidateLoginInterface {
    
    public void validateUserName(String inUserName);
    public void validatePassword(String inPassword);
    public boolean authenticateUser();
    public void initiateSession();
}
