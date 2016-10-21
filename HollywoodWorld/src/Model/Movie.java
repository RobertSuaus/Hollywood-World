package Model;

/**
 *
 * @author Robert
 */
public class Movie {
    /*Representa una película de forma individual*/
    
    public Movie(
        int id,
        MovieProfile profile
        ){
            this.id = id;
            this.profile = profile;
        
        }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setProfile(MovieProfile profile){
        this.profile = profile;
    }
    
    public int getId(){
        return id;
    }
    
    public MovieProfile getProfile(){
        return profile;
    }
    
    private int id;
    private MovieProfile profile;
}
