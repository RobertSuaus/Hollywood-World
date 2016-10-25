package Controller;

import Model.Movie;
import Model.MovieProfile;

/**
 *
 * @author Robert
 */
public interface ValidateMovieInterface {
    
    public boolean isMovieIdAvailable(int movieId);
    public boolean isSerialCodeAvailable(int serialCode);
    
    public Movie getMovieInfo(int movieId);
    public MovieProfile getMovieProfileInfo(int serialCode);
    public int getNextMovieId();
    
    public void addMovie(Movie movie, int amount);
    public void addMovieProfile(MovieProfile movieProfile);
    public void modifyMovie(Movie movie);
    public void modifyMovieProfile(MovieProfile movieProfile);
    
}
