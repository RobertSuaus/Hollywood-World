/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.BaseDAO.statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        
        String sql = "INSERT INTO rentalorder(folio, employeeName, membership_id, clientName,"
                + "transactionDate, returnDate, totalRent, status) VALUES("
                + "'$folio$', '$employeeName$', '$membership_id$', '$clientName',"
                + "'$transactionDate$', '$returnDate$', '$totalRent$'"
                + "'$status$' )";
        sql = sql.replace("$folio$",String.valueOf(rentalOrder.getFolio()));
        sql = sql.replace("$employeeName$", rentalOrder.getEmployeeName());
        sql = sql.replace("$employeeName$", String.valueOf(rentalOrder.getMembershipId()));
        sql = sql.replace("$employeeName$", rentalOrder.getClientName());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        sql = sql.replace("$releaseDate$", dateFormat.
                format(rentalOrder.getTransactionDate()) );
        sql = sql.replace("$releaseDate$", dateFormat.
                format(rentalOrder.getReturnDate()) );
        sql = sql.replace("$employeeName$", String.valueOf(rentalOrder.getTotalRent()));
        sql = sql.replace("$status$", "Pendiente");
        
        sql = "INSERT INTO lease(folio, movieId, movieTitle, price) VALUES(?, ?, ?, ?)";
       try{
            PreparedStatement ps = connection.prepareStatement(sql);
            for (Lease lease : rentalOrder.getLeases() ){
               ps.setInt(1, rentalOrder.getFolio());
               ps.setInt(2, lease.getMovieId());
               ps.setString(3, lease.getMovieTitle());
               ps.setDouble(4, lease.getPrice());
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
        String sql = "UPDATE rentalorder SET folio = '$folio$','$status$'";
        
        sql = sql.replace("$status$", "Terminado");
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
    
    public static RentalOrder obtainRegistry(int membershipId){
        //obtener todo el objeto RentalOrder
        //generar todos los datos
        String sql = "SELECT * FROM rentalorder WHERE"
                + " membershipId = $membershipId$";
        
        
        sql = "SELECT * FROM lease WHERE folio = $folio$";
       RentalOrder rentalOrder = null;
       ArrayList<Lease> leases = null;
       
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                leases.add(new Lease(
                resultSet.getInt("movieId"),
                resultSet.getString("movieTitle"),
                resultSet.getDouble("price")));
            }
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat dateReturn = new SimpleDateFormat("yyyy-MM-dd");
            Date transactionDate = new Date();
            Date returnDate = new Date();
            rentalOrder = new RentalOrder(
                resultSet.getInt("folio"),
                resultSet.getString("employeeName"),
                resultSet.getInt("membership_id"),
                resultSet.getString("clientName"),
                dateFormat.parse(resultSet.getString("transactionDate")),
                dateReturn.parse(resultSet.getString("returnDate")),
                resultSet.getDouble("totalRent")
                );
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
                "folio ='$folio$'";
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
    
    public static int getLastRegistryIndex(){
        
        String sql = "SELECT * FROM  rentalorder WHERE folio ="+
                " (SELECT MAX(folio) FROM folio)";
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
