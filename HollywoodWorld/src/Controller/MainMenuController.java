package Controller;

import Model.User;
import View.MainMenuUI;

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
        
        String userPermissions = user.getPermissions();
        
        if(userPermissions.equals("ADMIN")){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public boolean userHasHumanResourcesPermissions(){
        
        String userPermissions = user.getPermissions();
        
        if(userPermissions.equals("HUMAN_RESOURCES")){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public boolean userHasManagerPermissions(){
        
        String userPermissions = user.getPermissions();
        
        if(userPermissions.equals("MANAGER")){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public boolean userHasRenterPermissions(){
        
        String userPermissions = user.getPermissions();
        
        if(userPermissions.equals("RENTER")){
            return true;
        }else{
            return false;
        }
    }
    
    private User user;
    private MainMenuUI mainMenuUI;
}
