package Controller;

import Model.User;
import View.MainMenuUI;

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
    
    public void handleUserRegistrationRequest(){
        
        if(userHasHumanResourcesPermissions() ){
            MainMenuAdministrator.accessUserRegistrationWindow();
        }else{
            mainMenu.displayPermissionError();
        }
    }
    
    public void handleUserModificationRequest(){
        
        if(userHasHumanResourcesPermissions() ){
            MainMenuAdministrator.accessUserModificationWindow();
        }else{
            mainMenu.displayPermissionError();
        }
    }
    
    public void handleClientRegistrationRequest(){
        
        if(userHasRenterPermissions() || userHasManagerPermissions() ){
            MainMenuAdministrator.accessClientRegistrationWindow();
        }else{
            mainMenu.displayPermissionError();
        }
    }
    
    public void handleClientModificationRequest(){
        
        if(userHasRenterPermissions() || userHasManagerPermissions() ){
            MainMenuAdministrator.accessClientModificationWindow();
        }else{
            mainMenu.displayPermissionError();
        }
    }
    
    public void handleEmployeeRegistrationRequest(){
        
    }
    
    public void handleEmployeeModificationRequest(){
        
    }
    
    public void handleMovieInventoryRequest(){
        
    }
    
    public void handleNewProfileRequest(){
        
    }
    
    public void handleProfileModificationRequest(){
        
    }
    
    public void handleNewRentRequest(){
        
        if(userHasRenterPermissions() || userHasManagerPermissions() ){
            MainMenuAdministrator.accessNewRentWindow(user);
        }else{
            mainMenu.displayPermissionError();
        }
    }
    
    public void handleReturnsRequest(){
        
        if(userHasRenterPermissions() || userHasManagerPermissions() ){
            MainMenuAdministrator.accessReturnsWindow();
        }else{
            mainMenu.displayPermissionError();
        }
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
