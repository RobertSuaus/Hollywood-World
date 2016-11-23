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
        
        if(userHasHumanResourcesPermissions() ){
            MainMenuAdministrator.accessEmployeeRegistrationWindow();
        }else{
            mainMenu.displayPermissionError();
        }
    }
    
    public void handleEmployeeModificationRequest(){
        
        if(userHasHumanResourcesPermissions() ){
            MainMenuAdministrator.accessEmployeeModificationWindow();
        }else{
            mainMenu.displayPermissionError();
        }
        
    }
    
    public void handleMovieInventoryRequest(){
        
        if(userHasManagerPermissions()){
            MainMenuAdministrator.accessMovieInventoryWindow();
        }else{
            mainMenu.displayPermissionError();
        }
        
    }
    
    public void handleNewProfileRequest(){
        
        if(userHasManagerPermissions()){
            MainMenuAdministrator.accessNewProfileWindow();
        }else{
            mainMenu.displayPermissionError();
        }
        
    }
    
    public void handleProfileModificationRequest(){
        
        if(userHasManagerPermissions()){
            MainMenuAdministrator.accessProfileModificationWindow() ;
        }else{
            mainMenu.displayPermissionError();
        }
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
}
