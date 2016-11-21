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
import Model.RentalOrderDAO;
import View.RentalOrderForm;
import java.text.ParseException;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Robert
 */
public class RentalOrderRequestHandler {
    /*Maneja y le da un sentido a las solicitudes o procedimientos relacionados
    con las ordenes de renta*/
    
    public RentalOrderRequestHandler(RentalOrderForm rentalOrderForm, String userName){
        
        this.rentalOrderForm = rentalOrderForm;
        this.rentalOrder = new RentalOrder(generateNextFolio(), userName );
        setRentalOrderReturnDate(3); //3 días por defecto
        handleWindowInitialization();
    }
    
    //Maneja el procedimiento para asignar los datos de un cliente a la orden de renta
    public String handleClientAssignation(String membershipIdInput){
        
        if(isValidInputNumber(membershipIdInput) ){
            int membershipId = Integer.valueOf(membershipIdInput);
            if(membershipExists(membershipId) ){
                
                Client client = ClientAdministrator.getClientInfo(membershipId);
                if(clientCanRent(client)){
                    
                    rentalOrder.setClientName(
                        client.getName() + " " + client.getLastName() 
                    );
                    rentalOrder.setMembershipId(membershipId);
                        
                    rentalOrderForm.fillClientInfoFields(
                        rentalOrder.getClientName(),
                        String.valueOf(rentalOrder.getMembershipId() )
                    );
                    return "Datos de cliente obtenidos exitosamente";
                }
                return "El cliente tiene una renta pendiente o esta dado de baja";
            } 
            return "No existe esa membresía de cliente";
        }
        return "El número de membresía no es válido";
    }
    
    //Maneja el procedimiento para agregar un nuevo arrendamiento a la orden de renta
    public String handleLeaseAggregation(String movieIdInput) throws ParseException{
        
        if(isValidInputNumber (movieIdInput) ){
            int movieId = Integer.valueOf(movieIdInput);
            if(movieExists (movieId) ){
                
                Movie movie = MovieAdministrator.getMovieInfo(movieId);
                
                rentalOrder.addLease(generateLease(movie) );
                rentalOrder.computeTotal();
                
                rentalOrderForm.fillTotalPriceField(
                    String.valueOf(rentalOrder.getTotalRent() ) 
                );
                rentalOrderForm.fillLeaseTable(rentalOrder.getLeases() );
                
                return "Agregada película a la orden de renta";
            }
            return "El número de película no se encuentra registrado";
        }
        return "Por favor, ingrese un número de película válido";
    }
    
    public void handleLeaseRemoval(int selectedTableIndex){
        
        //-1 es el default del componente JTable si no hay una fila seleccionada
        if(selectedTableIndex != -1){
            
            rentalOrder.removeLease(selectedTableIndex);
            rentalOrder.computeTotal();
            
            rentalOrderForm.fillTotalPriceField(
                    String.valueOf(rentalOrder.getTotalRent() ) 
                );
            rentalOrderForm.fillLeaseTable(rentalOrder.getLeases() );
        }
        
    }
    
    //Maneja el procedimiento para archivar la orden de renta
    public String handleArchiving(){
        
        if(isRentalOrderInfoValid() ){
            if(isFolioAvailable() ){
                
                rentalOrderForm.dispose();
                return RentalOrderAdministrator.archieveRentOrder(rentalOrder);
                
            }
            return "El número de folio está ocupado";
        }
        return "Por favor, llene todos los campos primero";
    }
    
    /*Maneja el procedimiento para establecer la ventana con los datos
    que se conocen inicialmente de la orden de renta*/
    private void handleWindowInitialization(){
        
        rentalOrderForm.fillInitialValuesFields(rentalOrder);
    }
    
    private boolean isRentalOrderInfoValid(){
        
        //Verificar que todos los datos sean correctos
        if( !rentalOrder.getClientName().equals("") &&
            !rentalOrder.getLeases().isEmpty()
        ){
            return true;  
        }else{
            return false;
        }
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
        
        if(RentalOrderDAO.registryExists(rentalOrder.getFolio()) ){
            return false;
        }else{
            return true;
        }
    }
    
    private boolean clientCanRent(Client client){
        
        boolean hasNoPendingRents, isActive;
        
        //Tiene rentas pendientes?
        if(RentalOrderDAO.registryExists(client.getMembership().getId(), "Pendiente")){
            hasNoPendingRents = false;
        }else{
            hasNoPendingRents = true;
        }
        
        //Su membresía está dada de alta?
        if(client.getMembership().getStatus().equals("Active")){
            isActive = true;
        }else{
            isActive = false;
        }
        
        return hasNoPendingRents && isActive;
    }
    
    private int generateNextFolio(){
        
        int lastFolio = RentalOrderDAO.getLastRegistryIndex();
        int nextFolio = lastFolio + 1;
        return nextFolio;
    }
    
    private Lease generateLease(Movie movie){
        Lease lease = new Lease(
            movie.getId(),
            movie.getProfile().getTitle()
        );
        
        Date releaseDate = movie.getProfile().getReleaseDate();
        lease.setPrice(computeLeasePrice(releaseDate) );
        
        return lease;
    }
    
    private void setRentalOrderReturnDate(int rentDays){
        
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, rentDays);
        Date returnDate = calendar.getTime();
        
        rentalOrder.setReturnDate(returnDate);
    }
    
    private double computeLeasePrice(Date releaseDate){
        
        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime threeMonthsAgo = now.plusDays(-90);

        if (releaseDate.toInstant().isBefore(threeMonthsAgo.toInstant() ) ) {
            return 15; //No estreno
        }else{
            return 25; //Estreno
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
    private RentalOrderForm rentalOrderForm;
}
