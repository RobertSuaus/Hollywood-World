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
import Model.Lease;
import Model.RentalOrder;
import View.ReturnsUI;
import java.text.ParseException;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 *
 * @author Robert
 */
public class RentalOrderRequestHandler {
    
    public RentalOrderRequestHandler(/*UI reference*/){
        
        this.rentalOrder = new RentalOrder();
    }
    
    public RentalOrderRequestHandler(ReturnsUI returnsUI){
        
        this.rentalOrder = new RentalOrder();
        this.returnsUI = returnsUI;
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
    public void handleLeaseAggregation(String movieIdInput) throws ParseException{
        
        if(isValidInputNumber (movieIdInput) ){
            int movieId = Integer.valueOf(movieIdInput);
            if(movieExists (movieId) ){
                Movie movie = MovieAdministrator.getMovieInfo(movieId);
                rentalOrder.addLease(generateLease(movie) );
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
    
    public String handleRentalOrderRetrieval(String membershipInput){
        
        if(isValidInputNumber(membershipInput) ){
            int membershipId = Integer.valueOf(membershipInput);
            if(membershipExists(membershipId ) ){
                //si tiene una renta en proceso...
                    rentalOrder = RentalOrderAdministrator.
                            getRentalOrderInfo(membershipId);
                    //Checar si hay importe adicional
                    returnsUI.fillRentalOrderField(rentalOrder);
                //No tiene rentas pendientes    
            } //No existe la membresía
        } //No es un número válido de membresía
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
    
    private Lease generateLease(Movie movie){
        
        Lease lease = new Lease(
            movie.getId(),
            movie.getProfile().getTitle()
        );
        
        Date releaseDate = movie.getProfile().getReleaseDate();
        lease.setPrice(findLeasePrice(releaseDate) );
        
        return lease;
    }
    
    private double findLeasePrice(Date releaseDate){
        
        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime threeMonthsAgo = now.plusDays(-90);

        if (releaseDate.toInstant().isBefore(threeMonthsAgo.toInstant() ) ) {
            return 20; //No estreno
        }else{
            return 30; //Estreno
        }
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
    //referencia a la vista
}
