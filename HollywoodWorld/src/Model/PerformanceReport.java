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
            String employeeName, 
            Date startDate, 
            Date endDate, 
            ArrayList<String[]> registryList,
            String employeeMonth
    ){
        this.startDate = startDate;
        this.endDate = endDate;
        this.employeeName = employeeName;
        this.registryList = registryList;
        
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

    public String getEmployeeMonth() {
        return employeeMonth;
    }

    public void setEmployeeMonth(String employeeMonth) {
        this.employeeMonth = employeeMonth;
    }
    
    
    
    public Date startDate;
    public Date endDate;
    public String employeeName;
    public ArrayList<String[]> registryList;
    public String employeeMonth;
    
    
}
