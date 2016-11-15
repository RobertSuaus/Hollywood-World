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
public class RentalOrder {
    
    public RentalOrder(
            int folio,
            String employeeName,
            String clientName,
            Date transactionDate,
            Date returnDate,
            ArrayList<RentDetail> rentDetails,
            double totalRent   
    ){
       this.folio = folio;
       this.employeeName = employeeName;
       this.clientName = clientName;
       this.transactionDate = transactionDate;
       this.returnDate = returnDate;
       this.totalRent = totalRent;
       this.rentDetails = rentDetails;
    } 

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public double getTotalRent() {
        return totalRent;
    }

    public void setTotalRent(double totalRent) {
        this.totalRent = totalRent;
    }

    public ArrayList<RentDetail> getRentDetails() {
        return rentDetails;
    }

    public void setRentDetails(ArrayList<RentDetail> rentDetails) {
        this.rentDetails = rentDetails;
    }
    
    public ArrayList getRentDetails(ArrayList<RentDetail> rentDetails){
        return rentDetails;
        
    }
    
    public void addRentDetail(RentDetail rentDetail){
        rentDetails.add(rentDetail);
    }
    
    public void removeRentDetail(int detailIndex){
        rentDetails.remove(detailIndex);
    }
    
    public double computeTotal(){
        
        return 0;
    }
    
    private int folio;
    private String employeeName;
    private String clientName;
    private Date transactionDate;
    private Date returnDate;
    private double totalRent;
    private ArrayList<RentDetail> rentDetails;

}
