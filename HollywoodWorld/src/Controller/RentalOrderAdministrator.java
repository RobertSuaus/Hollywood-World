/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.RentalOrder;
import Model.StatusValidator;

/**
 *
 * @author Robert
 */
public class RentalOrderAdministrator {
    
    public static RentalOrder getRentalOrderInfo(int membershipId){
        
        RentalOrder clientInformation = RentalOrderDAO.getRegistry(membershipId);
        return clientInformation;
    }
    
    public static String archieveRentOrder(RentalOrder rentalOrder){
        
        if(StatusValidator.success(RentalOrderDAO.save(rentalOrder) ) ){
                return "Se ha almacenado la orden de renta con éxito";
            }else{
                return "No se puso almacenar la orden de renta";
            }
        
    }
}
