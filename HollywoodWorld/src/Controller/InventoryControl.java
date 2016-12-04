/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Movie;
import Model.MovieDAO;
import Model.MovieProfile;
import View.RegisterMovieProfileForm;
import View.RegisterMovieForm;
import View.ModifyMovieProfileForm;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author che_i
 */
public class InventoryControl {
    
    public InventoryControl(RegisterMovieProfileForm registerMovieProfileForm){
        
        this.registerMovieProfileForm = registerMovieProfileForm;
        this.movieProfile = new MovieProfile();
    }
    
    public InventoryControl(RegisterMovieForm registerMovieForm){
        
        this.registerMovieForm = registerMovieForm;
        this.movie = new Movie(generateNextMovieId());
        fillMovieIdField();
    }
    
    public InventoryControl(ModifyMovieProfileForm modifyMovieForm){
        
        this.modifyMovieProfileForm = modifyMovieForm;
        this.movieProfile = new MovieProfile();
    }
    
    public void modifyMovieAmount(String input) {
        
        if( isValidInputNumber(input) ) {
            int amount = Integer.parseInt(input);
            int lowerBound = movie.getId();
            int upperBound = lowerBound + amount;
            
            registerMovieForm.fillMovieUpperIdField(upperBound);
        }
    }
    
    public String addToInventory(String[] userInputs) throws ParseException{
        
        String serialCode = userInputs[0];
        if ( isExistSerialCode(serialCode) ){
            movie.setProfile(
                        getMovieProfileInfo(serialCode)
                        );
            int addAmount = Integer.valueOf( userInputs[1] );
            registerMovieForm.dispose();
           return InventoryManager.addMoviesToInventory(movie, addAmount);
        }
        return SERIAL_CODE_UNEXIST_MSG;
    }
     
    public String modifyProfile(String[] userInputs) throws ParseException{
        
        setMovieProfileInformation( userInputs );
        if ( isEveryInputValid() ) {
            return InventoryManager.modifyMovieProfile(movieProfile);
        }
        return INVALID_DATA_MSG;
    }
    
    public String registerProfile(String[] userInputs) throws ParseException {
         
        setMovieProfileInformation( userInputs );
        if ( isEveryInputValid() ) {
            if( isSerialCodeAvailable(movieProfile.getSerialCode()) ){
                return InventoryManager.registerMovieProfile(movieProfile);
            }
            return SERIAL_CODE_OCUPIED_MSG;
        }
        return INVALID_DATA_MSG;
    }
    
    public String retrieveInformation(String serialCode){
        
        if( isExistSerialCode(serialCode) ){
            movieProfile = InventoryManager.getMovieProfileInfo(serialCode);
            modifyMovieProfileForm.fillExistingProfileForm(movieProfile);
            return "Mostrando información de: "+ movieProfile.getTitle();
        }
        return INVALID_SERIAL_CODE_MSG;
    }
    
    private void fillMovieIdField(){
        
        int nextMovieId =  generateNextMovieId();
        registerMovieForm.fillMovieLowerIdField(nextMovieId);
    }
    
    private void setMovieProfileInformation(String[] userInputs) throws ParseException{
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date admissionDate = new Date();
        
        movieProfile.setTitle(userInputs[0]);
        admissionDate = dateFormat.parse(userInputs[1]);
        movieProfile.setReleaseDate(admissionDate);
        movieProfile.setRating(userInputs[2]);
        movieProfile.setDescription(userInputs[3]);
        movieProfile.setRunTime(userInputs[4]);
        movieProfile.setSerialCode(userInputs[5]);
    }
    
    private MovieProfile getMovieProfileInfo(String serialCode){
        
        MovieProfile profileInfo= null;
        try {
            profileInfo = MovieDAO.getRegistry(serialCode);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Error al convertir la fecha");
        }
        return profileInfo;
    }
    
    private int generateNextMovieId(){
        
        int lastRegisteredId;
        lastRegisteredId = MovieDAO.getLastRegistryIndex();
        int nextId= lastRegisteredId + 1; //Recorrer una posición
        return nextId;
    }
    
    private boolean isExistSerialCode(String serialCode) {
        
        boolean isExist;
        if( MovieDAO.registryExists(serialCode) ) {
            isExist = true;
        } else {
            isExist = false;
        }
        return isExist;
    }
    
    private boolean isSerialCodeAvailable(String serialCode){
        
        boolean isAvailable;
        if(MovieDAO.registryExists(serialCode)) {
            isAvailable = false;
        } else {
            isAvailable = true;
        }
        return isAvailable;
    }
    
    private boolean isMovieIdAvailable(int movieId){
        
        boolean isAvailable;
        if(MovieDAO.registryExists(movieId) ){
            isAvailable = false;
        }else{
            isAvailable = true;
        }
        return isAvailable;
    }
    
    private boolean isEveryInputValid(){
        
        if(isValidInputText( movieProfile.getTitle() )&& 
            isValidInputDate( movieProfile.getReleaseDate() )&&
            isValidInputRating( movieProfile.getRating())&&
            isValidInputText( movieProfile.getDescription() ) &&
            isValidInputText( movieProfile.getRunTime() )&&
            isValidInputSerialCode( movieProfile.getSerialCode() )
        ){
            return true;
        }
        else{
            return false;
        }
    }
    
    private boolean isValidInputText(String input){
        
        if (input.matches("([A-Za-z]|\\s)*") 
            && input.equals(" ") == false 
            && input.equals("") == false){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean isValidInputSerialCode(String input){
        
        if (input.matches("([A-Za-z]|[0-9]|-)*") 
            && input.equals(" ") == false 
            && input.equals("") == false){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean isValidInputRating(String input){
        
        if (input.matches("([A-Z]|[0-9])*") 
            && input.equals(" ") == false 
            && input.equals("") == false){
            return true;
        }else{
            return false;
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
    
    private boolean isValidInputDate(Date date){
        
        if (date!=null){
            return true;
        }else{
            return false;
        }
    }
    
    private Movie movie;
    private MovieProfile movieProfile;
    private RegisterMovieForm registerMovieForm;
    private RegisterMovieProfileForm registerMovieProfileForm;
    private ModifyMovieProfileForm modifyMovieProfileForm;
    private final String INVALID_DATA_MSG = "Los datos ingresados no son validos";
    private final String INVALID_SERIAL_CODE_MSG = "El código de serie es inválido!";
    private final String SERIAL_CODE_OCUPIED_MSG = "El código de serie no está disponible";
    private final String SERIAL_CODE_UNEXIST_MSG = "El código de serie no existe";
}
