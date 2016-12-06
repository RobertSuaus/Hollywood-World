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
    
    public void handleProfitReportRequest(){
        
        if(userHasFinancesPermissions() ){
            MainMenuAdministrator.accessProfitReportWindow(user);
        }else{
            mainMenu.displayPermissionError();
        }
    }
    
    public void handlePerformanceReportRequest(){
        
        if(userHasFinancesPermissions() ){
            MainMenuAdministrator.accessPerformanceReportWindow(user);
        }else{
            mainMenu.displayPermissionError();
        }
    }
    
    public void handleTendencyReportRequest(){
        
        if(userHasFinancesPermissions() ){
            MainMenuAdministrator.accessTendencyReportWindow(user);
        }else{
            mainMenu.displayPermissionError();
        }
    }
    
    public void handlePayrollSummaryRequest(){
        
        if(userHasAccountingPermissions() ){
            MainMenuAdministrator.accessPayrollSummaryWindow();
        }else{
            mainMenu.displayPermissionError();
        }
    }
    
    public void handlePayrollBreakdownRequest(){
        
        if(userHasAccountingPermissions() ){
            MainMenuAdministrator.accessPayrollBreakdownWindow();
        }else{
            mainMenu.displayPermissionError();
        }
    }
    
    public void handlePayrollKardexRequest(){
        
        if(userHasAccountingPermissions() ){
            MainMenuAdministrator.accessPayrollKardexWindow();
        }else{
            mainMenu.displayPermissionError();
        }
    }
    
    private boolean userHasAdminPermissions(){
        
        String userPermissions = user.getPermissions();
        
        if(userPermissions.equals("Administrador")){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean userHasHumanResourcesPermissions(){
        
        String userPermissions = user.getPermissions();
        
        if(userPermissions.equals("Recursos humanos")){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean userHasManagerPermissions(){
        
        String userPermissions = user.getPermissions();
        
        if(userPermissions.equals("Gerente")){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean userHasRenterPermissions(){
        
        String userPermissions = user.getPermissions();
        
        if(userPermissions.equals("Rentador")){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean userHasFinancesPermissions(){
        
        String userPermissions = user.getPermissions();
        
        if(userPermissions.equals("Finanzas")){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean userHasAccountingPermissions(){
        
        String userPermissions = user.getPermissions();
        
        if(userPermissions.equals("Contaduría")){
            return true;
        }else{
            return false;
        }
    }
    
    
    
    private User user;
    private MainMenuUI mainMenu;
}
