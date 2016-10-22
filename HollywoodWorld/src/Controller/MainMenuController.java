package Controller;

import Model.User;
import Model.UserPermissions;
import javax.swing.JOptionPane;

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
    public boolean verifyAdminPermission(){
        int userPermission = user.getUserPermissions().
                getPermissionLevel();
        int adminPermission = UserPermissions.administrator.
                getPermissionLevel();
        
        return userPermission <= adminPermission;
    }
    
    @Override
    public boolean verifyHumanResourcesPermission(){
        
    }
    
    @Override
    public boolean verifyManagerPermission(){
        
    }
    
    @Override
    public boolean verifyRenterPermission(){
        
    }
    
    private User user;
    private MainMenuUI mainMenuUI;
}
