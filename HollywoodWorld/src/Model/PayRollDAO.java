/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.BaseDAO.statement;
import java.sql.SQLException;
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
        
        String sql = "INSERT INTO desglose(desgloseId, employeeId, retencionISR"+
            ", retencionSeguroSocial, aguinaldo, primaVacacional, "+
            " diasTrabajados, primaDominical, totalPago, salarioIntegro, "+
            "fechaDesglose)VALUES($desgloseId$, $employeeId$, $retencionISR$, "+
            "$retencionSeguroSocial$, $aguinaldo$,$primaVvacacional$, "+
            "$primaDominical$,$totalPago$, $salarioIntegro$,$fechaDesglose$)";
        
        
        sql = sql.replace("$desgloseId$", String.valueOf(desglose.getDesgloseId()) );
        sql = sql.replace("$employeeId$", String.valueOf(desglose.getEmployeeId()));
        sql = sql.replace("$retencionSeguroSocial$", String.valueOf(desglose.getRetention().getTaxPerIMSS()));
        sql = sql.replace("$retencionISR$",String.valueOf(desglose.getRetention().getISR()));
        sql = sql.replace("$aguinaldo$", String.valueOf(desglose.getBonus().getChristmasBox()) );
        sql = sql.replace("$primaVacacional", String.valueOf(desglose.getBonus().getHolidayBonus()) );
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
    
    public ArrayList<PayrollBreakdown> getBreakdownSummary(Date desgloseDate){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        String sql = "SELECT * FROM desglose WHERE "+
            "fechaDesglose = '$desgloseDate$'";
        sql = sql.replace("$desgloseDate$",dateFormat.format(desgloseDate));
        
        return null;
    }
    
    public ArrayList<PayrollBreakdown> getBreakdownList(int employeeId){
        
        String sql = "SELECT * FROM desglose WHERE employeeId = '$employeeId$'";
        
        PayrollBreakdown desglose = new PayrollBreakdown();
        
        sql = sql.replace("$desgloseId$", String.valueOf(desglose.getDesgloseId()) );
        sql = sql.replace("$employeeId$", String.valueOf(desglose.getEmployeeId()));
        sql = sql.replace("$retencionSeguroSocial$", String.valueOf(desglose.getRetention().getTaxPerIMSS()));
        sql = sql.replace("$retencionISR$",String.valueOf(desglose.getRetention().getISR()));
        sql = sql.replace("$aguinaldo$", String.valueOf(desglose.getBonus().getChristmasBox()) );
        sql = sql.replace("$primaVacacional", String.valueOf(desglose.getBonus().getHolidayBonus()) );
        sql = sql.replace("$diasTrabajados$", String.valueOf(desglose.getWorkedDays()) );
        sql = sql.replace("$primaDominical$", String.valueOf(desglose.getBonus().getDominical()) );
        sql = sql.replace("$totalPago$", String.valueOf(desglose.getTotalPay()) );
        sql = sql.replace("$salarioIntegro$", String.valueOf(desglose.getFullSalary()) );
        sql = sql.replace("$fechaDesglose$", String.valueOf(desglose.getDesgloseDate()));
        
        return null;
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
