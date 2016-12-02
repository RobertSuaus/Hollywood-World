/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.PerformanceReport;
import Model.ProfitReport;
import Model.ReportDAO;
import Model.TendencyReport;
import java.util.Date;

/**
 *
 * @author Robert
 */
public class BusinessAnalyst {
    /*El Analista de negocio se encarga de llenar los reportes solicitados 
    por los agentes de finanzas con los datos correspondientes del negocio.*/
    
    public static ProfitReport fillProfitReport(
        String employeeName,
        Date startDate,
        Date endDate
    ){
        return ReportDAO.getRegistryRents(employeeName, startDate, endDate);
    }
    
    public static TendencyReport fillTendencyReport(
        String employeeName,
        Date startDate,
        Date endDate
    ){
        return ReportDAO.getRegistryMovie(employeeName, startDate, endDate);
    }
    
    public static PerformanceReport fillPerformanceReport(
        String employeeName,
        Date startDate,
        Date endDate
    ){
        return ReportDAO.getRegistryEmployee(employeeName, startDate, endDate);
    }
}
