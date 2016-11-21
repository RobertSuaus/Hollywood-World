/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.BaseDAO.statement;
import java.sql.PreparedStatement;
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
public class RentalOrderDAO extends BaseDAO {
    
    public static int save(RentalOrder rentalOrder){
        
        String sqlRentOrder = "INSERT INTO rentalorder(folio, employeeName, membership_id, clientName,"
                + "transactionDate, returnDate, totalRent, status) VALUES("
                + "$folio$, '$employeeName$', $membership_id$, '$clientName$',"
                + "'$transactionDate$', '$returnDate$', $totalRent$,"
                + "'$status$' )";
        sqlRentOrder = sqlRentOrder.replace("$folio$",String.valueOf(rentalOrder.getFolio()));
        sqlRentOrder = sqlRentOrder.replace("$employeeName$", rentalOrder.getEmployeeName());
        sqlRentOrder = sqlRentOrder.replace("$membership_id$", String.valueOf(rentalOrder.getMembershipId()));
        sqlRentOrder = sqlRentOrder.replace("$clientName$", rentalOrder.getClientName());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        sqlRentOrder = sqlRentOrder.replace("$transactionDate$", dateFormat.
                format(rentalOrder.getTransactionDate()) );
        sqlRentOrder = sqlRentOrder.replace("$returnDate$", dateFormat.
                format(rentalOrder.getReturnDate()) );
        sqlRentOrder = sqlRentOrder.replace("$totalRent$", String.valueOf(rentalOrder.getTotalRent()));
        sqlRentOrder = sqlRentOrder.replace("$status$", "Pendiente");
        
        String sqlLeases = "INSERT INTO lease(folio, movieId, movieTitle, price) VALUES(?, ?, ?, ?)";
       try{
           statement = connection.createStatement();
           statement.executeUpdate(sqlRentOrder);
           
           PreparedStatement ps = connection.prepareStatement(sqlLeases);
            for (Lease lease : rentalOrder.getLeases() ){
               ps.setInt(1, rentalOrder.getFolio());
               ps.setInt(2, lease.getMovieId());
               ps.setString(3, lease.getMovieTitle());
               ps.setDouble(4, lease.getPrice());
               ps.addBatch();
            }
            ps.executeBatch();
            return SUCCESS;
        }catch(SQLException ex){
            System.err.println("Error al guardar película"+ ex.getMessage());
            JOptionPane.showMessageDialog(null,"Error al guardar película",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return ERROR;
        }
    }
    
    public static int update(int folio){
        String sql = "UPDATE rentalorder SET status = 'Terminado' WHERE " +
                "folio = $folio$";
        
        sql = sql.replace("$folio$", String.valueOf(folio) );
        try{
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            return SUCCESS;
        }catch(SQLException ex){
            System.err.println("Error al actualizar renta"+ ex.getMessage());
            JOptionPane.showMessageDialog(null,"Error al actualizar renta",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return ERROR;
        }
        
        
    }
    
    public static RentalOrder obtainRegistry(int membershipId) throws ParseException{
        //obtener todo el objeto RentalOrder
        //generar todos los datos
        String sqlRentalOrder = "SELECT * FROM rentalorder WHERE" +
                " membership_Id = $membershipId$ AND Status = 'Pendiente'";
        sqlRentalOrder = sqlRentalOrder.replace("$membershipId$", String.valueOf(membershipId) );
        
       RentalOrder rentalOrder = null;
       ArrayList<Lease> leases = new ArrayList<Lease>();
       
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlRentalOrder);
            resultSet.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            rentalOrder = new RentalOrder(
               resultSet.getInt("folio"),
               resultSet.getString("employeeName"),
               resultSet.getInt("membership_id"),
               resultSet.getString("clientName"),
               dateFormat.parse(resultSet.getString("transactionDate")),
               dateFormat.parse(resultSet.getString("returnDate")),
               resultSet.getDouble("totalRent")
            );
            
            String sqlLease = "SELECT * FROM lease WHERE folio = $folio$";
            sqlLease = sqlLease.replace("$folio$", String.valueOf(rentalOrder.getFolio() ) );
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlLease);
            while(resultSet.next()){
                leases.add(new Lease(
                resultSet.getInt("movieId"),
                resultSet.getString("movieTitle"),
                resultSet.getDouble("price")));
            }
            
            
            rentalOrder.setLeases(leases);
            return rentalOrder;
            
        }catch(SQLException ex){
            System.err.println("Error al obtener información de la orden de renta"+ ex.getMessage());
            JOptionPane.showMessageDialog(null,"Error al obtener información de la orden de renta",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return rentalOrder;
        }
        
    }
    
    public static boolean registryExists(int folio){
        boolean isOccupied;
        String sql = "SELECT * FROM rentalorder WHERE "+
                "folio =$folio$";
        sql = sql.replace("$folio$", String.valueOf(folio) );
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            isOccupied = resultSet.first();
        }catch(SQLException ex){
            System.err.println("Error al obtener registro"+ ex.getMessage());
            JOptionPane.showMessageDialog(null,"Error al obtener registro",
                    "Error", JOptionPane.ERROR_MESSAGE);
            isOccupied = false;
        }
        return isOccupied;
    }
    
    public static boolean registryExists(int membershipId, String status){
        
        String sql = "SELECT * FROM rentalorder WHERE" +
                " membership_Id = $membershipId$ AND status = '$status$'";
        sql = sql.replace("$membershipId$", String.valueOf(membershipId) );
        sql = sql.replace("$status$", status );
        boolean exists = false;
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            exists = resultSet.first();
        }catch(SQLException ex){
            System.err.println("Error al obtener registro"+ ex.getMessage());
            JOptionPane.showMessageDialog(null,"Error al obtener registro",
                    "Error", JOptionPane.ERROR_MESSAGE);
            exists = false;
        }
        return exists;
    }
    
    public static int getLastRegistryIndex(){
        
        String sql = "SELECT * FROM  rentalorder WHERE folio ="+
                " (SELECT MAX(folio) FROM rentalorder)";
        int lastId;
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            if(!resultSet.first()) return 0; //Si no hay registros, empezar en 0
            lastId = resultSet.getInt("folio");
            return lastId;
        }catch(SQLException ex){
            System.err.println("Error al obtener el ultimo registro " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al obtener registro.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return ERROR;
        }   
    }
}
