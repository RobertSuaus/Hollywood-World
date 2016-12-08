/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Bonus;
import Model.Employee;
import Model.EmployeeDAO;
import Model.PayrollBreakdown;
import Model.PayrollDAO;
import Model.Retention;
import Model.TaxDeduction;
import Model.TaxDeductionRates;
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
    
    public String createPayrollBreakdown(String[] userInputs) throws ParseException{
        
        String employeeIdInput = userInputs[0];
        String daysWorkedInput = userInputs[1];
        
        if(isValidInputNumber(employeeIdInput) && isValidInputNumber(daysWorkedInput) ){
            int employeeId = Integer.valueOf(employeeIdInput);
            if(employeeExists(employeeId) ){
                
                employee = EmployeeDAO.getRegistry(employeeId);
                
                //Generar el desglose de nómina
                payrollBreakdown.setDesgloseId(getNextBreakdownId() );
                payrollBreakdown.setEmployeeId(employeeId);
                
                int daysWorked = Integer.valueOf(daysWorkedInput);
                payrollBreakdown.setWorkedDays(daysWorked);                
                
                payrollBreakdown.setBonus( calculateBonification() );
                
                payrollBreakdown.setIntegratedWage( calculateIntegratedWage() );
                
                payrollBreakdown.setRetention( calculateRetention() );
                
                payrollBreakdown.setTotalPayment(calculateTotalPayment());
                                
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
    
    private double calculateTotalPayment() {
        
        //Faltará restar retenciones
        double salary = payrollBreakdown.getWorkedDays() * 
            payrollBreakdown.getIntegratedWage();
        
        //Salario más bonos
        double totalPayment = salary +
            payrollBreakdown.getBonus().getChristmasBox() +
            payrollBreakdown.getBonus().getHolidayBonus();
        
        //Salario menos retenciones
        totalPayment = totalPayment -
            payrollBreakdown.getRetention().getISR() - 
            payrollBreakdown.getRetention().getTaxPerIMSS();
            
        return totalPayment;
    }
    
    private double calculateIntegratedWage(){
        
        double christmasBoxTax = ( employee.getBasicSalary() *
            LEGAL_DAYS_PAID ) / DAYS_OF_YEAR;
        
        double integratedWage = christmasBoxTax + employee.getBasicSalary() + 
            payrollBreakdown.getBonus().getDominical();  
        
        return integratedWage;
    }
    
    private Retention calculateRetention(){
        
        Retention retention = new Retention();
        
        retention.setISR( calculateISR() );
        
        if( isgreaterThanMinimumWage() ) {
            retention.setTaxPerIMSS( calculateTaxPerIMSS() );
        }
        
        return retention;
    }
    
    private Bonus calculateBonification(){
        
        Bonus bonification = new Bonus();
        
        bonification.setDominical( calculateSundayBonus() );
        
        if ( isTimeToPayChristmasBox() ) {
            bonification.setChristmasBox( calculateChristmasBox() );
        }
        
        if ( isTimeToPayHolidayBonus() ) {
            bonification.setHolidayBonus( calculateHolidayBonus() );
        }
        
        return bonification;
    }
    
    private boolean isTimeToPayChristmasBox() {        
        return true;
    }
    
    private boolean isTimeToPayHolidayBonus() {
        return true;
    }
    
    private double calculateSundayBonus(){

        final double SET_DAYS_WORKED = 6;
        
        double sundayBonus = employee.getBasicSalary() * PERCENTAGE_BONUS_LFT * SET_DAYS_WORKED;
        sundayBonus = sundayBonus / DAYS_OF_YEAR;
        
        return sundayBonus;
    }
    
    private double calculateChristmasBox(){
        
        Date today = new Date();
        double christmasBox;
        final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día
        
        long workedDaysOfYear = ( today.getTime() - 
            employee.getAdmissionDate().getTime() ) / MILLSECS_PER_DAY;
        
        if( workedDaysOfYear >=  DAYS_OF_YEAR) {
            christmasBox = employee.getBasicSalary() * LEGAL_DAYS_PAID;
        } else {
            christmasBox = employee.getBasicSalary() * LEGAL_DAYS_PAID;
            christmasBox = christmasBox / DAYS_OF_YEAR;
            christmasBox = christmasBox * workedDaysOfYear;
        }
        
        return christmasBox;
    }
    
    private double calculateHolidayBonus() {
        
        int numberOfDaysHoliday = 
            calculateNumberOfDaysHoliday();
        
        double holidayBonus =  ( numberOfDaysHoliday * 
            employee.getBasicSalary() ) * PERCENTAGE_BONUS_LFT;
        
        return holidayBonus;        
    } 
    
    private double calculateISR() {
        
        final int PAID_PERIOD = 15;
        
        double salary = payrollBreakdown.getIntegratedWage() * PAID_PERIOD;
        
        TaxDeduction taxDeduction = getTaxDeduction(salary);
        
        double boundaryBotom = 2077.51;
        double boundaryTop = 3651.00;
        double fixedQuota = 121.95;
        double percentageApplied = 0.1088;
        
        double  excess = salary - taxDeduction.getBoundaryBotom();
        
        double marginalTax = excess * taxDeduction.getPercentageApplied();        
        
        double ISRRetenido = marginalTax + taxDeduction.getFixedQuota();
        
        return ISRRetenido;
    }
    
    private double calculateTaxPerIMSS() {
        
        /*
        Porcetaje por beneficio = 0.0025;
        Porcentaje por gasto médico = 0.00375;
        Porcentaje por validez y vida = 0.00625;
        */
        
        final double TOTAL_PERCENTAGE = 0.0125;
        final int DAYS_OF_MONTH = 30;
        
        double monthlyWage = payrollBreakdown.getIntegratedWage() * DAYS_OF_MONTH;
        double taxPerIMSS = 0;

        taxPerIMSS = monthlyWage * TOTAL_PERCENTAGE; 
        taxPerIMSS = taxPerIMSS / 2; //Dos quincenas al mes
        
        return taxPerIMSS;
    }
    
    private boolean isgreaterThanMinimumWage() {
        
        final int DAYS_OF_MONTH = 30;
        
        double monthlyWage = payrollBreakdown.getIntegratedWage() * DAYS_OF_MONTH;
        
        final double MINIMUM_WAGE = 61.54;
        boolean isGraterThan;
        
        double bound = MINIMUM_WAGE * 3;
         
        if (monthlyWage <= bound){
           isGraterThan = false; 
        } else {
            isGraterThan = true;
        } 
        
        return isGraterThan;
    }
    
    private TaxDeduction getTaxDeduction(double wage){
        
        TaxDeduction taxDeduction = null;
        
        for (TaxDeductionRates registry : TaxDeductionRates.values()) {
            
            if (registry.getBoundaryBotom() < wage &&
                registry.getBoundaryTop() > wage
                ){
                taxDeduction = new TaxDeduction(registry.getBoundaryBotom(),
                    registry.getBoundaryTop(),
                    registry.getFixedQuota(),
                    registry.getPercentageApplied());
            }
        }
        
        return taxDeduction;
    }
    
    private int calculateNumberOfDaysHoliday() {
        
        final int MINIMUM_DAYS_HOLIDAY = 6;
        final int FIRST_LAPSE = 3;
        final int LAST_LAPSE = 5;
        final int DAYS_PER_YEAR = 2;
        
        Date today = new Date();
        final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día
        
        int numberOfDaysHoliday = 0;
        
        long daysOfService  = ( today.getTime() - 
            employee.getAdmissionDate().getTime() ) / MILLSECS_PER_DAY;
        
        int lengthOfService = (int)daysOfService / DAYS_OF_YEAR;
        
        if ( lengthOfService <= FIRST_LAPSE ) {
            
            numberOfDaysHoliday = lengthOfService * DAYS_PER_YEAR;
            numberOfDaysHoliday = numberOfDaysHoliday + MINIMUM_DAYS_HOLIDAY;
        } else {
            
            numberOfDaysHoliday = FIRST_LAPSE * DAYS_PER_YEAR;
            numberOfDaysHoliday = numberOfDaysHoliday + MINIMUM_DAYS_HOLIDAY;
            
            int lastYearsServices = lengthOfService - FIRST_LAPSE;
            
            int aditionalDays = lastYearsServices / LAST_LAPSE;
            aditionalDays = aditionalDays * DAYS_PER_YEAR;
            
            numberOfDaysHoliday = numberOfDaysHoliday + aditionalDays;
        }
        
        return numberOfDaysHoliday;
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

    private Employee employee;
        
    private final double PERCENTAGE_BONUS_LFT = 0.25;
    private final int LEGAL_DAYS_PAID = 15;
    private final int DAYS_OF_YEAR = 365;
}
