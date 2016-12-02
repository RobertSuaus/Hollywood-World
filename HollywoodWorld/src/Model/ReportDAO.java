/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Reynaldo Marrufo
 */
public class ReportDAO extends BaseDAO{
    
    public static ProfitReport getRegistryRents(String employeeName, Date startDate, Date endDate){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        String sqlProfit = "SELECT folio, totalRent+additionalCost FROM"+
                "rentalorder WHERE transactionDate <= '$endDate$' AND"+
                "transactionDate >= '$startDate$'";
        sqlProfit = sqlProfit.replace("$startDate$", dateFormat.format(startDate));
        sqlProfit = sqlProfit.replace("$endDate$", dateFormat.format(endDate));
        
        String sqlAvg = "SELECT SUM(totalRent+additionalCost),"+
                "AVG(totalRent+additionalCost) FROM rentalorder"+
                "WHERE transactionDate <= '$endDate$' AND"+
                "transactionDate >= '$startDate$'";
        sqlAvg = sqlAvg.replace("$startDate$", dateFormat.format(startDate));
        sqlAvg = sqlAvg.replace("$endDate$", dateFormat.format(endDate));
        
        
        ProfitReport profitReport = new ProfitReport(
            employeeName,
            startDate,
            endDate
        );
        
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlProfit);
            ArrayList<String[]> registryList = new ArrayList<String[]>();
            while(resultSet.next()){
                
                String[] registry = {
                    String.valueOf(resultSet.getInt(1)),
                    String.valueOf(resultSet.getDouble(2))
                };
                registryList.add(registry);
            }
            profitReport.setRegistryList(registryList);
            resultSet = statement.executeQuery(sqlAvg);
            resultSet.next();
            profitReport.setTotalProfit(resultSet.getDouble(1));
            profitReport.setAverageProfit(resultSet.getDouble(2));
            return profitReport;
        }catch(SQLException ex){
            System.err.println("Error al obtener registros"+ ex.getMessage());
            JOptionPane.showMessageDialog(null,"Error al obtener registros",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return profitReport;
        }
    }
    
    public static TendencyReport getRegistryMovie(String employeeName, Date startDate, Date endDate){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        String sql = "SELECT lease.movieTitle, COUNT(lease.movieTitle)"+
            "FROM lease LEFT JOIN rentalorder USING (folio)" +
            "WHERE transactionDate <= '$endDate$' AND"+
            "transactionDate >= '$startDate$' " +
            "GROUP BY movieTitle ORDER BY COUNT(movieTitle) DESC";
        sql = sql.replace("$startDate$", dateFormat.format(startDate));
        sql = sql.replace("$endDate$", dateFormat.format(endDate));
        
        TendencyReport tendencyReport = new TendencyReport(
            employeeName,
            startDate,
            endDate
        );
        
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            ArrayList<String[]> registryList = new ArrayList<String[]>();
            while(resultSet.next()){
                
                String[] registry = {
                    resultSet.getString(1),
                    String.valueOf(resultSet.getInt(2))
                };
                registryList.add(registry);
            }
            
            tendencyReport.setRegistryList(registryList);
            tendencyReport.setMostRentedMovie(registryList.get(0)[0]);
            return tendencyReport;
            
        }catch(SQLException ex){
            System.err.println("Error al obtener registros"+ ex.getMessage());
            JOptionPane.showMessageDialog(null,"Error al obtener registros",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return tendencyReport;
        }
        
    }
    
    public static PerformanceReport getRegistryEmployee(String employeeName, Date startDate, Date endDate){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        String sql = "SELECT employeeName,COUNT(employeeName)"+
            "FROM `rentalorder`"+ 
            "WHERE transactionDate <= '$endDate$' AND"+ 
            "transactionDate >= '$startDate$'"+
            "GROUP BY employeeName ORDER BY COUNT(employeeName) DESC";
        sql = sql.replace("$startDate$", dateFormat.format(startDate));
        sql = sql.replace("$endDate$", dateFormat.format(endDate));
        
        PerformanceReport performanceReport = new PerformanceReport(
            employeeName,
            startDate,
            endDate
        );
        
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            ArrayList<String[]> registryList = new ArrayList<String[]>();
            while(resultSet.next()){
                
                String[] registry = {
                    resultSet.getString(1),
                    String.valueOf(resultSet.getInt(2))
                };
                registryList.add(registry);
            }
            performanceReport.setRegistryList(registryList);
            performanceReport.setEmployeeMonth(registryList.get(0)[0]);
            
            return performanceReport;
            
        }catch(SQLException ex){
            System.err.println("Error al obtener registros"+ ex.getMessage());
            JOptionPane.showMessageDialog(null,"Error al obtener registros",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return performanceReport;
        }
    }
}
