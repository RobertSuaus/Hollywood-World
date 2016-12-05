/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.BaseDAO.statement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Reynaldo Marrufo
 */
public class PayRollDAO extends BaseDAO {
    
    public static int save(PayrollBreakdown desglose ){
        
        String sql = "INSERT INTO desglose(desgloseId, employeeId, ISR"+
            ", seguro, aguinaldo, vacaciones, "+
            "diasTrabajados, primaDominical, totalPago, salarioIntegro, "+
            "fechaDesglose)VALUES($desgloseId$, $employeeId$, $ISR$, "+
            "$seguro$, $aguinaldo$,$vacaciones$, "+
            "$primaDominical$, $totalPago$, $salarioIntegro$, $fechaDesglose$)";
        
        
        sql = sql.replace("$desgloseId$", String.valueOf(desglose.getDesgloseId()) );
        sql = sql.replace("$employeeId$", String.valueOf(desglose.getEmployeeId()));
         sql = sql.replace("$ISR$",String.valueOf(desglose.getRetention().getISR()));
        sql = sql.replace("$seguroS$", String.valueOf(desglose.getRetention().getTaxPerIMSS()));
        sql = sql.replace("$aguinaldo$", String.valueOf(desglose.getBonus().getChristmasBox()) );
        sql = sql.replace("$vacaciones", String.valueOf(desglose.getBonus().getHolidayBonus()) );
        sql = sql.replace("$diasTrabajados$", String.valueOf(desglose.getWorkedDays()) );
        sql = sql.replace("$primaDominical$", String.valueOf(desglose.getBonus().getDominical()) );
        sql = sql.replace("$totalPago$", String.valueOf(desglose.getTotalPay()) );
        sql = sql.replace("$salarioIntegro$", String.valueOf(desglose.getFullSalary()) );
        sql = sql.replace("$fechaDesglose$", String.valueOf(desglose.getDesgloseDate()));
        
        try{
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            return SUCCESS;
        }catch(SQLException ex){
            System.err.println("Error al guardar datos del desglose"+ ex.getMessage());
            JOptionPane.showMessageDialog(null,"Error al guardar datos del desglose",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return ERROR;
        }
        
    }
    
    public String[] getBreakdownSummary(Date startDate, Date endDate){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        String sql = "SELECT"+
            "SUM(ISR), "+
            "SUM(seguro), "+
            "SUM(aguinaldo), "+
            "SUM(vacaciones), "+
            "SUM(primaDominical), "+
            "SUM(diasTrabajados), "+
            "SUM(totalPago), "+
            "SUM(salarioIntegro) "+
            "FROM desglose WHERE "+
            "fechaDesglose >= '$StartDate$' AND fechaDesglose <= '$endDate$'";
        String[] registry = new String[8];
        
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            resultSet.next();
            
            registry[0] = String.valueOf(resultSet.getDouble(1));
            registry[1] = String.valueOf(resultSet.getDouble(2));
            registry[2] = String.valueOf(resultSet.getDouble(3));
            registry[3] = String.valueOf(resultSet.getDouble(4));
            registry[4] = String.valueOf(resultSet.getInt(5));
            registry[5] = String.valueOf(resultSet.getDouble(6));
            registry[6] = String.valueOf(resultSet.getDouble(7));
            registry[7] = String.valueOf(resultSet.getDouble(8));
            
            return registry;
        }catch(SQLException ex){
            System.err.println("Error al obtener registros"+ ex.getMessage());
            JOptionPane.showMessageDialog(null,"Error al obtener registros",
                "Error", JOptionPane.ERROR_MESSAGE);
            return registry;
        }
    }
    
    public ArrayList<PayrollBreakdown> getBreakdownList(int employeeId) throws ParseException{
        
        String sql = "SELECT * FROM desglose WHERE employeeId = '$employeeId$'";
        
        sql = sql.replace("$employeeId$", String.valueOf("employeeId"));
        ArrayList<PayrollBreakdown> kardex = new ArrayList<PayrollBreakdown>();
        
        try{
           SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
           statement = connection.createStatement();
           resultSet = statement.executeQuery(sql);
           while(resultSet.next()){
               PayrollBreakdown payrollBreakdown = new PayrollBreakdown(
                   resultSet.getInt("desgloseId"),
                   resultSet.getInt("employeeId"),
                   new Retention(
                       resultSet.getDouble("ISR"),
                       resultSet.getDouble("seguro")
                   ),
                   new Bonus(
                       resultSet.getDouble("aguinaldo"),
                       resultSet.getDouble("primaVacacional"),
                       resultSet.getDouble("primaDominical")
                   ),
                   resultSet.getInt("diasTrabajados"),
                   resultSet.getDouble("totalPago"),
                   resultSet.getDouble("salarioIntegro"),
                   dateFormat.parse(resultSet.getString("fechaDesglose"))     
               );
            kardex.add(payrollBreakdown);
           }
           return kardex;
        }catch(SQLException ex){
            System.err.println("Error al obtener el ultimo registro " + 
                ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al obtener registro.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return kardex;
        }
        
    }
    
    public static int getLastRegistryIndex(){
        
        String sql ="SELECT * FROM desglose WHERE desgloseId ="+
            " (SELECT MAX(desgloseId)  FROM desglose)";
        int lastId;
        
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            if(!resultSet.first()) return 0; //Si no hay registros, empezar en 0
            lastId = resultSet.getInt("desgloseId");
            return lastId;
        }catch(SQLException ex){
            System.err.println("Error al obtener el ultimo registro " + 
                ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al obtener registro.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return ERROR;
        } 
        
    }
    
}
