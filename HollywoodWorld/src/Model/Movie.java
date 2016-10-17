/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
