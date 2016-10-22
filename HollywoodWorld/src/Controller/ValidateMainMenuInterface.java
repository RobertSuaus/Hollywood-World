package Controller;

/**
 *
 * @author Robert
 */
public interface ValidateMainMenuInterface {
    
    public boolean verifyAdminPermission();
    public boolean verifyHumanResourcesPermission();
    public boolean verifyManagerPermission();
    public boolean verifyRenterPermission();
    
    public void launchFunction(String functionName);
}
