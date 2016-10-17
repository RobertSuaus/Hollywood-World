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
        String title,
        String description,
        String category,
        int id,
        int serialCode
        ){
            this.title = title;
            this.description = description;
            this.category = category;
            this.id = id;
            this.serialCode = serialCode;
        
        }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public void setCategory(String category){
        this.category = category;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setSerialCode(int serialCode){
        this.serialCode = serialCode;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getDescription(){
        return description;
    }
    
    public String getCategory(){
        return category;
    }
    
    public int getId(){
        return id;
    }
    
    public int getSerialCode(){
        return serialCode;
    }
    
    private String title;
    private String description;
    private String category;
    private int id;
    private int serialCode;
}
