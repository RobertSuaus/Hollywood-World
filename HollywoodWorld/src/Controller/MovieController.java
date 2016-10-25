package Controller;

import Model.Movie;
import Model.MovieProfile;

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
        
    }
    
    @Override
    public boolean isSerialCodeAvailable(int serialCode){
        
    }
    
    @Override
    public Movie getMovieInfo(int movieId){
        
    }
    
    @Override
    public MovieProfile getMovieProfileInfo(int serialCode){
        
    }
    
    @Override
    public int getNextMovieId(){
        
    }
    
    @Override
    public void addMovie(Movie movie, int amount){
        
    }
    
    @Override
    public void addMovieProfile(MovieProfile movieProfile){
        
    }
    
    @Override
    public void modifyMovie(Movie movie){
        
    }
    
    @Override
    public void modifyMovieProfile(MovieProfile movieProfile){
        
    }
    
    private MovieDAO movieDAO;
    private MovieUI movieUI;
}
