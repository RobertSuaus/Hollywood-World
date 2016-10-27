package Controller;

import Model.User;
import View.MainMenuUI;
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
    public boolean userHasAdminPermissions(){
        
        String userPermissions = user.getPermissions();
        
        if(userPermissions.equals("Admin")){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public boolean userHasHumanResourcesPermissions(){
        
        String userPermissions = user.getPermissions();
        
        if(userPermissions.equals("Human Resources")){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public boolean userHasManagerPermissions(){
        
        String userPermissions = user.getPermissions();
        
        if(userPermissions.equals("Manager")){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public boolean userHasRenterPermissions(){
        
        String userPermissions = user.getPermissions();
        
        if(userPermissions.equals("Renter")){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public void openWindow(String windowName){
        switch(windowName){
            case "User Manager" : new UserController();
                break;
            case "Client Manager" : new ClientController();
                break;
            default : ;
        }
    }
    
    private User user;
    private MainMenuUI mainMenuUI;
}
