package Controller;

import Model.Movie;
import Model.MovieDAO;
import Model.MovieProfile;
import Model.StatusValidator;
import View.MovieUI;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Robert
 */
public class MovieController implements ValidateMovieInterface {
    
    public MovieController(){
        this.movieDAO = new MovieDAO();
        this.movieUI = new MovieUI(this);
    }
    
    @Override
    public boolean isMovieIdAvailable(int movieId){
        
        boolean isAvailable;
        if(movieDAO.isMovieIdOccupied(movieId) ){
            isAvailable = false;
        }else{
            isAvailable = true;
        }
        return isAvailable;
    }
    
    @Override
    public boolean isSerialCodeAvailable(String serialCode){
        
        boolean isAvailable;
        if(movieDAO.isSerialCodeOccupied(serialCode) ){
            isAvailable = false;
        }else{
            isAvailable = true;
        }
        return isAvailable;
    }
    
    @Override
    public Movie getMovieInfo(int movieId){
        
        Movie movieInfo = movieDAO.getMovieInfo(movieId);
        return movieInfo;
    }
    
    @Override
    public MovieProfile getMovieProfileInfo(String serialCode){
        
        MovieProfile profileInfo= null;
        try {
            profileInfo = movieDAO.getProfileInfo(serialCode);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Error al convertir la fecha");
        }
        return profileInfo;
    }
    
    @Override
    public int getNextMovieId(){
        
        int lastRegisteredId;
        lastRegisteredId = movieDAO.getLastMovieId();
        int nextId= lastRegisteredId + 1; //Recorrer una posición
        return nextId;
    }
    
    @Override
    public String addMovie(Movie movie, int amount){
        
        if(StatusValidator.success(movieDAO.addMovieToInventory(movie, amount) ) ){
            return "Movies added to inventory";
        }else{
            return "Couldn't add movies";
        }
    }
    
    @Override
    public String addMovieProfile(MovieProfile movieProfile){
        
        if(StatusValidator.success(movieDAO.addMovieProfile(movieProfile) ) ){
            return "New profile registered";
        }else{
            return "Couldn't add profile";
        }
    }
    
    @Override
    public String modifyMovieProfile(MovieProfile movieProfile){
        
        if(StatusValidator.success(movieDAO.modifyMovieProfile(movieProfile) ) ){
            return "Profile succesfully edited";
        }else{
            return "Couldn't update profile";
        }
    }
    
    private MovieDAO movieDAO;
    private MovieUI movieUI;
}