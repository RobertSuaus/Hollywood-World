/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.User;
import View.*;

/**
 *
 * @author Robert
 */
public class MainMenuAdministrator {
    
    public static void accessUserRegistrationWindow(){
        new RegisterUserForm();
    }
    
    public static void accessUserModificationWindow(){
        new ModifyUserForm();
    }
    
    public static void accessClientRegistrationWindow(){
        new RegisterClientForm();
    }
    
    public static void accessClientModificationWindow(){
        new ModifyClientForm();
    }
    
    public static void accessEmployeeRegistrationWindow(){
        new RegisterEmployeeForm();
    }
    
    public static void accessEmployeeModificationWindow(){
        new ModifyEmployeeForm();
    }
    
    public static void accessMovieInventoryWindow(){
        new RegisterMovieForm();
    }
    
    public static void accessNewProfileWindow(){
        new RegisterMovieProfileForm();
    }
    
    public static void accessProfileModificationWindow(){
        new ModifyMovieProfileForm();
    }
    
    public static void accessNewRentWindow(User user){
        new RentalOrderForm(user);
    }
    
    public static void accessReturnsWindow(){
        new RentalReturnForm();
    }
    
    public static void accessProfitReportWindow(User user){
        new ProfitReportForm(user);
    }
    
    public static void accessPerformanceReportWindow(User user){
        new PerformanceReportForm(user);
    }
    
    public static void accessTendencyReportWindow(User user){
        new TendencyReportForm(user);
    }
    
    public static void accessPayrollBreakdownWindow(){
        new GeneratePayrollUI();
    }
    
    public static void accessPayrollKardexWindow(){
        new GenerateKardexUI();
    }
    
    public static void accessPayrollSummaryWindow(){
        new PatreonPayrollForm();
    }
}
