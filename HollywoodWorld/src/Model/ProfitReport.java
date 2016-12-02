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
public class ProfitReport {
    
    public ProfitReport(
            String employeeName,
            Date startDate,
            Date endDate,
            ArrayList<String[]> registryList,
            double totalProfit,
            double averageProfit
    ){
        this.employeeName = employeeName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.registryList = registryList;
        this. totalProfit = totalProfit;
        this.averageProfit = averageProfit;
    }
    
    public ProfitReport(
            String employeeName,
            Date startDate,
            Date endDate
    ){
        this.employeeName = employeeName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.registryList = new ArrayList<String[]>();
        this.totalProfit = 0;
        this.averageProfit = 0;
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

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public ArrayList<String[]> getRegistryList() {
        return registryList;
    }

    public void setRegistryList(ArrayList<String[]> registryList) {
        this.registryList = registryList;
    }

    public double getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(double totalProfit) {
        this.totalProfit = totalProfit;
    }
    

    public double getAverageProfit() {
        return averageProfit;
    }

    public void setAverageProfit(double averageProfit) {
        this.averageProfit = averageProfit;
    }
    
    public double totalProfit(){
        return 0;
    }
    
    public double averageProfit(){
        return 0;
    }
    
    
    
    private Date startDate;
    private Date endDate;
    private String employeeName;
    private ArrayList<String[]> registryList;
    private double totalProfit;
    private double averageProfit;
    
}
