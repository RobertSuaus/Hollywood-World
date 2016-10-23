package Controller;

/**
 *
 * @author Robert
 */
public interface ValidateLoginInterface {
    
    public boolean isUserNameValid(String userName);
    public boolean isPasswordValid(String password);
    
    public void assignUserName(String userName);
    public void assignPassword(String password);
    
    public boolean authenticateUser();
    public void initiateSession();
}
