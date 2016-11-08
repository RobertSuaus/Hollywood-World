package Controller;

import Model.Movie;
import Model.MovieDAO;
import Model.MovieProfile;
import Model.StatusValidator;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author Robert
 */
public class MovieAdministrator {
    
    public static String addMoviesToInventory(Movie movie, int amount){
        
        if(isMovieIdAvailable(movie.getId() ) ){
            if(StatusValidator.success(MovieDAO.save(movie, amount) ) ){
                return "Movies added to inventory";
            }else{
                return "Couldn't add movies";
            }
        }else{
            return "Movie id not available";
        }
    }
    
    public static String registerMovieProfile(MovieProfile movieProfile){
        
        if(isSerialCodeAvailable(movieProfile.getSerialCode() ) ){
           if(StatusValidator.success(MovieDAO.save(movieProfile) ) ){
                return "New profile registered";
            }else{
                return "Couldn't add profile";
            } 
        }else{
            return "Serial code not available";
        }
    }
    
    public static String modifyMovieProfile(MovieProfile movieProfile){
        
        if(StatusValidator.success(MovieDAO.update(movieProfile) ) ){
            return "Profile succesfully edited";
        }else{
            return "Couldn't update profile";
        }
    }
    
    public static Movie getMovieInfo(int movieId){
        
        Movie movieInfo = MovieDAO.getRegistry(movieId);
        return movieInfo;
    }
    
    public static MovieProfile getMovieProfileInfo(String serialCode){
        
        MovieProfile profileInfo= null;
        try {
            profileInfo = MovieDAO.getRegistry(serialCode);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Error al convertir la fecha");
        }
        return profileInfo;
    }
    
    public static int generateNextMovieId(){
        
        int lastRegisteredId;
        lastRegisteredId = MovieDAO.getLastRegistryIndex();
        int nextId= lastRegisteredId + 1; //Recorrer una posición
        return nextId;
    }
    
    private static boolean isMovieIdAvailable(int movieId){
        
        boolean isAvailable;
        if(MovieDAO.registryExists(movieId) ){
            isAvailable = false;
        }else{
            isAvailable = true;
        }
        return isAvailable;
    }
    
    private static boolean isSerialCodeAvailable(String serialCode){
        
        boolean isAvailable;
        if(MovieDAO.registryExists(serialCode) ){
            isAvailable = false;
        }else{
            isAvailable = true;
        }
        return isAvailable;
    }
}