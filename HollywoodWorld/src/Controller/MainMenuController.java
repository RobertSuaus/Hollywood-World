package Controller;

import Model.User;
import Model.UserPermissions;

/**
 *
 * @author Robert
 */
public class MainMenuController implements ValidateMainMenuInterface {
    /*Clase encargada de la funcionalidad del menú principal.
    Verifica que el empleado usando el sistema tenga acceso a las secciones
    correspondientes.*/
    
    public MainMenuController(User user){
        this.user = user;
        mainMenuUI = new MainMenuUI(this);
    }
    
    @Override
    public boolean userHasAdminPermissions(){
        
        int userPermissions = getCurrentUserPermissions();
        int adminPermissions = UserPermissions.
                administrator.getValue();
        
        return userPermissions <= adminPermissions;
    }
    
    @Override
    public boolean userHasHumanResourcesPermissions(){
        
        int userPermissions = getCurrentUserPermissions();
        int humanResPermissions = UserPermissions
                .humanResources.getValue();
        
        return userPermissions <= humanResPermissions;
    }
    
    @Override
    public boolean userHasManagerPermissions(){
        
        int userPermissions = getCurrentUserPermissions();
        int managerPermissions = UserPermissions.
                manager.getValue();
        
        return userPermissions <= managerPermissions;
    }
    
    @Override
    public boolean userHasRenterPermissions(){
        
        int userPermissions = getCurrentUserPermissions();
        int renterPermissions = UserPermissions.
                renter.getValue();
        
        return userPermissions <= renterPermissions;
    }
    
    private int getCurrentUserPermissions(){
        return user.getPermissions().getValue();
    }
    
    private User user;
    private MainMenuUI mainMenuUI;
}
