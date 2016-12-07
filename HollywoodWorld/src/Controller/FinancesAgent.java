package Controller;

import Model.PerformanceReport;
import Model.ProfitReport;
import Model.TendencyReport;
import View.PerformanceReportForm;
import View.ProfitReportForm;
import View.TendencyReportForm;
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
    
    public FinancesAgent(ProfitReportForm profitReportForm){
        
        this.profitReportForm = profitReportForm;
        //Crear reporte con datos iniciales conocidos
    }
    
    public FinancesAgent(TendencyReportForm tendencyReportForm){
        
        this.tendencyReportForm = tendencyReportForm;
        //Crear reporte con datos iniciales conocidos
    }
    
    public FinancesAgent(PerformanceReportForm performanceReportForm){
        
        this.performanceReportForm = performanceReportForm;
        //Crear reporte con datos iniciales conocidos
    }
    
    public void requestProfitReport(Date startDateInput, Date endDateInput){
        
        if(isDateInputNotEmpty(startDateInput, endDateInput ) ){
            if(isDateRangeValid(startDateInput, endDateInput) ){
                
                //Entregar la solicitud al analista para que sea llenado
                ProfitReport profitReport = FinancesManager.fillProfitReport(
                    startDateInput,
                    endDateInput
                );
                
                //Desplegar resultado al usuario
                profitReportForm.fillReportFields(profitReport);
            }
        }
    }
    
    public void requestTendencyReport(Date startDateInput, Date endDateInput){
        
        if(isDateInputNotEmpty(startDateInput, endDateInput ) ){
            if(isDateRangeValid(startDateInput, endDateInput) ){
                
                //Entregar la solicitud al analista para que sea llenado
                TendencyReport tendencyReport = FinancesManager.fillTendencyReport(
                    startDateInput,
                    endDateInput
                );
                
                //Desplegar resultado al usuario
                tendencyReportForm.fillReportFields(tendencyReport);
            }
        }
    }
    
    public void requestPerformanceReport(Date startDateInput, Date endDateInput){
        
        if(isDateInputNotEmpty(startDateInput, endDateInput ) ){
            if(isDateRangeValid(startDateInput, endDateInput) ){
                
                //Entregar la solicitud al analista para que sea llenado
                PerformanceReport performanceReport = FinancesManager.fillPerformanceReport(
                    startDateInput,
                    endDateInput
                );
                
                //Desplegar resultado al usuario
                performanceReportForm.fillReportFields(performanceReport);
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
    
    //private String employeeName;
    private ProfitReportForm profitReportForm;
    private TendencyReportForm tendencyReportForm;
    private PerformanceReportForm performanceReportForm;
}