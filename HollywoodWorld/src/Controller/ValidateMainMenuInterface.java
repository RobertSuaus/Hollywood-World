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
    
}
