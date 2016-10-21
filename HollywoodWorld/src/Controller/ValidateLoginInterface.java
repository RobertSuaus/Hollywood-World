package Controller;

/**
 *
 * @author Robert
 */
public interface ValidateLoginInterface {
    
    public void validateUserName(String inUserName);
    public void validatePassword(String inPassword);
    public void handleLoginAction();
}
