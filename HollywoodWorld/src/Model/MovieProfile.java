/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        int runTime,
        int serialCode
        ){
            this.title = title;
            this.releaseDate = releaseDate;
            this.rating = rating;
            this.description = description;
            this.runTime = runTime;
            this.serialCode = serialCode;
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
    
    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }
    
    public void setSerialCode(int serialCode) {
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

    public int getRunTime() {
        return runTime;
    }

    public int getSerialCode() {
        return serialCode;
    }

    private String title;
    private Date releaseDate;
    private String rating;
    private String description;
    private int runTime;
    private int serialCode;
}
