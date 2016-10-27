package Controller;

import Model.Movie;
import Model.MovieProfile;

/**
 *
 * @author Robert
 */
public interface ValidateMovieInterface {
    
    public boolean isMovieIdAvailable(int movieId);
    public boolean isSerialCodeAvailable(String serialCode);
    
    public Movie getMovieInfo(int movieId);
    public MovieProfile getMovieProfileInfo(String serialCode);
    public int getNextMovieId();
    
    public String addMovie(Movie movie, int amount);
    public String addMovieProfile(MovieProfile movieProfile);
    public String modifyMovieProfile(MovieProfile movieProfile);
    
}
