package Controller;

import Model.User;
import Model.User;
import View.ClientUI;
import View.EmployeeUI;
import View.MainMenuUI;
import View.ModifyUserForm;
import View.MovieUI;
import View.RegisterUserForm;
import javax.swing.JOptionPane;

/**
 *
 * @author Robert
 */
public class MainMenuRequestHandler {
    /*Clase encargada de la funcionalidad del menú principal.
    Verifica que el empleado usando el sistema tenga acceso a las secciones
    correspondientes.*/
    
    public MainMenuRequestHandler(User user, MainMenuUI mainMenu){
        
        this.user = user;
        this.mainMenu = mainMenu;
    }
    
    public void processUserRegistrationWindowRequest(){
        
        if(userHasHumanResourcesPermissions() ){
            MainMenuAdministrator.accessUserRegistrationWindow();
        }else{
            mainMenu.displayPermissionError();
        }
    }
    
    public void processUserModificationWindowRequest(){
        
        if(userHasHumanResourcesPermissions() ){
            MainMenuAdministrator.accessUserModificationWindow();
        }else{
            mainMenu.displayPermissionError();
        }
    }
    
    public void processClientRegistrationWindowRequest(){
        
    }
    
    public void processClientModificationWindowRequest(){
        
    }
    
    public void processEmployeeRegistrationWindowRequest(){
        
    }
    
    public void processEmployeeModificationWindowRequest(){
        
    }
    
    public void processMovieInventoryWindowRequest(){
        
    }
    
    public void processNewProfileWindowRequest(){
        
    }
    
    public void processProfileModificationWindowRequest(){
        
    }
    
    public void processNewRentWindowRequest(){
        
    }
    
    public void processReturnsWindowRequest(){
        
    }
    
    private boolean userHasAdminPermissions(){
        
        String userPermissions = user.getPermissions();
        
        if(userPermissions.equals("Admin")){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean userHasHumanResourcesPermissions(){
        
        String userPermissions = user.getPermissions();
        
        if(userPermissions.equals("Human Resources")){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean userHasManagerPermissions(){
        
        String userPermissions = user.getPermissions();
        
        if(userPermissions.equals("Manager")){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean userHasRenterPermissions(){
        
        String userPermissions = user.getPermissions();
        
        if(userPermissions.equals("Renter")){
            return true;
        }else{
            return false;
        }
    }
    
    private User user;
    private MainMenuUI mainMenu;
    private final String NO_PERMISSION = "No puedes acceder a esta funcionalidad";
}
