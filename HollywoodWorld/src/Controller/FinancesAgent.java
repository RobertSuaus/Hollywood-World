package Controller;

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
        //Crear reporte con datos iniciales conocidos
    }
    
    public FinancesAgent(TendencyReportUI tendencyUI, String userName){
        
        this.tendencyUI = tendencyUI;
        //Crear reporte con datos iniciales conocidos
    }
    
    public FinancesAgent(PerformanceReportUI performanceUI, String userName){
        
        this.performanceUI = performanceUI;
        //Crear reporte con datos iniciales conocidos
    }
    
    public void requestProfitReport(Date startDateInput, Date endDateInput){
        
        if(isDateInputNotEmpty(startDateInput, endDateInput ) ){
            if(isDateRangeValid(startDateInput, endDateInput) ){
                
                //Llenar datos iniciales de reporte
                ProfitReport profitReport = new ProfitReport();
                
                //Entregar el reporte al analista para que sea llenado
                profitReport = BusinessAnalyst.fillProfitReport(profitReport);
                
                //Desplegar resultado al usuario
                profitUI.fillReportFields(profitReport);
            }
        }
    }
    
    public void requestTendencyReport(Date startDateInput, Date endDateInput){
        
        if(isDateInputNotEmpty(startDateInput, endDateInput ) ){
            if(isDateRangeValid(startDateInput, endDateInput) ){
                
                //Llenar datos iniciales de reporte
                TendencyReport tendencyReport = new TendencyReport();
                
                //Entregar el reporte al analista para que sea llenado
                tendencyReport = BusinessAnalyst.fillTendencyReport(tendencyReport);
                
                //Desplegar resultado al usuario
                tendencyUI.fillReportFields(tendencyReport);
            }
        }
    }
    
    public void requestPerformanceReport(Date startDateInput, Date endDateInput){
        
        if(isDateInputNotEmpty(startDateInput, endDateInput ) ){
            if(isDateRangeValid(startDateInput, endDateInput) ){
                
                //Llenar datos iniciales de reporte
                PerformanceReport performanceReport = new PerformanceReport();
                
                //Entregar el reporte al analista para que sea llenado
                performanceReport = BusinessAnalyst.fillPerformanceReport(performanceReport);
                
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
        
        return true;
    }
    
    private ProfitReportUI profitUI;
    private TendencyReportUI tendencyUI;
    private PerformanceReportUI performanceUI;
}