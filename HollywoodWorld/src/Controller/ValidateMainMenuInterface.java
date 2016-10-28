package Controller;

/**
 *
 * @author Robert
 */
public interface ValidateMainMenuInterface {
    
    public boolean userHasAdminPermissions();
    public boolean userHasHumanResourcesPermissions();
    public boolean userHasManagerPermissions();
    public boolean userHasRenterPermissions();
    
    public void openWindow(String windowName);
    public void terminateSession();
}
