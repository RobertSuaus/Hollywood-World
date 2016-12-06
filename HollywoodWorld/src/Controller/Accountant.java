/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Bonus;
import Model.EmployeeDAO;
import Model.PayrollBreakdown;
import Model.PayrollDAO;
import Model.Retention;
import View.GenerateKardexUI;
import View.GeneratePayrollUI;
import java.text.ParseException;
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
                payrollBreakdown.setDesgloseId(getNextBreakdownId() );
                payrollBreakdown.setEmployeeId(employeeId);
                
                payrollBreakdown.setRetention(new Retention() );
                payrollBreakdown.setBonus(new Bonus() );
                
                int daysWorked = Integer.valueOf(daysWorkedInput);
                payrollBreakdown.setWorkedDays(daysWorked);
                
                payrollBreakdown.setTotalPayment(0);
                payrollBreakdown.setIntegratedWage(0);
                
                payrollBreakdown.setBreakdownDate(new Date());
                
                generatePayrollUI.fillPayrollBreakdownTable(payrollBreakdown);
                return "Desglose generado exitosamente!";
            }
            return "El empleado no existe";
        }
        return "Por favor, ingrese números válidos";
    }
    
    public String requestPayrollArchiving(){
        //Se debe ver que payrollBreakdown no esté vacio.
        return AccountingManager.archievePayrollBreakdown(payrollBreakdown);
    }
    
    public String generateKardex(String employeeIdInput) throws ParseException{
        
        if(isValidInputNumber(employeeIdInput) ){
            int employeeId = Integer.valueOf(employeeIdInput);
            if(employeeExists(employeeId) ){
                
                ArrayList<PayrollBreakdown> kardex = AccountingManager.getEmployeeKardex(employeeId);
                generateKardexUI.fillPayrollBreakdownTable(kardex);
                return "Mostrando kardex de empleado...";
            }
            return "El empleado no existe!";
        }
        return "por favor, ingrese un número valido";
    }
    
    private int getNextBreakdownId(){
        
        int lastId = PayrollDAO.getLastRegistryIndex();
        int nextId = lastId + 1;
        
        return nextId;
    }
    
    private double calculateIntegratedWage(){
        return 0;
    }
    
    private double calculateSundayBonus(){
        return 0;
    }
    
    private Retention calculateRetention(){
        return null;
    }
    
    private Bonus calculateBonification(){
        return null;
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
