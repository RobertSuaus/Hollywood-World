/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.EmployeeDAO;
import View.GenerateKardexUI;
import View.GeneratePayrollUI;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Robert
 */
public class Accountant {
    /*El contador es el encargado de crear los desgloses de nómina y el kardex
    de los empleados. Para esto realiza el cálculo de bonificaciones y demás
    impuestos*/
    
    public Accountant(GeneratePayrollUI generatePayrollUI){
        
        this.generatePayrollUI = generatePayrollUI;
        this.payrollBreakdown = new PayrollBreakdown();
    }
    
    public Accountant(GenerateKardexUI generateKardexUI){
        
        this.generateKardexUI = generateKardexUI;
    }
    
    public String createPayrollBreakdown(String[] userInputs){
        
        String employeeIdInput = userInputs[0];
        String daysWorkedInput = userInputs[1];
        
        if(isValidInputNumber(employeeIdInput) && isValidInputNumber(daysWorkedInput) ){
            int employeeId = Integer.valueOf(employeeIdInput);
            if(employeeExists(employeeId) ){
                
                //Generar el desglose de nómina
                payrollBreakdown.setEmployeeId(employeeId);
                
                payrollBreakdown.setRetention(retention);
                payrollBreakdown.setBonification(bonification);
                
                int daysWorked = Integer.valueOf(daysWorkedInput);
                payrollBreakdown.setDaysWorked(daysWorked);
                
                payrollBreakdown.setSundayBonus(sundayBonus);
                payrollBreakdown.setTotalPayment(totalPayment);
                payrollBreakdown.setIntegratedWage(integratedWage);
                
                payrollBreakdown.setPaymentDate(new Date());
                
                generatePayrollUI.fillPayrollBreakdownTable(payrollBreakdown);
            }
        }
    }
    
    public String requestPayrollArchiving(){
        //Se debe ver que payrollBreakdown no esté vacio.
        return AccountingManager.archievePayrollBreakdown(payrollBreakdown);
    }
    
    public String generateKardex(String employeeIdInput){
        
        if(isValidInputNumber(employeeIdInput) ){
            int employeeId = Integer.valueOf(employeeIdInput);
            if(employeeExists(employeeId) ){
                
                ArrayList<PayrollBreakdown> kardex = AccountingManager.getEmployeeKardex(employeeId);
                generateKardexUI.fillPayrollBreakdownTable(kardex);
            }
        }
    }
    
    private double calculateIntegratedWage(){
        
    }
    
    private double calculateSundayBonus(){
        
    }
    
    private Retention calculateRetention(){
        
    }
    
    private Bonification calculateBonification(){
        
    }
    
    private boolean isValidInputNumber(String input){
        
        if (input.matches("([0-9]|\\s)*") && 
            input.equals(" ") == false && 
            input.equals("") == false){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean employeeExists(int employeeId){
        
        if(EmployeeDAO.registryExists(employeeId) ){
            return true;
        }else{
            return false;
        }
    }
    
    private GeneratePayrollUI generatePayrollUI;
    private GenerateKardexUI generateKardexUI;
    
    private PayrollBreakdown payrollBreakdown;
}
