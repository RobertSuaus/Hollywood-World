package Model;
import java.util.Date;

/**
 *
 * @author Robert
 */
public class MovieProfile {
    
    public MovieProfile(
        String title,
        Date releaseDate,
        String rating, 
        String description,
        String runTime,
        String serialCode
        ){
            this.title = title;
            this.releaseDate = releaseDate;
            this.rating = rating;
            this.description = description;
            this.runTime = runTime;
            this.serialCode = serialCode;
        }

    public MovieProfile(){
        
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    public void setRating(String rating) {
        this.rating = rating;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }
    
    public void setSerialCode(String serialCode) {
        this.serialCode = serialCode;
    }

    public String getTitle() {
        return title;
    }
    
    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public String getRunTime() {
        return runTime;
    }

    public String getSerialCode() {
        return serialCode;
    }

    private String title;
    private Date releaseDate;
    private String rating;
    private String description;
    private String runTime;
    private String serialCode;
}
