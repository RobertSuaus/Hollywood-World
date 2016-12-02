package Controller;

import Model.PerformanceReport;
import Model.ProfitReport;
import Model.TendencyReport;
import View.PerformanceReportUI;
import View.ProfitReportUI;
import View.TendencyReportUI;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Robert
 */
public class FinancesAgent {
    /*El agente de finanzas se encarga de manejar las solicitudes de reportes,
    le solicita al analista de negocio la información de negocio y
    llena los reportes*/
    
    public FinancesAgent(ProfitReportUI profitUI, String userName){
        
        this.profitUI = profitUI;
        this.employeeName = userName;
        //Crear reporte con datos iniciales conocidos
    }
    
    public FinancesAgent(TendencyReportUI tendencyUI, String userName){
        
        this.tendencyUI = tendencyUI;
        this.employeeName = userName;
        //Crear reporte con datos iniciales conocidos
    }
    
    public FinancesAgent(PerformanceReportUI performanceUI, String userName){
        
        this.performanceUI = performanceUI;
        this.employeeName = userName;
        //Crear reporte con datos iniciales conocidos
    }
    
    public void requestProfitReport(Date startDateInput, Date endDateInput){
        
        if(isDateInputNotEmpty(startDateInput, endDateInput ) ){
            if(isDateRangeValid(startDateInput, endDateInput) ){
                
                //Entregar la solicitud al analista para que sea llenado
                ProfitReport profitReport = BusinessAnalyst.fillProfitReport(
                    employeeName,
                    startDateInput,
                    endDateInput
                );
                
                //Desplegar resultado al usuario
                profitUI.fillReportFields(profitReport);
            }
        }
    }
    
    public void requestTendencyReport(Date startDateInput, Date endDateInput){
        
        if(isDateInputNotEmpty(startDateInput, endDateInput ) ){
            if(isDateRangeValid(startDateInput, endDateInput) ){
                
                //Entregar la solicitud al analista para que sea llenado
                TendencyReport tendencyReport = BusinessAnalyst.fillTendencyReport(
                    employeeName,
                    startDateInput,
                    endDateInput
                );
                
                //Desplegar resultado al usuario
                tendencyUI.fillReportFields(tendencyReport);
            }
        }
    }
    
    public void requestPerformanceReport(Date startDateInput, Date endDateInput){
        
        if(isDateInputNotEmpty(startDateInput, endDateInput ) ){
            if(isDateRangeValid(startDateInput, endDateInput) ){
                
                //Entregar la solicitud al analista para que sea llenado
                PerformanceReport performanceReport = BusinessAnalyst.fillPerformanceReport(
                    employeeName,
                    startDateInput,
                    endDateInput
                );
                
                //Desplegar resultado al usuario
                performanceUI.fillReportFields(performanceReport);
            }
        }
    }
    
    //Revisa que las fechas ingresadas sean validas
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
    private String employeeName;
    private ProfitReportUI profitUI;
    private TendencyReportUI tendencyUI;
    private PerformanceReportUI performanceUI;
}