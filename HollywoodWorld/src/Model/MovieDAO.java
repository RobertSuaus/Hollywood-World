package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Reynaldo Marrufo
 */
public class MovieDAO {
    
    public MovieDAO(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/hollywood_world?autoReconnect=true&useSSL=false",
                "root",
                ""
            );
        }catch(Exception error){
            error.printStackTrace();
        }
    }
    
    public int addMovieToInventory(Movie movie, int amount){
        
        String sql = "INSERT INTO inventory(id_box, serialCode) VALUES(?, ?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            for(int numberOfCopy = 0; numberOfCopy < amount; numberOfCopy++){
                ps.setInt(1, movie.getId() + numberOfCopy);
                ps.setString(2, movie.getProfile().getSerialCode());
                ps.addBatch();
            }
            ps.executeBatch();
            return StatusValidator.SUCCESS;
        }catch(SQLException ex){
            System.err.println("Error al guardar perfil de película"+ ex.getMessage());
            JOptionPane.showMessageDialog(null,"Error al guardar perfil",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return StatusValidator.ERROR;
        }
        
        
    }
    
    public int addMovieProfile(MovieProfile movieProfile){
        
        String sql = "INSERT INTO movie(serialCode, title, releaseDate, rating,"+
                " description, runtime) VALUES("+
                "'$serialCode$', '$title$', '$releaseDate$', '$rating$',"+ 
                " '$description$', '$runtime$');" ;
        
        sql = sql.replace("$serialCode$", movieProfile.getSerialCode() );
        sql = sql.replace("$title$", movieProfile.getTitle() );
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        sql = sql.replace("$releaseDate$", dateFormat.
                format(movieProfile.getReleaseDate() ) );
        
        sql = sql.replace("$rating$", movieProfile.getRating() );
        sql = sql.replace("$description$", movieProfile.getDescription() );
        sql = sql.replace("$runtime$", movieProfile.getRunTime() );
        
        try{
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            return StatusValidator.SUCCESS;
        }catch(SQLException ex){
            System.err.println("Error al guardar perfil de película"+ ex.getMessage());
            JOptionPane.showMessageDialog(null,"Error al guardar perfil",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return StatusValidator.ERROR;
        }
    }
    
    public int modifyMovieProfile(MovieProfile movieProfile){
        
        String sql = "UPDATE movie SET title = '$title$'," + 
                " releaseDate = '$releaseDate$', rating = '$rating$',"+
                " description = '$description$', runtime = '$runtime$'"+
                " WHERE serialCode = '$serialCode$'";
        
        sql = sql.replace("$title$", movieProfile.getTitle() );
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        sql = sql.replace("$releaseDate$", dateFormat.
                format(movieProfile.getReleaseDate() ) );
        sql = sql.replace("$rating$", movieProfile.getRating() );
        sql = sql.replace("$description$", movieProfile.getDescription() );
        sql = sql.replace("$runtime$", movieProfile.getRunTime() );
        sql = sql.replace("$serialCode$", movieProfile.getSerialCode() );
        
        try{
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            return StatusValidator.SUCCESS;
        }catch(SQLException ex){
            System.err.println("Error al actualizar perfil"+ ex.getMessage());
            JOptionPane.showMessageDialog(null,"Error al actualizar perfil",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return StatusValidator.ERROR;
        }
    }
    
    public int getLastMovieId(){
        
        String sql = "SELECT * FROM  inventory WHERE id_box ="+
                " (SELECT MAX(id_box)  FROM inventory)";
        int lastId;
        
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            resultSet.next();
            lastId = resultSet.getInt("id_box");
            return lastId;
        }catch(SQLException ex){
            System.err.println("Error al obtener el ultimo registro " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al obtener registro.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return StatusValidator.ERROR;
        } 
    }
    
    public MovieProfile getProfileInfo(String serialCode) throws ParseException{
        String sql = "SELECT * FROM movie WHERE"
                + " serialCode = '$serialCode$'";
        sql = sql.replace("$serialCode$", serialCode );
        MovieProfile movieProfile = null;
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            resultSet.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date releaseDate = new Date();
            movieProfile = new MovieProfile(
                resultSet.getString("title"),
                releaseDate = dateFormat.
                        parse(resultSet.getString("releaseDate")),
                resultSet.getString("rating"),
                resultSet.getString("description"),
                resultSet.getString("runtime"),
                resultSet.getString("serialCode")
                );
            return movieProfile;
        }catch(SQLException ex){
            System.err.println("Error al obtener el ultimo registro " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al obtener registro.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return movieProfile;
        }
    }
    
    public Movie getMovieInfo(){
        return null;
        
    }
    
    public boolean isSerialCodeOccupied(String serialCode){
        
        boolean isOccupied;
        String sql = "SELECT * FROM movie WHERE "+
                "serialCode ='$serialCode$'";
        sql = sql.replace("$serialCode$", serialCode );
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
    
    public boolean isMovieIdOccupied(int movieId){
        
        boolean isOccupied;
        String sql = "SELECT * FROM client WHERE "+
                "id_box ='$movieId$'";
        sql = sql.replace("$movieId$", String.valueOf(movieId) );
        
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            isOccupied = resultSet.first();
        }catch(SQLException ex){
            System.err.println("Error al obtener datos de código de película"+ ex.getMessage());
            JOptionPane.showMessageDialog(null,"Error al obtener validación de código",
                    "Error", JOptionPane.ERROR_MESSAGE);
            isOccupied = false;
        }
        return isOccupied;
    }
    
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
}
