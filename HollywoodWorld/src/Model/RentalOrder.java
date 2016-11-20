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
            int membershipId,
            String clientName,
            int clientMembership,
            Date transactionDate,
            Date returnDate,
            ArrayList<Lease> leases,
            double totalRent   
    ){
       this.folio = folio;
       this.employeeName = employeeName;
       this.clientName = clientName;
       this.membershipId = membershipId;
       this.transactionDate = transactionDate;
       this.returnDate = returnDate;
       this.totalRent = totalRent;
       this.leases = leases;
    } 
    
    public RentalOrder(int folio, String employeeName){
        
        this.folio = folio;
        this.employeeName = employeeName;
        this.transactionDate = new Date();
        this.leases = new ArrayList<Lease>();
    }
    
    public RentalOrder(
            int folio,
            String employeeName,
            int membershipId,
            String clientName,
            int clientMembership,
            Date transactionDate,
            Date returnDate,
            double totalRent
    ){
        this.folio = folio;
       this.employeeName = employeeName;
       this.clientName = clientName;
       this.membershipId = membershipId;
       this.transactionDate = transactionDate;
       this.returnDate = returnDate;
       this.totalRent = totalRent;
        
    }
    
    public RentalOrder(){
        
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
    
    public int getMembershipId(){
        return membershipId;
    }
    
    public void setMembershipId( int clientMembership){
        this.membershipId = clientMembership;
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

    public ArrayList<Lease> getRentDetails() {
        return leases;
    }

    public void setLeases(ArrayList<Lease> leases) {
        this.leases = leases;
    }
    
    public ArrayList<Lease> getLeases(){
        return leases;
        
    }
    
    public void addLease(Lease rentDetail){
        leases.add(rentDetail);
    }
    
    public void removeLease(int detailIndex){
        leases.remove(detailIndex);
    }
    
    public void computeTotal(){
        
        double total = 0;
        for(Lease lease : leases){
            total = total + lease.getPrice();
        }
        totalRent = total;
    }
    
    private int folio;
    private String employeeName;
    private String clientName;
    private int membershipId;
    private Date transactionDate;
    private Date returnDate;
    private double totalRent;
    private ArrayList<Lease> leases;
    

}
