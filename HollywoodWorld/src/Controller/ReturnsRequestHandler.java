/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ClientDAO;
import Model.RentalOrder;
import View.ReturnsUI;
import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Robert
 */
public class ReturnsRequestHandler {
    
    public ReturnsRequestHandler(ReturnsUI returnsUI){
        
        this.rentalOrder = new RentalOrder();
        this.returnsUI = returnsUI;
    }
    
    public String handleRetrieval(String membershipInput) throws ParseException{
        
        if(isValidInputNumber(membershipInput) ){
            int membershipId = Integer.valueOf(membershipInput);
            if(membershipExists(membershipId ) ){
                
                rentalOrder = RentalOrderAdministrator.
                        getRentalOrderInfo(membershipId);
                //Checar si hay importe adicional
                
                returnsUI.fillRentalOrderField(rentalOrder);
                return "Obtenida información de la renta exitosamente";  
            }
            return "No existe la membresía ingresada";
        }
        return "Por favor, ingrese un número válido de membresía";
    }
    
    public String handleStatusModification(){
        
        returnsUI.dispose();
        return RentalOrderAdministrator.
                modifyRentalOrderStatus(rentalOrder.getFolio() );
    }
    
    private long getDifferenceDays() {
        
        Date todayDate = new Date();
        long difference = rentalOrder.getReturnDate().getTime() - todayDate.getTime();
        return TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
    }
    
    private boolean membershipExists(int membershipId){
        
        boolean exists;
        if(ClientDAO.registryExists(membershipId) ){
            exists = true;
        }else{
            exists = false;
        }
        return exists;
    }
    
    private boolean isValidInputNumber(String input){
        if (input.matches("([0-9]|\\s)*") 
            && input.equals(" ") == false 
            && input.equals("") == false){
            return true;
        }else{
            return false;
        }
    }
    
    private RentalOrder rentalOrder;
    private ReturnsUI returnsUI;
}
