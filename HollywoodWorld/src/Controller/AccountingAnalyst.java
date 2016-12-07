/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.PatreonPayrollForm;
import java.util.Date;

/**
 *
 * @author Robert
 */
public class AccountingAnalyst {
    /*Se encarga de verificar que los datos para los reportes de nómina sean correctos
    , solicita y entrega estos reportes al usuario.*/
    
    public AccountingAnalyst(PatreonPayrollForm patreonPayrollUI){
        
        this.patreonPayrollForm = patreonPayrollUI;
    }
    
    public void requestPayrollSummary(Date startDateInput, Date endDateInput){
        
        if(isDateInputNotEmpty(startDateInput, endDateInput ) ){
            if(isDateRangeValid(startDateInput, endDateInput) ){
                
                //Solicitar los datos de nómina al gerente
                String[] payrollSummary = AccountingManager.getPayrollBreakdownSummary(
                    startDateInput,
                    endDateInput
                );
                
                //Desplegar resultado al usuario
                patreonPayrollForm.fillRegistryTable(payrollSummary);
            }
        }
    }
    
    private boolean isDateInputNotEmpty(Date startDate, Date endDate){
        
        /*El formato de jDatePicker es siempre valido sintácticamente, 
        pero se debe verificar que en efecto se haya seleccionado algo*/
        if(startDate != null && endDate != null ){
            return true;
        }else{
            return false;
        }
    }
    
    //Revisa que la fecha de inicio sea menor o igual a la fecha final
    private boolean isDateRangeValid(Date startDate, Date endDate){
        
        /*Java Date compareTo: Retorna 0 si las fechas son iguales, retorna un
         valor menor a 0 si la fecha es menor a la fecha de argumento*/
        if(startDate.compareTo(endDate) == 0 ||  startDate.compareTo(endDate) < 0){
            return true;
        }else{
            return false;
        }
    }
    
    private PatreonPayrollForm patreonPayrollForm;
}
