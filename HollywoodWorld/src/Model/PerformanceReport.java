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
public class PerformanceReport {
    
    public PerformanceReport(
            Date startDate, 
            Date endDate, 
            ArrayList<String[]> registryList,
            String employeeMonth,
            int averageRents
    ){
        this.startDate = startDate;
        this.endDate = endDate;
        this.registryList = registryList;
        this.employeeMonth = employeeMonth;
        this.averageRents = averageRents;
    }
    
    public PerformanceReport(
            Date startDate,
            Date endDate
    ){
        this.startDate = startDate;
        this.endDate = endDate;
        this.registryList = new ArrayList<String[]>();
        this.employeeMonth = "";
        this.averageRents = 0;
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

    public String getEmployeeMonth() {
        return employeeMonth;
    }

    public void setEmployeeMonth(String employeeMonth) {
        this.employeeMonth = employeeMonth;
    }

    public int getAverageRents() {
        return averageRents;
    }

    public void setAverageRents(int averageRents) {
        this.averageRents = averageRents;
    }
    
    
    
    private Date startDate;
    private Date endDate;
    private ArrayList<String[]> registryList;
    private String employeeMonth;
    private int averageRents;
    
    
}
