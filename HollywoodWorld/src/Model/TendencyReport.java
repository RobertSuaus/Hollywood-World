/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Reynaldo Marrufo
 */
public class TendencyReport {
    

    public TendencyReport(
            Date startDate, 
            Date endDate,  
            ArrayList<String[]> registryList,
            String mostRentedMovie
    ){
        this.startDate = startDate;
        this.endDate = endDate;
        this.registryList = registryList;
        this.mostRentedMovie = mostRentedMovie;
    }
    
    public TendencyReport(
            Date startDate,
            Date endDate
    ){
        this.startDate = startDate;
        this.endDate = endDate;
        this.registryList = new ArrayList<String[]>();
        this.mostRentedMovie = "";
    }
    
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ArrayList<String[]> getRegistryList() {
        return registryList;
    }

    public void setRegistryList(ArrayList<String[]> registryList) {
        this.registryList = registryList;
    }

    public String getMostRentedMovie() {
        return mostRentedMovie;
    }

    public void setMostRentedMovie(String mostRentedMovie) {
        this.mostRentedMovie = mostRentedMovie;
    }

    
    
    private Date startDate;
    private Date endDate;
    private ArrayList<String[]> registryList;
    private String mostRentedMovie;
    
}
