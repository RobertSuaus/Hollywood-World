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
import View.GenerateKardex;
import View.GeneratePayrollForm;
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
    
    public Accountant(GeneratePayrollForm generatePayrollUI){
        
        this.generatePayrollForm = generatePayrollUI;
        this.payrollBreakdown = new PayrollBreakdown();
    }
    
    public Accountant(GenerateKardex generateKardexUI){
        
        this.generateKardex = generateKardexUI;
    }
    
    public String generatePayrollBreakdown(String[] userInputs,
        boolean[] userBooleanInputs) throws ParseException{
        
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
                
                payrollBreakdown.setBonus( 
                    calculateBonification(userBooleanInputs) );
                
                payrollBreakdown.setIntegratedWage( calculateIntegratedWage() );
                
                payrollBreakdown.setRetention( calculateRetention() );
                
                payrollBreakdown.setTotalPayment(calculateTotalPayment());
                                
                payrollBreakdown.setBreakdownDate(new Date());
                
                generatePayrollForm.fillPayrollBreakdownTable(payrollBreakdown);
                return "Desglose generado exitosamente!";
            }
            return "El empleado no existe";
        }
        return "Por favor, ingrese números válidos";
    }
    
    public String requestPayrollArchiving(){
        
        if( isBreakDodwnCalculated() ){
            return AccountingManager.archievePayrollBreakdown(payrollBreakdown);
        } else {
            return "Debe generar un desglose de nómina primero";
        }
    }
    
    public String generateKardex(String employeeIdInput) throws ParseException{
        
        if( isValidInputNumber(employeeIdInput) ){
            
            int employeeId = Integer.valueOf(employeeIdInput);
            if(employeeExists(employeeId) ){
                
                ArrayList<PayrollBreakdown> kardex = AccountingManager.getEmployeeKardex(employeeId);
                generateKardex.fillPayrollBreakdownTable(kardex);
                return "Mostrando kardex de empleado...";
            }
            return "El empleado no existe!";
        }
        return "Ingrese un número valido de ID";
    }
    
    private boolean isBreakDodwnCalculated(){
        
        boolean isCalculated = false;
        
        if ( payrollBreakdown.getIntegratedWage() != 0 &&
            payrollBreakdown.getBreakdownDate() != null &&
            payrollBreakdown.getTotalPayment() != 0 &&
            payrollBreakdown.getWorkedDays() != 0) {
            isCalculated  = true;
        } else {
            isCalculated = false;
        }
        
        return isCalculated;
    }
    
    private int getNextBreakdownId(){
        
        int lastId = PayrollDAO.getLastRegistryIndex();
        int nextId = lastId + 1;
        
        return nextId;
    }
    
    private double calculateTotalPayment() {
        
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
            LEGAL_DAYS_PAID_PER_CHRISTMASBOX ) / DAYS_OF_YEAR;
        
        double integratedWage = christmasBoxTax + employee.getBasicSalary() + 
            payrollBreakdown.getBonus().getDominical();  
        
        return integratedWage;
    }
    
    private Retention calculateRetention(){
        
        Retention retention = new Retention();
        
        //CAlcular ISR
        retention.setISR( calculateISR() );
        
        //Calcular impuesto por IMSS
        if( isgreaterThanMinimumWage() ) {
            retention.setTaxPerIMSS( calculateTaxPerIMSS() );
        }
        
        return retention;
    }
    
    private Bonus calculateBonification(boolean[] inputs){
        
        Bonus bonification = new Bonus();
        
        bonification.setDominical( calculateSundayBonus() );
        
        //Calcular Aguinaldo
        if ( isTimeToPayChristmasBox( inputs[0] ) ) {
            bonification.setChristmasBox( calculateChristmasBox() );
        }
        
        //Calcular prima vacacional
        if ( isTimeToPayHolidayBonus( inputs[1] ) ) {
            bonification.setHolidayBonus( calculateHolidayBonus() );
        }
        
        return bonification;
    }
    
    private boolean isTimeToPayChristmasBox(boolean input) { 
        
        if (input) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean isTimeToPayHolidayBonus(boolean input) {
        
        if (input) {
            return true;
        } else  {
            return false;
        }
    }
    
    private double calculateSundayBonus(){

        final double SET_DAYS_WORKED_OF_WEEK = 6;
        
        double sundayBonus = employee.getBasicSalary() *
                PERCENTAGE_BONUS_LFT * SET_DAYS_WORKED_OF_WEEK;
        sundayBonus = sundayBonus / DAYS_OF_YEAR;
        
        return sundayBonus;
    }
    
    private double calculateChristmasBox(){
        
        double christmasBox;                
        int workedDaysOfYear = calculateWorkedDays();
        
        if( workedDaysOfYear >=  DAYS_OF_YEAR) { //caso 1 año o más
            christmasBox = employee.getBasicSalary() * LEGAL_DAYS_PAID_PER_CHRISTMASBOX;
        } else { //Caso menor de un año
            christmasBox = employee.getBasicSalary() * LEGAL_DAYS_PAID_PER_CHRISTMASBOX;
            christmasBox = christmasBox / DAYS_OF_YEAR;
            christmasBox = christmasBox * workedDaysOfYear;
        }
        
        return christmasBox;
    }
    
    private int calculateWorkedDays() {
        
        Date today = new Date();
        final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día
        
        long workedDaysOfYear = ( today.getTime() - 
            employee.getAdmissionDate().getTime() ) / MILLSECS_PER_DAY;
        
        return (int)workedDaysOfYear;     
    }
    
    private double calculateHolidayBonus() {
        
        //Días por antigüedad
        int numberOfDaysHoliday = 
            calculateNumberOfDaysHoliday();
        
        double holidayBonus =  ( numberOfDaysHoliday * 
            employee.getBasicSalary() ) * PERCENTAGE_BONUS_LFT;
        
        return holidayBonus;        
    } 
    
    private double calculateISR() {
        
        final int PAID_PERIOD = 15;
        
        double wage = payrollBreakdown.getIntegratedWage() * PAID_PERIOD;
        
        TaxDeduction taxDeduction = getTaxDeduction(wage);
        
        double  excess = wage - taxDeduction.getBoundaryBotom();
        
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
               
        final double TOTAL_PERCENTAGE = 0.0125;//Suma de todos los porccentajes       
        final int DAYS_OF_MONTH = 30;//Caso general
        
        double monthlyWage = payrollBreakdown.getIntegratedWage() * DAYS_OF_MONTH;
        
        double taxPerIMSS = 0;
        taxPerIMSS = monthlyWage * TOTAL_PERCENTAGE; 
        taxPerIMSS = taxPerIMSS / 2; //Dos quincenas al mes
        
        return taxPerIMSS;
    }
    
    private boolean isgreaterThanMinimumWage() {
        
        final int DAYS_OF_MONTH = 30;
        
        double monthlyWage = payrollBreakdown.getIntegratedWage() * DAYS_OF_MONTH;
        
        final double MINIMUM_WAGE = 71.54;
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
        
        int numberOfDaysHoliday = 0;
        
        int daysOfService  = calculateWorkedDays();        
        int lengthOfService = calculateLengthOfService( daysOfService );
        
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
    
    private int calculateLengthOfService(int daysOfService) {
        
        return daysOfService / DAYS_OF_YEAR;
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
    
    private GeneratePayrollForm generatePayrollForm;
    private GenerateKardex generateKardex;
    
    private PayrollBreakdown payrollBreakdown;

    private Employee employee;
        
    private final double PERCENTAGE_BONUS_LFT = 0.25;
    private final int LEGAL_DAYS_PAID_PER_CHRISTMASBOX = 15;
    private final int DAYS_OF_YEAR = 365;
}
