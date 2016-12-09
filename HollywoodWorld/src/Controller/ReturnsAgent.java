/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ClientDAO;
import Model.RentalOrder;
import View.RentalReturnForm;
import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Robert
 */
public class ReturnsAgent {
    /*Realiza las devoluciones de los productos. Se encarga de verificar las
    fechas y cobrar multas en caso de ser necesario.*/
    
    public ReturnsAgent(RentalReturnForm returnsForm){
        
        this.rentalOrder = new RentalOrder();
        this.returnForm = returnsForm;
    }
    
    public String requestOrderStatus(String membershipInput) throws ParseException{
        
        if(isValidInputNumber(membershipInput) ){
            int membershipId = Integer.valueOf(membershipInput);
            if(membershipExists(membershipId ) ){
                
                rentalOrder = RenterManager.getRentalOrderStatus(membershipId);
                rentalOrder.setAdditionalCost(calculateAdditionalCost() );
                
                returnForm.fillRentalOrderField(rentalOrder);
                return "Obtenida información de la renta exitosamente";  
            }
            return "No existe la membresía ingresada";
        }
        return "Por favor, ingrese un número válido de membresía";
    }
    
    public String requestRentalOrderFinalization(){
        
        if(rentalOrder.getClientName()!="" ){
            returnForm.dispose();
            return RenterManager.finalizeRentalOrder(rentalOrder.getFolio(), rentalOrder.getAdditionalCost() );
        }
        return "No se ha obtenido la orden de renta aún.";
        
    }
    
    private double calculateAdditionalCost(){
        double additionalCost;
        long daysPast = getDifferenceDays();
        
        if(daysPast>0){
            additionalCost = daysPast * 15; //15 pesos por día
            return additionalCost;
        }else{
            additionalCost = 0;
            return additionalCost;
        }
    }
    
    private long getDifferenceDays() {
        
        Date todayDate = new Date();
        long difference =  todayDate.getTime() - rentalOrder.getReturnDate().getTime();
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
    private RentalReturnForm returnForm;
}
