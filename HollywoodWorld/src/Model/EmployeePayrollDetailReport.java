/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author che_i
 */
public class EmployeePayrollDetailReport {
    
    public EmployeePayrollDetailReport(int employeeId, 
                Retention retention, 
                Bonus bonus, 
                int workedDays, 
                double totalPay, 
                double fullSalary){
        this.employeeId = employeeId;
        this.retention = retention;
        this.bonus = bonus;
        this.workedDays = workedDays;
        this.totalPay = totalPay;
        this.fullSalary = fullSalary;        
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

    public double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(double totalPay) {
        this.totalPay = totalPay;
    }

    public double getFullSalary() {
        return fullSalary;
    }

    public void setFullSalary(double fullSalary) {
        this.fullSalary = fullSalary;
    }
    
    private int employeeId;
    private Retention retention;
    private Bonus bonus;
    private int workedDays;
    private double totalPay;
    private double fullSalary;
}
