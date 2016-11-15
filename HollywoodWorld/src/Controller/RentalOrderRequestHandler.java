/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Client;
import Model.ClientDAO;
import Model.Movie;
import Model.MovieDAO;
import Model.RentalOrder;

/**
 *
 * @author Robert
 */
public class RentalOrderRequestHandler {
    
    public RentalOrderRequestHandler(/*UI reference*/){
        
        this.rentalOrder = new RentalOrder();
    }
    
    //Maneja el procedimiento para obtener el nombre de cliente de la orden de renta
    public void handleClientNameRetrieval(String membershipIdInput){
        
        if(isValidInputNumber(membershipIdInput) ){
            int membershipId = Integer.valueOf(membershipIdInput);
            if(membershipExists(membershipId) ){
                Client client = ClientAdministrator.getClientInfo(membershipId);
                if(client.getMembership().getStatus() == "Active"){
                    //Llenar el campo en la vista
                }//Cuenta inactiva
            } //Cuenta inexistente
        }//Error de sintaxis
    }
    
    
    //Maneja el procedimiento para agregar un nuevo detalle a la orden de renta
    public void handleRentDetailAggregation(String movieIdInput){
        
        if(isValidInputNumber (movieIdInput) ){
            int movieId = Integer.valueOf(movieIdInput);
            if(movieExists (movieId) ){
                Movie movie = MovieAdministrator.getMovieInfo(movieId);
                /*Crear, de algun modo el detalle de renta a partir de
                 la película obtenida
                "Private createDetail(Movie movie)*/
                rentalOrder.addRentDetail(rentDetail);
                //Actualizar tabla de la vista
                
            }//La película no existe
        }//Error de sintaxis
    }
    
    //Maneja el procedimiento para archivar la orden de renta
    public String handleArchiving(){
        /*Validaciones, el cliente debe haberse asignado, debe haber al menos una
         película en la lista*/
        
        //Llamar al administrador de orden de renta para archivar la orden
    }
    
    /*Maneja el procedimiento para establecer la ventana con los datos
    que se conocen inicialmente de la orden de renta*/
    public void handleWindowInitialization(){
        
        
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
    
    private boolean movieExists(int movieId){
        
        boolean exists;
        if(MovieDAO.registryExists(movieId) ){
            exists = true;
        }else{
            exists = false;
        }
        return exists;
    }
    
    private boolean isFolioAvailable(){
        
        //Verificar si no esta registrado, necesita el DAO de RentOrder
    }
    
    private int generateNextFolio(){
        
        //Necesita el DAO de RentOrder
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
    //referencia a la vista
}
