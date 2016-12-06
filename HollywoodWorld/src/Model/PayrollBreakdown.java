/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author che_i
 */
public class PayrollBreakdown {
    
    public PayrollBreakdown(
        int breakdownId,
        int employeeId,
        Retention retention, 
        Bonus bonus, 
        int workedDays, 
        double totalPayment, 
        double integratedWage,
        Date breakdownDate
    ){
        this.breakdownId = breakdownId;
        this.employeeId = employeeId;
        this.retention = retention;
        this.bonus = bonus;
        this.workedDays = workedDays;
        this.totalPay = totalPayment;
        this.integratedWage = integratedWage;    
        this.breakdownDate = breakdownDate;
    }
    
    public PayrollBreakdown(){
        
    }

    public Date getBreakdownDate() {
        return breakdownDate;
    }

    public void setBreakdownDate(Date desgloseDate) {
        this.breakdownDate = desgloseDate;
    }

    public int getDesgloseId() {
        return breakdownId;
    }

    public void setDesgloseId(int desgloseId) {
        this.breakdownId = desgloseId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Retention getRetention() {
        return retention;
    }

    public void setRetention(Retention retention) {
        this.retention = retention;
    }

    public Bonus getBonus() {
        return bonus;
    }

    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }

    public int getWorkedDays() {
        return workedDays;
    }

    public void setWorkedDays(int workedDays) {
        this.workedDays = workedDays;
    }

    public double getTotalPayment() {
        return totalPay;
    }

    public void setTotalPayment(double totalPay) {
        this.totalPay = totalPay;
    }

    public double getIntegratedWage() {
        return integratedWage;
    }

    public void setIntegratedWage(double fullSalary) {
        this.integratedWage = fullSalary;
    }
    
    
    private int breakdownId;
    private int employeeId;
    private Retention retention;
    private Bonus bonus;
    private int workedDays;
    private double totalPay;
    private double integratedWage;
    private Date breakdownDate;
}
