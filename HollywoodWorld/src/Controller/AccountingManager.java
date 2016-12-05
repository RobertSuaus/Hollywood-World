/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.StatusValidator;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Robert
 */
public class AccountingManager {
    
    public static String archievePayrollBreakdown(PayrollBreakdown payrollBreakdown){
        
        if(StatusValidator.success(PayrollDAO.save(payrollBreakdown) ) ){
                return "Se ha almacenado el desglose de nómina exitosamente";
            }else{
                return "No se pudo almacenar el desglose de nómina";
            }
    }
    
    public static ArrayList<PayrollBreakdown> getEmployeeKardex(int employeeId){
        
        return PayrollDAO.getRegistries(employeeId);
    }
    
    public static String[] getPayrollBreakdownSummary(
        Date startDate,
        Date endDate
    ){
        return PayrollDAO.getRegistries(startDate, endDate);
    }
}
